package com.schoolofliberation.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.schoolofliberation.config.db.JdbcUtil;
import com.schoolofliberation.entities.ProjectEntity;
import com.schoolofliberation.repositories.ProjectRepository;

import lombok.extern.java.Log;

@Log
public class ProjectService {
    
    public static ProjectEntity setProjectEntity(final String name, final int dollar, final double price, final double time, final String timeString) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName(name);
        projectEntity.setPriceOfDollar(dollar);
        projectEntity.setProjectPrice(price);
        projectEntity.setTimeInDouble(time);
        projectEntity.setTime(timeString);
        log.info("Proyecto creado: " + projectEntity.toString());
        return projectEntity;
    }
    
    public static void saveProjectEntity(final ProjectEntity projectEntity) throws SQLException  {
        ProjectRepository projectRepository = new ProjectRepository();
        projectRepository.save(projectEntity);
        Connection connection = JdbcUtil.getConnection();
        connection.setAutoCommit(false);
        connection.commit();
        log.info("Proyecto guardado: " + projectEntity.toString());
    }

    public static void updateProjectEntity(final ProjectEntity projectEntityUpdate) throws SQLException {
        ProjectRepository projectRepository = new ProjectRepository();
        projectRepository.update(projectEntityUpdate);
        Connection connection = JdbcUtil.getConnection();
        connection.setAutoCommit(false);
        connection.commit();
        log.info("Proyecto actualizado: " + projectEntityUpdate.toString());
    }

}
