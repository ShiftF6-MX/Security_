package mx.shf6.security.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.security.model.Rol;
import mx.shf6.utilities.Notificacion;

public class RolDAO {
	
	public static final boolean create(Connection connection, Rol rol) {
		String query = " INSERT INTO roles (codigoItem, descripcion) values ( ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, rol.getCodigoItem());
			preparedStatement.setString(2, rol.getDescripcion());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<Rol> read(Connection connection) {
		ArrayList<Rol> arrayListRol = new ArrayList<Rol>();
		String query = "SELECT Sys_PK, CodigoItem, Descripcion FROM roles ORDER BY Sys_PK";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Rol claseRol = new Rol();
				claseRol.setSysPk(Integer.valueOf(resultSet.getInt(1)));
				claseRol.setCodigoItem(resultSet.getString(2));
				claseRol.setDescripcion(resultSet.getString(3));
				arrayListRol.add(claseRol);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListRol;
	}//FIN METODO
  
	public static final Rol readPorSysPK(Connection connection, int sysPK) {
		Rol rol = new Rol();
		String query = "SELECT Sys_Pk, CodigoItem, Descripcion FROM roles WHERE Sys_PK = " + sysPK;
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultados = sentencia.executeQuery(query);
			while (resultados.next()) {
				rol.setSysPk(Integer.valueOf(resultados.getInt(1)));
				rol.setCodigoItem(resultados.getString(2));
				rol.setDescripcion(resultados.getString(3));
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return rol;
	}//FIN METODO
  
	public static final boolean update(Connection connection, Rol rol) {
		String query = "UPDATE roles SET codigoItem= ?, descripcion= ? WHERE Sys_PK= ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, rol.getCodigoItem());
			preparedStatement.setString(2, rol.getDescripcion());
			preparedStatement.setInt(3, rol.getSysPk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<Rol> readCodigoLike(Connection connection, String like) {
		ArrayList<Rol> listaPermisos = new ArrayList<Rol>();
		String query = "SELECT Sys_Pk, CodigoItem, Descripcion FROM roles WHERE CodigoItem LIKE '%" + like + "%'";
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultados = sentencia.executeQuery(query);
			while (resultados.next()) {
				Rol permisos = new Rol();
				permisos.setSysPk(Integer.valueOf(resultados.getInt(1)));
				permisos.setCodigoItem(resultados.getString(2));
				permisos.setDescripcion(resultados.getString(3));
				listaPermisos.add(permisos);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return listaPermisos;
	}//FIN METODO
  
	public static final boolean delete(Connection connection, Rol rol) {
		String query = "DELETE FROM roles WHERE Sys_PK= ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rol.getSysPk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
}//FIN CLASE