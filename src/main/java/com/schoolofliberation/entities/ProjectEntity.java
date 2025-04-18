package com.schoolofliberation.entities;

import java.sql.Timestamp;

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

    private String projectName;

    private Integer priceOfDollar;

    private String time;

    private String description;

    private Double timeInDouble;

    private Double projectPrice;

    private Timestamp createDate;

    private Timestamp modificateDate;
    
    private Timestamp deleteDate;

}
