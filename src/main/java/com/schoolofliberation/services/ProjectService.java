package com.schoolofliberation.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.schoolofliberation.entities.ProjectEntity;

import lombok.extern.java.Log;

@Log
public class ProjectService {

    static List<ProjectEntity> projectEntities = new ArrayList<>();
    
        public static ProjectEntity setProjectEntity(final String name, final int dollar, final double price, final double time) {
            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity.setNameProyect(name);
            projectEntity.setPriceInDollars(dollar);
            projectEntity.setPriceProyect(price);
            projectEntity.setTime(time);
            projectEntity.setCreateDate(LocalDate.now());
            log.info("Proyecto creado: " + projectEntity.toString());
            return projectEntity;
        }
    
        public static void saveProjectEntity(ProjectEntity projectEntity) {
            log.info("Proyecto guardado: " + projectEntity.toString());
            projectEntities.add(projectEntity);
    }

    public static List<ProjectEntity> getAllProjectEntity() {
        log.info("Proyectos obtenidos");
        return projectEntities;
    }

}
