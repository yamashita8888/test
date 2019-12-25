package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ログインサーブレット開始");
		req.setCharacterEncoding("UTF-8");
		String name = (String) req.getParameter("name");
		int name_cd = 0;
		String pass = (String) req.getParameter("pw");
		System.out.println(name);
		System.out.println(pass);

		//インスタンス化
		ArrayList<String> user =new ArrayList<String>();
		JDBC jdbc = new JDBC();
		ArrayList<CateBean> CB = new ArrayList<CateBean>();

		//入力しなかったとき
		if(name.equals("") || pass.equals("")) {
			System.out.println("入力してください");
			req.setAttribute("errorlogin","入力してください");
			//ログイン画面に遷移する
			RequestDispatcher rd =req.getRequestDispatcher("jsp/Login.jsp");
			rd.forward(req, resp);
			return;
		}else {
			try{
			name_cd = Integer.parseInt(name);
			}catch (Exception e) {
				System.out.println("数字にして");
				req.setAttribute("errorlogin","ユーザーコードは数字で入力してください。");
				//ログイン画面に遷移する
				RequestDispatcher rd =req.getRequestDispatcher("jsp/Login.jsp");
				rd.forward(req, resp);
				return;
			}
			user = jdbc.login(name_cd, pass);
			//ログイン失敗
			if(user.size() <1) {
				System.out.println("間違っています。");
				req.setAttribute("errorlogin","一致しません。");
				//ログイン画面に遷移する
				RequestDispatcher rd =req.getRequestDispatcher("jsp/Login.jsp");
				rd.forward(req, resp);
				return;

				//ログイン成功
			}else if(user.size() == 4) {
				//セッション開始
				HttpSession session = req.getSession(true);
				//カテゴリー名を持ってくる
				CB = jdbc.cate_name();
				//カテゴリー名が入ってるリストをセットする
				session.setAttribute("catename",CB);
				//ユーザー情報をセットする
				session.setAttribute("user", user);
				System.out.println("ログインします。");
				//検索画面に遷移する
				RequestDispatcher rd =req.getRequestDispatcher("jsp/Serch.jsp");
				rd.forward(req, resp);
				return;
				//問題時
			}else {
				System.out.println("問題発生");
				//ログイン画面に遷移する
				RequestDispatcher rd =req.getRequestDispatcher("jsp/Login.jsp");
				rd.forward(req, resp);
				return;
			}
		}

	}
}