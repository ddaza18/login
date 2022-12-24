/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.login.user.repository;

import com.mycompany.login.user.model.UserEntity;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public interface IUserRepository {
    UserEntity getByLogin(final String user, final String password) throws SQLException;
}
