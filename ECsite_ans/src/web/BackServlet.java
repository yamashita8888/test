package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BackServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BackServlet開始");
		req.setCharacterEncoding("UTF-8");
		String kesu = (String) req.getParameter("kesu");

		//aセッション継続・確認(切れてたらnullを出す)
		HttpSession session = req.getSession(false);

		//aセッションが切れたら
		if (session == null) {
			session.invalidate();
			//aログイン画面に遷移する
			RequestDispatcher rd = req.getRequestDispatcher("jsp/Login.jsp");
			rd.forward(req, resp);
			return;

		} else {
			if (kesu.equals("kesuyo")) {
				//aカートに入ってる商品を初期化する
				ArrayList<CartBean> cartlist = new ArrayList<CartBean>();
				session.setAttribute("Cartlist", cartlist);
			}

			//a検索画面に遷移
			RequestDispatcher rd = req.getRequestDispatcher("jsp/Serch.jsp");
			rd.forward(req, resp);
			return;
		}
	}
}
