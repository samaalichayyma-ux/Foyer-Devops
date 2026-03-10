package com.example.foyer.Repositories;

import com.example.foyer.Entities.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjetDetailRepo extends JpaRepository<ProjetDetail, Long> {
}
