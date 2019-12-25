package web;

import java.io.Serializable;

public class SyoBean implements Serializable {
	int procd =0;
	String proname="";
	int proprice =0;
	public int getProcd() {
		return procd;
	}
	public void setProcd(int procd) {
		this.procd = procd;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}


}
