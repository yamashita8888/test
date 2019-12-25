package web;

import java.io.Serializable;

public class CateBean implements Serializable {

	int id=0;
	String cana="";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCana() {
		return cana;
	}
	public void setCana(String cana) {
		this.cana = cana;
	}


}
