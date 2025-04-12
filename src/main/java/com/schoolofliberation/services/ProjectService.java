package com.schoolofliberation.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.schoolofliberation.entities.ProjectEntity;

import lombok.extern.java.Log;

@Log
public class ProjectService {

    static List<ProjectEntity> projectEntities = new ArrayList<>();
    
    public static ProjectEntity setProjectEntity(final String name, final int dollar, final double price, final double time, final String timeString) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(projectEntities.size() + 1L);
        projectEntity.setProjectName(name);
        projectEntity.setPriceOfDollar(dollar);
        projectEntity.setProjectPrice(price);
        projectEntity.setTimeInDouble(time);
        projectEntity.setTime(timeString);
        projectEntity.setCreateDate(LocalDate.now());
        log.info("Proyecto creado: " + projectEntity.toString());
        return projectEntity;
    }
    
    public static void saveProjectEntity(final ProjectEntity projectEntity) {
        log.info("Proyecto guardado: " + projectEntity.toString());
        projectEntities.add(projectEntity);
    }

    public static List<ProjectEntity> getAllProjectEntity() {
        log.info("Proyectos obtenidos");
        return projectEntities;
    }

    public static void updateProjectEntity(final ProjectEntity projectEntityUpdate) {
        for (ProjectEntity projectEntity : projectEntities) {
            if (projectEntity.getId().equals(projectEntityUpdate.getId())) {
                projectEntity.setProjectPrice(projectEntityUpdate.getProjectPrice());
                projectEntity.setPriceOfDollar(projectEntityUpdate.getPriceOfDollar());
                projectEntity.setModificateDate(LocalDate.now());
            }
        }
    }

}
