package mx.shf6.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert.AlertType;
import mx.shf6.security.model.dao.UsuarioDAO;
import mx.shf6.utilities.Notificacion;

public class ControlAccesoDAO {

	public static boolean autenticarUsuario(Connection connection, String usuario, String contrasena) {
		int resultado = UsuarioDAO.validarUsuario(connection, usuario, contrasena);
	    switch (resultado) {
	    	case UsuarioDAO.NO_REGISTRADO: 
	    		Notificacion.dialogoAlerta(AlertType.INFORMATION, "Usuario no registrado", "Lo sentimos no puedes ingresar al sistema con este nombre de usuario.");
	    		return false;
	    	case UsuarioDAO.USUARIO_BLOQUEADO: 
	    		Notificacion.dialogoAlerta(AlertType.INFORMATION, "Usuario bloqueado", "Lo sentimos el usuario con el que intentas ingresar se encuentra bloqueado, por favor ponte en contacto con el administrador del sistema.");
	    		return false;
	    	case UsuarioDAO.CONTRASENA_INCORRECTA: 
	    		Notificacion.dialogoAlerta(AlertType.INFORMATION, "Contrase�a incorrecta", "Lo sentimos la contrase�a con la que intentas ingresar no es la correcta, si la has olvidado, por favor ponte en contacto con el administrador del sistema.");
	    		return false;
	    	case UsuarioDAO.ACCESO_CORRECTO: 
	    		return true;
	    }//FIN SWITCH
	    return false;
	  }//FIN METODO
	  
	public static boolean verificarAcceso(Connection connection, int grupoUsuario, String codigoItem) {
	    String query = "SELECT * FROM rolgruposusuario INNER JOIN roles ON rolgruposusuario.RolFK = roles.Sys_PK WHERE rolgruposusuario.GrupoUsuarioFK = " + grupoUsuario + "AND roles.CodigoItem = '" + codigoItem + "'";
	    try {
	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	if (resultSet.next()) {
	    		return true;
	    	}//FIN IF
	    	return false;
	    } catch (SQLException e) {
	      Notificacion.dialogoException(e);
	    }//FIN TRY/CATCH
	    return false;
	}//FIN METODO
}//FIN CLASE 
