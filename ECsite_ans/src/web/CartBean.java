package web;

import java.io.Serializable;

public class CartBean implements Serializable {
	int pro_cd=0;
	String name ="";
	int price =0;
	int kosuu=0;

	public int getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getKosuu() {
		return kosuu;
	}
	public void setKosuu(int kosuu) {
		this.kosuu = kosuu;
	}


}
