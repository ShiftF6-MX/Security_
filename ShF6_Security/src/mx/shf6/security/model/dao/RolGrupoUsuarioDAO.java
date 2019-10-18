package mx.shf6.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.shf6.utilities.Notificacion;

public class RolGrupoUsuarioDAO {
	
	public static final boolean create(Connection connection, RolGrupoUsuario rolGrupoUsuario) {
		String query = " INSERT INTO rolgruposusuario (GrupoUsuarioFK, RolFK) values ( ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rolGrupoUsuario.getGrupoUsuarioFk().intValue());
			preparedStatement.setInt(2, rolGrupoUsuario.getRolFk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<RolGrupoUsuario> readTodos(Connection connection) {
		ArrayList<RolGrupoUsuario> listaRolGrupoUsuario = new ArrayList<RolGrupoUsuario>();
		String query = "SELECT Sys_PK, GrupoUsuarioFK, RolFK FROM rolgruposusuario";
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultados = sentencia.executeQuery(query);
			while (resultados.next()) {
				RolGrupoUsuario rolGrupo = new RolGrupoUsuario();
				rolGrupo.setSysPk(Integer.valueOf(resultados.getInt(1)));
				rolGrupo.setGrupoUsuarioFk(Integer.valueOf(resultados.getInt(2)));
				rolGrupo.setRolFk(Integer.valueOf(resultados.getInt(3)));
				listaRolGrupoUsuario.add(rolGrupo);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return listaRolGrupoUsuario;
	}//FIN METODO
  
	public static final RolGrupoUsuario readPorSysPK(Connection connection, int sysPK) {
		RolGrupoUsuario rolGrupo = new RolGrupoUsuario();
		String query = "SELECT Sys_PK, GrupoUsuarioFK, RolFK FROM rolgruposusuarios WHERE Sys_PK = " + sysPK;
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultados = sentencia.executeQuery(query);
			while (resultados.next()) {
				rolGrupo.setSysPk(Integer.valueOf(resultados.getInt(1)));
				rolGrupo.setGrupoUsuarioFk(Integer.valueOf(resultados.getInt(2)));
				rolGrupo.setRolFk(Integer.valueOf(resultados.getInt(3)));
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return rolGrupo;
	}//FIN METODO
  
	public static ArrayList<RolGrupoUsuario> readPorGrupoUsuario(Connection connection, int grupoUsuarioFK) {
		ArrayList<RolGrupoUsuario> arrayRolGrupoUsuario = new ArrayList<RolGrupoUsuario>();
		String consulta = "SELECT Sys_PK, GrupoUsuarioFK, RolFK FROM rolgruposusuario WHERE GrupoUsuarioFK = " + grupoUsuarioFK;
		try {
			Statement sentencia = connection.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);
			RolGrupoUsuario rolGrupoUsuario = null;
			while (resultados.next()) {
				rolGrupoUsuario = new RolGrupoUsuario();
				rolGrupoUsuario.setSysPk(Integer.valueOf(resultados.getInt(1)));
				rolGrupoUsuario.setGrupoUsuarioFk(Integer.valueOf(resultados.getInt(2)));
				rolGrupoUsuario.setRolFk(Integer.valueOf(resultados.getInt(3)));
				arrayRolGrupoUsuario.add(rolGrupoUsuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayRolGrupoUsuario;
	}//FIN METODO
  
	public boolean update(Connection connection, RolGrupoUsuario rolGrupoUsuario) {
		String query = "UPDATE rolgruposusuario SET GrupoUsuarioFK = ?, RolFK = ? WHERE Sys_PK= ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rolGrupoUsuario.getGrupoUsuarioFk().intValue());
			preparedStatement.setInt(2, rolGrupoUsuario.getRolFk().intValue());
			preparedStatement.setInt(3, rolGrupoUsuario.getSysPk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final boolean delete(Connection connection, RolGrupoUsuario rolGrupoUsuario) {
		String query = " DELETE FROM rolgruposusuario WHERE GrupoUsuarioFK = ? AND RolFK = ?";
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, rolGrupoUsuario.getGrupoUsuarioFk().intValue());
			preparedStmt.setInt(2, rolGrupoUsuario.getRolFk().intValue());
			preparedStmt.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
}//FIN CLASE
