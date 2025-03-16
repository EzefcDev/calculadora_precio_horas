package com.schoolofliberation.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectEntity {

    private Long id;

    private String nameProyect;

    private Integer priceInDollars;

    private Double time;

    private Double priceProyect;

    private LocalDate createDate;

    private LocalDate modificateDate;

}
