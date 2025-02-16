package com.schoolofliberation.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProyectEntity {

    private Long id;

    private String nameProyect;

    private Integer priceInDollars;

    private Double time;

    private Double priceProyect;

    private LocalDate createDate;

    private LocalDate modificateDate;

}
