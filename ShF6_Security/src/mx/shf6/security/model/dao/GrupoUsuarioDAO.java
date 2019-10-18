package mx.shf6.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.shf6.utilities.Notificacion;

public class GrupoUsuarioDAO {
	public static final boolean create(Connection connection, GrupoUsuario grupoUsuario) {
		String query = " INSERT INTO gruposusuarios (NombreGrupo, Descripcion) values ( ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, grupoUsuario.getNombre());
			preparedStatement.setString(2, grupoUsuario.getDescripcion());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<GrupoUsuario> read(Connection connection) {
		String query = "SELECT Sys_PK, NombreGrupo, Descripcion FROM gruposusuarios ORDER BY NombreGrupo ASC";
		ArrayList<GrupoUsuario> listaGrupoUsuario = new ArrayList<GrupoUsuario>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				grupoUsuario.setSysPk(Integer.valueOf(resultSet.getInt(1)));
				grupoUsuario.setNombre(resultSet.getString(2));
				grupoUsuario.setDescripcion(resultSet.getString(3));
				listaGrupoUsuario.add(grupoUsuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return listaGrupoUsuario;
	}//FIN METODO
  
	public static final GrupoUsuario readPorSysPK(Connection connection, int sysPK) {
		String query = "SELECT Sys_PK, NombreGrupo, Descripcion FROM gruposusuarios WHERE Sys_PK = " + sysPK;
		GrupoUsuario grupoUsuario = new GrupoUsuario();
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultSet = sentencia.executeQuery(query);
			while (resultSet.next()) {
				grupoUsuario.setSysPk(Integer.valueOf(resultSet.getInt(1)));
				grupoUsuario.setNombre(resultSet.getString(2));
				grupoUsuario.setDescripcion(resultSet.getString(3));
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return grupoUsuario;
	}//FIN METODO
	
	public static final ArrayList<GrupoUsuario> readPorNombreDescripcionLike(Connection connection, String like) {
		ArrayList<GrupoUsuario> listaGrupoUsuario = new ArrayList<GrupoUsuario>();
		String query = "SELECT Sys_PK, NombreGrupo, Descripcion FROM gruposusuarios WHERE NombreGrupo LIKE '%" + like + "%' OR Descripcion LIKE '%" + like + "%'";
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultados = sentencia.executeQuery(query);
			while (resultados.next()) {
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				grupoUsuario.setSysPk(Integer.valueOf(resultados.getInt(1)));
				grupoUsuario.setNombre(resultados.getString(2));
				grupoUsuario.setDescripcion(resultados.getString(3));
				listaGrupoUsuario.add(grupoUsuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/cATCH
		return listaGrupoUsuario;
	}//FIN METODO
  
	public static final boolean update(Connection connection, GrupoUsuario grupoUsuario) {
		String query = "UPDATE gruposusuarios SET NombreGrupo = ?, descripcion= ? WHERE Sys_PK= ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, grupoUsuario.getNombre());
			preparedStatement.setString(2, grupoUsuario.getDescripcion());
			preparedStatement.setInt(3, grupoUsuario.getSysPk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final boolean delete(Connection connection, GrupoUsuario grupoUsuario) {
		String query = " DELETE FROM gruposusuarios WHERE Sys_PK= ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, grupoUsuario.getSysPk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
}//FIN CLASE