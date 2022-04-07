package app.model;

import java.sql.DriverManager;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import java.sql.Connection;

public class Dao {
	/*
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException s) {
			System.out.println(s.getMessage());
			return false;
		}
	}
	
	
	public ArrayList<Ehdokkaat> readAllEhdokkaat() {
		ArrayList<Ehdokkaat> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()){
				Ehdokkaat e=new Ehdokkaat();
				e.setEhdokas_id(RS.getInt("ehdokas_id"));
				e.setEtunimi(RS.getString("etunimi"));
				e.setSukunimi(RS.getString("sukunimi"));
				e.setPuolue(RS.getString("puolue"));
				e.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				e.setIka(RS.getInt("ika"));
				e.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				e.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				e.setAmmatti(RS.getString("ammatti"));
				
				list.add(e);
			}
			return list;
		}
		catch(SQLException s) {
			return null;
		}
	}
	public ArrayList<Ehdokkaat> updateEhdokas(Ehdokkaat e) {
		try {
			String sql="update ehdokkaat set etunimi=?, sukunimi=?, puolue=?, kotipaikkakunta=?, ika=?, miksi_eduskuntaan=?, mita_asioita_haluat_edistaa=?, ammatti=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, e.getEtunimi());
			pstmt.setString(2, e.getSukunimi());
			pstmt.setString(3, e.getPuolue());
			pstmt.setString(4, e.getKotipaikkakunta());
			pstmt.setInt(5, e.getIka());
			pstmt.setString(6, e.getMiksi_eduskuntaan());
			pstmt.setString(7, e.getMita_asioita_haluat_edistaa());
			pstmt.setString(8, e.getAmmatti());
			pstmt.setInt(9, e.getEhdokas_id());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException s) {
			return null;
		}
	}
	public ArrayList<Ehdokkaat> deleteEhdokas(String ehdokas_id) {
		try {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException s) {
			return null;
		}
	}

	public Ehdokkaat readEhdokas(String ehdokas_id) {
		Ehdokkaat e=null;
		try {
			String sql="select * from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				e=new Ehdokkaat();
				e.setEhdokas_id(RS.getInt("ehdokas_id"));
				e.setEtunimi(RS.getString("etunimi"));
				e.setSukunimi(RS.getString("sukunimi"));
				e.setPuolue(RS.getString("puolue"));
				e.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				e.setIka(RS.getInt("ika"));
				e.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				e.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				e.setAmmatti(RS.getString("ammatti"));
			}
			return e;
		}
		catch(SQLException s) {
			return null;
			}
	}
	public ArrayList<Vastaukset> readEhdokkaanVastaukset(String ehdokas_id) {
		ArrayList<Vastaukset> vlist=new ArrayList<>();
		try {
			String sql="select * from vastaukset where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				Vastaukset v=new Vastaukset();
				v.setEhdokas_id(RS.getInt("ehdokas_id"));
				v.setKysymys_id(RS.getInt("kysymys_id"));
				v.setVastaus(RS.getInt("vastaus"));
				v.setKommentti(RS.getString("kommentti"));
				vlist.add(v);
			}
			return vlist;
		}
		catch(SQLException s) {
			return null;
			}
	}
	public ArrayList<Vastaukset> readAllVastaukset() {
		ArrayList<Vastaukset> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from vastaukset");
			while (RS.next()){
				Vastaukset v=new Vastaukset();
				v.setEhdokas_id(RS.getInt("ehdokas_id"));
				v.setKysymys_id(RS.getInt("kysymys_id"));
				v.setVastaus(RS.getInt("vastaus"));
				v.setKommentti(RS.getString("kommentti"));
				list.add(v);
			}
			return list;
		}
		catch(SQLException s) {
			return null;
		}
	}
	
	public ArrayList<Vastaukset> updateVastaukset(Vastaukset v) {
		try {
			String sql="update vastaukset set vastaus=?, kommentti=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, v.getEhdokas_id());
			pstmt.setInt(2, v.getKysymys_id());
			pstmt.setInt(3, v.getVastaus());
			pstmt.setString(4, v.getKommentti());
			pstmt.executeUpdate();
			return readAllVastaukset();
		}
		catch(SQLException s) {
			return null;
		}
	}
	
	public ArrayList<Kysymykset> readAllKysymykset() {
		ArrayList<Kysymykset> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				Kysymykset k=new Kysymykset();
				k.setKysymys_id(RS.getInt("kysymys_id"));
				k.setKysymys(RS.getString("kysymys"));
				list.add(k);
			}
			return list;
		}
		catch(SQLException s) {
			return null;
		}
	}
	
	public ArrayList<Ehdokkaat> lisaaEhdokas(Ehdokkaat e) {
		try {
			String sql="insert into ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEhdokas_id());
			pstmt.setString(2, e.getEtunimi());
			pstmt.setString(3, e.getSukunimi());
			pstmt.setString(4, e.getPuolue());
			pstmt.setString(5, e.getKotipaikkakunta());
			pstmt.setInt(6, e.getIka());
			pstmt.setString(7, e.getMiksi_eduskuntaan());
			pstmt.setString(8, e.getMita_asioita_haluat_edistaa());
			pstmt.setString(9, e.getAmmatti());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException s) {
			return null;
		}
	}	
	*/
}