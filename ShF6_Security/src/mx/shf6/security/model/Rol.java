package mx.shf6.security.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rol {
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty codigoItem;
	private StringProperty descripcion;
	private BooleanProperty seleccionado;
  
	//CONSTRUCTOR
	public Rol() {
		this(0, "", "", false);
	}//FIN METODO
  
	//CONSTRUCTOR
	public Rol(Integer sysPk, String codigoItem, String descripcion, boolean seleccionado) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.codigoItem = new SimpleStringProperty(codigoItem);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.seleccionado = new SimpleBooleanProperty(seleccionado);
	}//FIN METODO
  
	//METODOS PARA ACCEDER A SYSPK
	public void setSysPk(Integer sysPk) {
		this.sysPk.set(sysPk);
	}//FIN METODO
  
	public Integer getSysPk() {
		return (Integer)this.sysPk.get();
	}//FIN METODO
  
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPk;
	}//FIN METODO
  
	//METODOS PARA ACCEDER A CODIGO
	public void setCodigoItem(String codigoItem) {
		this.codigoItem.set(codigoItem);
	}//FIN METODO
  
	public String getCodigoItem() {
		return (String)this.codigoItem.get();
	}//FIN METODO
  
	public StringProperty codigoItemProperty() {
		return this.codigoItem;
	}//FIN METODO
  
	//METODO PARA ACCEDER  DESCRIPCION
	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);
	}//FIN METODO
  
	public String getDescripcion() {
		return (String)this.descripcion.get();
	}//FIN METODO
  
	public StringProperty descripcionProperty() {
		return this.descripcion;
	}//FIN METODO
  
	//METODO PARA ACCEDER A SELECCIONADO
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado.set(seleccionado);
	}//FIN METODO
  
	public Boolean getSeleccionado() {
		return Boolean.valueOf(this.seleccionado.get());
	}//FIN METODO
  
	public BooleanProperty seleccionadoProperty() {
		return this.seleccionado;
	}//FIN METODO
}//FIN CLASE