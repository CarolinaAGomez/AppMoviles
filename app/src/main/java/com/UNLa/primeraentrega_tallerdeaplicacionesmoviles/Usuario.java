package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.jetbrains.annotations.Nullable;

@DatabaseTable(tableName = "usuario")
public class Usuario {

    @DatabaseField(id = true)
    @Nullable
    String usuario;

    @DatabaseField
    @Nullable
    String contrasena;


    public Usuario(@Nullable String usuario, @Nullable String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }


    @Nullable
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(@Nullable String usuario) {
        this.usuario = usuario;
    }


    @Nullable
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@Nullable String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
