/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.user.repository;

import com.mycompany.login.conection.MySqlDBConection;
import com.mycompany.login.user.model.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class UserRepository implements IUserRepository {

    private final static String QUERY_LOGIN = new StringBuilder()
            .append(" SELECT id_user, user_name, password FROM user WHERE user_name = '%s' AND password = '%s' ")
            .toString();
    
    @Override
    public UserEntity getByLogin(String user, String password) throws SQLException {
        UserEntity response = new UserEntity();
        try (MySqlDBConection db = MySqlDBConection.getInstance()) {
            ResultSet result = db.executeQuery(String.format(QUERY_LOGIN, user, password));
            while (result.next()){
                response.setId(result.getInt("id_user"));
                response.setUserName(result.getString("user_name"));
                response.setPassword(result.getString("password"));


            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return response; 
    }
}
