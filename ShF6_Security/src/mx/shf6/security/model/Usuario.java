package mx.shf6.security.model;

import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Usuario {
	
	//PROPIEDADES
	private ObjectProperty<Integer> sysPK;
	private StringProperty usuario;
	private StringProperty contrasena;
	private StringProperty correoElectronico;
	private ObjectProperty<Date> fechaRegistro;
	private ObjectProperty<Date> fechaBloqueo;
	private ObjectProperty<Integer> status;
	private ObjectProperty<Integer> grupoUsuarioFK;
  
	//CONSTANTES
	public static final int BLOQUEADO = 0;
	public static final int ACTIVO = 1;
	public static final int BAJA = 2;
  
	//CONTRUCTOR VACIO
	public Usuario() {
		this(0, "", "", "", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 0, 0);
	}//FIN CONSTRUCTOR
   
	//CONSTRUCTOR
	public Usuario(Integer sysPK, String usuario, String contrasena, String correoElectronico, Date fechaRegistro, Date fechaBloqueo, Integer status, Integer grupoUsuarioFK) {
		this.sysPK = new SimpleObjectProperty<Integer>(sysPK);
		this.usuario = new SimpleStringProperty(usuario);
		this.contrasena = new SimpleStringProperty(contrasena);
		this.correoElectronico = new SimpleStringProperty(correoElectronico);
		this.fechaRegistro = new SimpleObjectProperty<Date>(fechaRegistro);
		this.fechaBloqueo = new SimpleObjectProperty<Date>(fechaBloqueo);
		this.status = new SimpleObjectProperty<Integer>(status);
		this.grupoUsuarioFK = new SimpleObjectProperty<Integer>(grupoUsuarioFK);
	}//FIN CONSTRUCTOR
	
	//METODOS PARA ACCEDER A SYSPK  
	public void setSysPK(Integer sysPK) {
		this.sysPK.set(sysPK);
	}//FIN METODO
  
	public Integer getSysPK() {
		return (Integer)this.sysPK.get();
	}//FIN METODO
  
	public ObjectProperty<Integer> sysPKProperty() {
		return this.sysPK;
	}//FIN METODO
	
	//METODOS PARA ACCEDER A USUARIO
	public void setUsuario(String usuario) {
		this.usuario.set(usuario);
	}//FIN METODO
  
	public String getUsuario() {
		return (String)this.usuario.get();
	}//FIN METODO
  
	public StringProperty usuarioProperty() {
		return this.usuario;
	}//FIN METODO
  
	//METODOS PARA ACCEDER A CONTRASEÑA
	public void setContrasena(String contrasena) {
		this.contrasena.set(contrasena);
	}//FIN METODO
  
	public String getContrasena() {
		return (String)this.contrasena.get();
	}//FIN METODO
  
	public StringProperty contrasenaProperty() {
		return this.contrasena;
	}//FIN METODO
  
	//METODOS PARA ACCEDER A CORREO ELECTRONICO
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico.set(correoElectronico);
	}//FIN METODO
  
	public String getCorreoElectronico() {
		return (String)this.correoElectronico.get();
	}//FIN METODO
  
	public StringProperty correoElectronicoProperty() {
		return this.correoElectronico;
	}//FIN METODO
  
	//METODOS PARA ACCEDER A FECHA REGISTRO
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro.set(fechaRegistro);
	}//FIN METODO
  
	public Date getFechaRegistro() {
		return (Date)this.fechaRegistro.get();
	}//FIN METODO
  
	public ObjectProperty<Date> fechaRegistroProperty() {
		return this.fechaRegistro;
	}//FIN METODO
  
  	//METODOS PARA ACCEDER A FECHA BLOQUEO
	public void setFechaBloqueo(Date fechaBloqueo) {
		this.fechaBloqueo.set(fechaBloqueo);
	}//FIN METODO
  
	public Date getFechaBloqueo() {
		return (Date)this.fechaBloqueo.get();
	}//FIN METODO
  
	public ObjectProperty<Date> fechaBloqueoProperty() {
		return this.fechaBloqueo;
	}//FIN METODO
  
  	//METODOS PARA ACCEDER A STATUS
	public void setStatus(Integer status) {
		this.status.set(status);
	}//FIN METODO
  
	public Integer getStatus() {
		return (Integer)this.status.get();
	}//FIN METODO
  
	public ObjectProperty<Integer> statusProperty() {
		return this.status;
	}//FIN METODO
  
	public StringProperty statusTextoProperty() {
		switch (getStatus().intValue()) {
			case 0: 
				return new SimpleStringProperty("Bloqueado");
			case 1: 
				return new SimpleStringProperty("Activo");
			case 2: 
				return new SimpleStringProperty("Baja");
		}//FIN SWITCH
		return new SimpleStringProperty();
	}//FIN METODO
  
  	//METODOS PARA ACCEDER A GRUPO USUARIO FK
	public void setGrupoUsuarioFk(Integer grupoUsuarioFk) {
		this.grupoUsuarioFK.set(grupoUsuarioFk);
	}//FIN METODO
  
	public Integer getGrupoUsuarioFk() {
		return (Integer)this.grupoUsuarioFK.get();
	}//FIN METODO
}//FIN CLASE