/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jgl.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Gabi
 */
public class LoginUsuario {

    @NotBlank
    private String NombreUsuario;
    @NotBlank
    private String password;
    //GEtter Setter

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
