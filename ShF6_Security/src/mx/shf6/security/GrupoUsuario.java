package mx.shf6.security;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GrupoUsuario {
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty nombre;
	private StringProperty descripcion;
  
	//COSNTRUCTOR
	public GrupoUsuario() {
		this(0, "", "");
	}//FIN METODO
  
	//CONSTRUCTOR
	public GrupoUsuario(Integer sysPk, String nombre, String descripcion) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.nombre = new SimpleStringProperty(nombre);
		this.descripcion = new SimpleStringProperty(descripcion);
	}//FIN METODO
  
	//METODOS
	public void setSysPk(Integer sysPk) {
		this.sysPk.set(sysPk);
	}//FIN METODO
  
	public Integer getSysPk() {
		return (Integer)this.sysPk.get();
	}//FIN METODO
  
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPk;
	}//FIN METODO
  
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}//FIN METODO
  
	public String getNombre() {
		return (String)this.nombre.get();
	}//FIN METODO
  
	public StringProperty nombreProperty() {
		return this.nombre;
	}//FIN METODO
  
	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);
	}//FIN METODO
  
	public String getDescripcion() {
		return (String)this.descripcion.get();
	}//FIN METODO
  
	public StringProperty descripcionProperty() {
		return this.descripcion;
	}//FIN METODO
}//FIN CLASE