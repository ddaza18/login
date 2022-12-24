/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.user.model;

import java.io.Serializable;

/**
 *
 * @author Daniel Daza Vergara - Aprendiz SENA
 */
public class UserEntity implements Serializable {
//IMPLEMENTAMOS SERIALIZABLE Y REALIZAMOS EL MODELO DE USER
    private Integer id;
    private String userName;
    private String Password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
