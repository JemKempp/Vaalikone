package app.model;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Dao dao=null;

    @Override
    public void init() {
        dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "jkt", "riina");
    }

    /
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Questions> list=null;
        if (dao.getConnection()) {
            list=dao.readAllQuestions();
        }
        else {
            System.out.println("No connection to database");
        }
        request.setAttribute("kysymyksetlist", list);

        RequestDispatcher rd=request.getRequestDispatcher("/jsp/vastaavaalikoneeseen.jsp");
        rd.forward(request, response);
    }

}