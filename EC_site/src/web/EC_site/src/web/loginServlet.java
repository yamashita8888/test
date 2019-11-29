package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("UTF-8");

		// パラメータを取得
		String login_cd =req.getParameter("login_cd");
		String login_pw =req.getParameter("login_pw");

		// パラメータがない場合
		if((login_cd.equals("") || login_cd == null)||
				login_pw.equals("") || login_pw == null) {
			// エラー画面へディスパッチ
			RequestDispatcher rd = req.getRequestDispatcher("LoginError1.jsp");
			rd.forward(req, resp);
			// returnしないと後の処理が実施
			return;
		}

		// インスタンスを生成
		JdbcJava jdbc = new JdbcJava();

		// ArrayListを定義
		ArrayList<logicBean> list = null;

		// LoginLogicのloginを呼び出す
		// 戻り値はArrayList
		System.out.println(login_cd + login_pw);
		list = jdbc.login(login_cd, login_pw);


//System.out.println("list.size():" + list.size());
		if (list.size() != 1 ) {
			// エラー画面へディスパッチ
			RequestDispatcher rd = req.getRequestDispatcher("LoginError2.jsp");
			rd.forward(req, resp);
			// returnしないと後の処理が実施
			return;
		}

		// セッションをON
		HttpSession session = req.getSession(true);

		// listの1番目を取り出す
		logicBean logic = list.get(0);

		// セッションにuserBeanを格納
		session.setAttribute("s_user", logic);

		// リクエストにuserBeanを格納
		req.setAttribute("r_user", logic);

		// ArrayListを格納する等も可能
		req.setAttribute("userList", list);

		// 検索画面へディスパッチ
		RequestDispatcher rd = req.getRequestDispatcher("jsp/Search.jsp");
		rd.forward(req, resp);

	}


}