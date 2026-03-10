package com.example.foyer.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProjetDetailDTOAuto {
    private String desc;
    private String tech;
    private String dateD; //champ a formaté
}