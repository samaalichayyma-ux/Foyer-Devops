pipeline {
    agent any

    tools {
        maven 'M2_HOME'
    }

    environment {
        IMAGE_NAME = 'chaymadevops/foyer-app'
        IMAGE_TAG = 'latest'
        KUBECONFIG = '/var/lib/jenkins/.kube/config'
    }

    stages {

        stage('CLEAN WORKSPACE') {
            steps {
                deleteDir()
            }
        }

        stage('HELLO') {
            steps {
                echo 'Hello World'
            }
        }

        stage('GIT') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/samaalichayyma-ux/Foyer-Devops.git'
            }
        }

        stage('MAVEN VERSION') {
            steps {
                sh 'mvn -version'
            }
        }

        stage('BUILD') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('TEST') {
            steps {
                sh 'mvn test'
            }
        }

        stage('MVN SONARQUBE') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    withCredentials([string(credentialsId: 'sonarToken', variable: 'SONAR_TOKEN')]) {
                        sh '''
                            mvn org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar \
                            -Dsonar.login=$SONAR_TOKEN
                        '''
                    }
                }
            }
        }

        stage('PACKAGE') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('DOCKER BUILD') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('DOCKER LOGIN') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('DOCKER PUSH') {
            steps {
                sh '''
docker push chaymadevops/foyer-app:latest || echo "Docker push failed, continuing..."
'''
            }
        }

        stage('K8S DEPLOY') {
            steps {
                sh 'kubectl apply -f k8s/namespace.yaml'
                sh 'kubectl apply -f k8s/mysql-secret.yaml'
                sh 'kubectl apply -f k8s/mysql-pvc.yaml'
                sh 'kubectl apply -f k8s/mysql-deployment.yaml'
                sh 'kubectl apply -f k8s/mysql-service.yaml'
                sh 'kubectl apply -f k8s/foyer-configmap.yaml'
                sh 'kubectl apply -f k8s/foyer-secret.yaml'
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }

       stage('K8S MONITORING NAMESPACE') {
    steps {
        sh 'kubectl apply -f monitoring/namespace.yaml'
    }
}

stage('K8S KUBE STATE METRICS') {
    steps {
        sh 'kubectl apply -f monitoring/kube-state-metrics-rbac.yaml'
        sh 'kubectl apply -f monitoring/kube-state-metrics-deployment.yaml'
    }
}

stage('K8S NODE EXPORTER') {
    steps {
        sh 'kubectl apply -f monitoring/node-exporter.yaml'
    }
}

stage('K8S PROMETHEUS') {
    steps {
        sh 'kubectl apply -f monitoring/prometheus-configmap.yaml'
        sh 'kubectl apply -f monitoring/prometheus-deployment.yaml'
        sh 'kubectl apply -f monitoring/prometheus-service.yaml'
    }
}

stage('K8S GRAFANA') {
    steps {
        sh 'kubectl apply -f monitoring/grafana-deployment.yaml'
        sh 'kubectl apply -f monitoring/grafana-service.yaml'
    }
}
    }
}
