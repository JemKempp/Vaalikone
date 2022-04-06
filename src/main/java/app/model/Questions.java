package app.model;

import java.io.Serializable;

public class Questions implements Serializable{
	private int kysymys_id;
	private String kysymys;
	public Questions(String kysymys_id, String kysymys) {
		// TODO Auto-generated constructor stub
		setKysymys_id(kysymys_id);
		this.kysymys=kysymys;
		
		
	}
	public Questions() {
		// TODO Auto-generated constructor stub
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public void setKysymys_id(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

}