package com.schoolofliberation.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.schoolofliberation.config.db.JdbcUtil;
import com.schoolofliberation.entities.ProjectEntity;

public class ProjectRepository {

    public List<ProjectEntity> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT id, project_name, description, price_of_dollar, time, time_in_double, project_price, create_date, modificate_date, delete_date FROM projects";

        try {
            Connection connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            List<ProjectEntity> projectList = new ArrayList<>();

            while (resultSet.next()) {
                ProjectEntity projectEntity = new ProjectEntity();
                projectEntity.setId(resultSet.getLong("id"));
                projectEntity.setProjectName(resultSet.getString("project_name"));
                projectEntity.setTime(resultSet.getString("time"));
                projectEntity.setTimeInDouble(resultSet.getDouble("time_in_double"));
                projectEntity.setProjectPrice(resultSet.getDouble("project_price"));
                projectEntity.setPriceOfDollar(resultSet.getInt("price_of_dollar"));
                projectEntity.setCreateDate(resultSet.getTimestamp("create_date"));
                projectList.add(projectEntity);
            }

            return projectList;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save(final ProjectEntity projectEntity) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO projects (project_name,price_of_dollar,project_price,time_in_double,time) VALUES (?,?,?,?,?)";

        try {
            Connection connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, projectEntity.getProjectName());
            preparedStatement.setInt(2, projectEntity.getPriceOfDollar());
            preparedStatement.setDouble(3, projectEntity.getProjectPrice());
            preparedStatement.setDouble(4, projectEntity.getTimeInDouble());
            preparedStatement.setString(5, projectEntity.getTime());

            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    projectEntity.setId(id);
                }
            } else {
                throw new RuntimeException("Error into insert");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(final ProjectEntity projectEntity) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE projects SET price_of_dollar = ?,project_price = ? WHERE id = ?";

        try {
            Connection connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, projectEntity.getPriceOfDollar());
            preparedStatement.setDouble(2, projectEntity.getProjectPrice());
            preparedStatement.setLong(3, projectEntity.getId());

            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Error into update");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
