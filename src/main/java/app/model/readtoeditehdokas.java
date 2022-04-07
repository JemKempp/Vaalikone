package app.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import app.model.Candidates;

/**
 * Servlet implementation class readtoeditehdokas
 */
@WebServlet("/readtoeditehdokas")
public class readtoeditehdokas extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao;
    public void init() {
        dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "jkt", "riina");
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public readtoeditehdokas() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String ehdokas_id=request.getParameter("ehdokas_id");
        Candidates e=null;
        if (dao.getConnection()) {
            e=dao.readCandidate(ehdokas_id);
        }
        request.setAttribute("ehdokkaat", e);

        RequestDispatcher rd=request.getRequestDispatcher("/jsp/editcandidate.jsp");
        rd.forward(request, response);
    }
}
