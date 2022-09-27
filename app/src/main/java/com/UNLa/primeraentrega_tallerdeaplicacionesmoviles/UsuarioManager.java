package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class UsuarioManager {

    private static UsuarioManager instancia;
    //La clase que representa y el ID.
    Dao<Usuario, String> dao;

    public UsuarioManager() {
    }

    //Lo necesitamos para hacer la conexion a la base de datos
    public UsuarioManager(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, DBHelper.class);
        try {
            dao = helper.getDao(Usuario.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static UsuarioManager getInstancia(Context context) {
        if (instancia == null) {
            instancia = new UsuarioManager(context);
        }
        return instancia;
    }

    public static void setInstancia(UsuarioManager instancia) {
        UsuarioManager.instancia = instancia;
    }

    //Trae a todos los usuarios
    public List<Usuario> getUsuarios() throws Exception {
        return dao.queryForAll();
    }

    public Usuario getUsuario(String usuario) throws SQLException {
        return dao.queryForId(usuario);
    }

    //Nuevo usuario
    public void newUsuario(Usuario usuario) throws Exception {
        dao.create(usuario);
    }

    public void deleteUsuario(Usuario usuario) throws SQLException {
        dao.delete(usuario);
    }

    public Dao<Usuario, String> getDao() {
        return dao;
    }

    public void setDao(Dao<Usuario, String> dao) {
        this.dao = dao;
    }
}
