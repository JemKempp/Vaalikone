package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.model.Candidates;
import app.model.Vastaukset;
import app.model.Questions;

public class Dao {

	private Connection conn;
	
	    private String url;
	    private String user;
	    private String pass;

	    public Dao(String url, String user, String pass) {
	        this.url=url;
	        this.user=user;
	        this.pass=pass;
	    }

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "jkt", "riina");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addUser(String username, String pw, String salt) {
		String sql = "insert into useraccount (username, hashedpassword, salt) values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1,  username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUserSalt(String username) {
		String result = "";
		String sql = "select salt from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1,  username);

			ResultSet rs = stmt.executeQuery();

			if ( rs.next() ) {
				result = rs.getString("salt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getUserPasswordHash(String username) {
		String result = "";
		String sql = "select hashedpassword from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1,  username);

			ResultSet rs = stmt.executeQuery();

			if (rs.next() ) {
				result = rs.getString("hashedpassword");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	    /*
	//Pyydetään ottamaan yhteys
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
			catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
				
			}
			
			//Luetaan kaikki ehdottaat taulusta
		}
		*/
	public ArrayList<Candidates> readAllCandidates()  {
		ArrayList<Candidates> list = new ArrayList<Candidates>();
		
		try {
            Statement stmt=conn.createStatement();
            ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
            while (RS.next()){
                Candidates e=new Candidates();
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
	public ArrayList<Candidates> updateCandidate(Candidates e) {
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
            return readAllCandidates();
        }
        catch(SQLException s) {
            return null;
        }
    }
    public ArrayList<Candidates> deleteCandidate(String ehdokas_id) {
        try {
            String sql="delete from ehdokkaat where ehdokas_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, ehdokas_id);
            pstmt.executeUpdate();
            return readAllCandidates();
        }
        catch(SQLException s) {
            return null;
        }
    }
    public Candidates readCandidate(String ehdokas_id) {
        Candidates e=null;
        try {
            String sql="select * from ehdokkaat where ehdokas_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, ehdokas_id);
            ResultSet RS=pstmt.executeQuery();
            while (RS.next()){
                e=new Candidates();
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

    public ArrayList<Questions> readAllQuestions() {
        ArrayList<Questions> list=new ArrayList<>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet RS=stmt.executeQuery("select * from kysymykset");
            while (RS.next()){
                Questions k=new Questions();
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
    public ArrayList<Candidates> lisaaCandidate(Candidates e) {
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
            return readAllCandidates();
        }
        catch(SQLException s) {
            return null;
        }
    }
}