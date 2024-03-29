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
	    
	    public int saveVaalikone(Candidates candidates) {
	        Statement stmt=null;
	        int count=0;
	        try {
	            stmt = conn.createStatement();
	            count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values('"+candidates.getEhdokas_id()+"','"+candidates.getSukunimi()+"', '"+candidates.getEtunimi()+"', '"+candidates.getPuolue()+"', '"+candidates.getKotipaikkakunta()+"', "+candidates.getIka()+", '"+candidates.getMiksi_eduskuntaan()+"', '"+candidates.getMita_asioita_haluat_edistaa()+"', '"+candidates.getAmmatti()+"')");
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return count;
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
	public Candidates getCandidatesInfo(int ehdokas_id) {
		Candidates result = null;
        String sql = "select * from ehdokkaat where ehdokas_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, ehdokas_id);

            ResultSet resultset = stmt.executeQuery();

            if (resultset.next()) {
                result = new Candidates();
                result.setEhdokas_id(resultset.getInt("ehdokas_id"));
                result.setSukunimi(resultset.getString("sukunimi"));
                result.setEtunimi(resultset.getString("etunimi"));
                result.setPuolue(resultset.getString("puolue"));
                result.setKotipaikkakunta(resultset.getString("kotipaikkakunta"));
                result.setIka(resultset.getInt("ika"));
                result.setMiksi_eduskuntaan(resultset.getString("miksi_eduskuntaan"));
                result.setMita_asioita_haluat_edistaa(resultset.getString("mita_asioita_haluat_edistaa"));
                result.setAmmatti(resultset.getString("ammatti"));

            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        return result;
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
	public Dao() {
			// TODO Auto-generated constructor stub
		}
*/
	
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
		
		
	public ArrayList<Candidates> readAllCandidates()  {
		ArrayList<Candidates> list = new ArrayList<>();
		
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
        
    
	
	public ArrayList<Candidates> editcandidate(Candidates e) {
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
    
    
	


    public int deleteCandidate(int Ehdokas_id) throws SQLException {

        int count = 0;
        String sql = "DELETE from ehdokkaat WHERE Ehdokas_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Ehdokas_id);

            count = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
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
    public ArrayList<Candidates> addcandidate(Candidates e) {
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