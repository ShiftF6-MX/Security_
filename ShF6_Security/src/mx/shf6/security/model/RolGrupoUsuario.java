package mx.shf6.security.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class RolGrupoUsuario {
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private ObjectProperty<Integer> grupoUsuarioFk;
	private ObjectProperty<Integer> rolFk;
  
	//CONSTRUCTOR
	public RolGrupoUsuario() {
		this(0, 0, 0);
	}//FIN METODO
  
	public RolGrupoUsuario(Integer sysPk, Integer grupoUsuarioFk, Integer rolFk) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.grupoUsuarioFk = new SimpleObjectProperty<Integer>(grupoUsuarioFk);
		this.rolFk = new SimpleObjectProperty<Integer>(rolFk);
	}//FIN METODO
  
	public void setSysPk(Integer sysPk) {
		this.sysPk.set(sysPk);
	}//FIN METODO
  
	public Integer getSysPk() {
		return (Integer)this.sysPk.get();
	}//FIN METODO
  
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPk;
	}//FIN METODO
  
	public void setGrupoUsuarioFk(Integer grupoUsuarioFk) {
		this.grupoUsuarioFk.set(grupoUsuarioFk);
  	}//FIN METODO
  
	public Integer getGrupoUsuarioFk() {
		return (Integer)this.grupoUsuarioFk.get();
  	}//FIN METODO
  
	public void setRolFk(Integer rolFk) {
		this.rolFk.set(rolFk);
	}//FIN METODO
  
	public Integer getRolFk() {
		return (Integer)this.rolFk.get();
  	}//FIN METODO 
}//FIN CLASE