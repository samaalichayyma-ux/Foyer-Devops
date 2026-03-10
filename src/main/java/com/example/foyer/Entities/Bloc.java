package com.example.foyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Data (remplacce tous les annotation au dessous , mais faire beaucoup de probleme)

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE) // pour ne pas ecrire private devant chaque attribut
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idBloc;

     long capaciteBloc;

     String nomBloc;

     @ManyToOne
     private Foyer foyer;

     @OneToMany(mappedBy = "blocs")
    private Set<Chambre> chambre;



}
