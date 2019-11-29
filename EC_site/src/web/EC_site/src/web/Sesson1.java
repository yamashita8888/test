package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Sesson1
 */
public class Sesson1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesson1() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String log = getInitParameter("login");
	    String pw = getInitParameter("pass");
	    //processRequest(request, response);

	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    //if (request.getParameter("username") == un){
	    if (log.equals(request.getParameter("login")) == true
	      && pw.equals(request.getParameter("pass")) == true) {


		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Search.jsp");
		rd.forward(request, response);
	    	  }
}
}