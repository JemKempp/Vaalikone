package app.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Candidates;
import app.model.Questions;
import app.model.Vastaukset;

@WebServlet(
        name = "ShowData",
        urlPatterns = {"/showdata"}
        )
public class ShowData extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // if sessions does not exist, create new one
        HttpSession session = request.getSession();

        Dao dao = new Dao();
        ArrayList<Candidates> candidates = dao.readAllCandidates();

        session.setAttribute("allcandidates", candidates);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showall.jsp");
        rd.forward(request, response);

    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // if sessions does not exist, create new one
        HttpSession session = request.getSession();

        Dao dao = new Dao();
        ArrayList<Questions> questions = dao.readAllQuestions();

        session.setAttribute("allquestions", questions);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showall.jsp");
        rd.forward(request, response);

    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // if sessions does not exist, create new one
        HttpSession session = request.getSession();

        Dao dao = new Dao();
        ArrayList<Vastaukset> vastaukset = dao.readAllVastaukset();

        session.setAttribute("allvastaukset", vastaukset);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showall.jsp");
        rd.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        doGet(request, response);
    }

}