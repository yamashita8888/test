package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//セッション継続・確認(切れてたらnullを出す)
		HttpSession session = req.getSession(false);

		//セッションが切れたら
				if (session == null) {
					session.invalidate();
					//ログイン画面に遷移する
					RequestDispatcher rd = req.getRequestDispatcher("jsp/Login.jsp");
					rd.forward(req, resp);
					return;

				} else {
					//確認画面に遷移する
					RequestDispatcher rd = req.getRequestDispatcher("jsp/Kakunin.jsp");
					rd.forward(req, resp);
					return;

				}
	}

}
