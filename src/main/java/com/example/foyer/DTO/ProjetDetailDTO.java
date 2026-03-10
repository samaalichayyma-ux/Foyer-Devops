package com.example.foyer.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProjetDetailDTO {
    private String description;
    private String technologie;
    private String dateDebut; //champ a formaté
}
