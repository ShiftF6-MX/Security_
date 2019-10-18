package mx.shf6.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.shf6.utilities.Notificacion;

public class UsuarioDAO {
	//CONSTANTES
	public static final int NO_REGISTRADO = 0;
	public static final int CONTRASENA_INCORRECTA = 1;
	public static final int USUARIO_BLOQUEADO = 2;
	public static final int ACCESO_CORRECTO = 3;
  
	//METODOS
	public static final boolean create(Connection connection, Usuario usuario) {
		String query = " INSERT INTO usuarios (Usuario, Contrasena, CorreoElectronico, FechaRegistro, FechaBloqueo, Status, GrupoUsuarioFK) VALUES ( ?, aes_encrypt(?, 'ShiftF6'), ?, CURDATE(), ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, usuario.getUsuario());
			preparedStatement.setString(2, usuario.getContrasena());
			preparedStatement.setString(3, usuario.getCorreoElectronico());
			if (usuario.getStatus().intValue() != 1) 
				preparedStatement.setDate(4, usuario.getFechaBloqueo());
			else 
				preparedStatement.setNull(4, 91);
			preparedStatement.setInt(5, usuario.getStatus().intValue());
			preparedStatement.setInt(6, usuario.getGrupoUsuarioFk().intValue());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<Usuario> read(Connection connection) {
		ArrayList<Usuario> arrayListUsuario = new ArrayList<Usuario>();
		String query = "SELECT Sys_PK, Usuario, aes_decrypt(Contrasena, 'ShiftF6'), CorreoElectronico, FechaRegistro, FechaBloqueo, Status, GrupoUsuarioFK FROM usuarios ORDER BY Sys_PK";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setSysPK(Integer.valueOf(resultSet.getInt(1)));
				usuario.setUsuario(resultSet.getString(2));
				usuario.setContrasena(resultSet.getString(3));
				usuario.setCorreoElectronico(resultSet.getString(4));
				usuario.setFechaRegistro(resultSet.getDate(5));
				usuario.setFechaBloqueo(resultSet.getDate(6));
				usuario.setStatus(Integer.valueOf(resultSet.getInt(7)));
				usuario.setGrupoUsuarioFk(Integer.valueOf(resultSet.getInt(8)));
				arrayListUsuario.add(usuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListUsuario;
	}//FIN METODO
  
	public static final ArrayList<Usuario> readPorUsuarioCorreoLike(Connection connection, String like) {
		ArrayList<Usuario> arrayListUsuario = new ArrayList<Usuario>();
		String query = "SELECT Sys_PK, Usuario, aes_decrypt(Contrasena, 'ShiftF6'), CorreoElectronico, FechaRegistro, FechaBloqueo, Status, GrupoUsuarioFK FROM usuarios WHERE Usuario LIKE '%" + like + "%' OR CorreoElectronico LIKE '%" + like + "%'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			Usuario usuario = null;
			while (resultSet.next()) {
				usuario = new Usuario();
				usuario.setSysPK(Integer.valueOf(Integer.parseInt(resultSet.getString(1))));
				usuario.setUsuario(resultSet.getString(2));
				usuario.setContrasena(resultSet.getString(3));
				usuario.setCorreoElectronico(resultSet.getString(4));
				usuario.setFechaRegistro(resultSet.getDate(5));
				usuario.setFechaBloqueo(resultSet.getDate(6));
				usuario.setStatus(Integer.valueOf(resultSet.getInt(7)));
				usuario.setGrupoUsuarioFk(Integer.valueOf(resultSet.getInt(8)));
				arrayListUsuario.add(usuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListUsuario;
  	}//FIN METODO
  
  	public static final ArrayList<Usuario> readPorCampo(Connection connection, String campoBusqueda, String valorBusqueda) {
  		ArrayList<Usuario> arrayListUsuario = new ArrayList<Usuario>();
  		String query = "SELECT Sys_PK, Usuario, aes_decrypt(Contrasena, 'ShiftF6'), CorreoElectronico, FechaRegistro, FechaBloqueo, Status, GrupoUsuarioFK FROM usuarios WHERE " + campoBusqueda + " = ? ORDER BY Sys_PK";
  		try {
  			PreparedStatement preparedStatement = connection.prepareStatement(query);
  			preparedStatement.setString(1, valorBusqueda);
  			ResultSet resultSet = preparedStatement.executeQuery();
  			Usuario usuario = null;
  			while (resultSet.next()) {
  				usuario = new Usuario();
  				usuario.setSysPK(Integer.valueOf(Integer.parseInt(resultSet.getString(1))));
  				usuario.setUsuario(resultSet.getString(2));
  				usuario.setContrasena(resultSet.getString(3));
  				usuario.setCorreoElectronico(resultSet.getString(4));
  				usuario.setFechaRegistro(resultSet.getDate(5));
  				usuario.setFechaBloqueo(resultSet.getDate(6));
  				usuario.setStatus(Integer.valueOf(resultSet.getInt(7)));
  				usuario.setGrupoUsuarioFk(Integer.valueOf(resultSet.getInt(8)));
  				arrayListUsuario.add(usuario);
  			}//FIN WHILE
  		} catch (SQLException ex) {
  			Notificacion.dialogoException(ex);
  		}//FIN TRY/CATCH
  		return arrayListUsuario;
  	}//FIN METODO
  
  	public static final boolean update(Connection connection, Usuario usuario) {
  		String query = "UPDATE usuarios SET Usuario = ?, Contrasena = aes_encrypt(?, 'ShiftF6'), CorreoElectronico = ?, FechaBloqueo = ?, Status = ?, GrupoUsuarioFK = ? WHERE Sys_PK = ?";
  		try {
  			PreparedStatement preparedStatement = connection.prepareStatement(query);
  			preparedStatement.setString(1, usuario.getUsuario());
  			preparedStatement.setString(2, usuario.getContrasena());
  			preparedStatement.setString(3, usuario.getCorreoElectronico());
  			if (usuario.getStatus().intValue() != 1)
  				preparedStatement.setDate(4, usuario.getFechaBloqueo());
  			else 
  				preparedStatement.setNull(4, 91);
  			preparedStatement.setInt(5, usuario.getStatus().intValue());
  			preparedStatement.setInt(6, usuario.getGrupoUsuarioFk().intValue());
  			preparedStatement.setInt(7, usuario.getSysPK().intValue());
  			preparedStatement.execute();
  			return true;
  		} catch (SQLException ex) {
  			Notificacion.dialogoException(ex);
  		}//FIN TRY/CATCH
  		return false;
  	}//FIN METODO
  
  	public static final boolean delete(Connection connection, Usuario usuario) {
  		String query = "DELETE FROM usuarios WHERE Sys_PK= ?";
  		try {
  			PreparedStatement preparedStatement = connection.prepareStatement(query);
  			preparedStatement.setInt(1, usuario.getSysPK().intValue());
  			preparedStatement.execute();
  			return true;
  		} catch (SQLException ex) {
  			Notificacion.dialogoException(ex);
  		}//FIN TRY/CATCH
  		return false;
  	}//FIN METODO
  
  	public static final int validarUsuario(Connection connection, String nombreUsuario, String contrasena) {
  		Usuario usuario = new Usuario();
  		ArrayList<Usuario> resultadoUsuario = readPorCampo(connection, "usuario", nombreUsuario);
  		if (resultadoUsuario.size() != 0) {
  			usuario = (Usuario)resultadoUsuario.get(0);
  			if (usuario.getUsuario().equals(nombreUsuario)) {
  				if (usuario.getContrasena().equals(contrasena)) {
  					if (usuario.getStatus().equals(Integer.valueOf(0))) {
  						return USUARIO_BLOQUEADO;
  					}//FIN IF
  					return ACCESO_CORRECTO;
  				}//FIN IF
  				return CONTRASENA_INCORRECTA;
  			}//FIN IF
  		} else {
  			return NO_REGISTRADO;
  		}//FIN IF/ELSE
  		return NO_REGISTRADO;
  	}//FIN METODO
}//FIN CLASE