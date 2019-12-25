package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//sessionを終了する
		session.invalidate();

		//aログイン画面に遷移する
		RequestDispatcher rd = req.getRequestDispatcher("jsp/Login.jsp");
		rd.forward(req, resp);
		return;
	}

}
