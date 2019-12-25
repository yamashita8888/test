package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SerchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SerchServlet開始");
		req.setCharacterEncoding("UTF-8");
		String key = (String) req.getParameter("key");
		String cat = (String) req.getParameter("cat");
		String syosai = (String) req.getParameter("syosai");
		System.out.println(key);
		System.out.println(cat);

		//インスタンス化達
		ArrayList<SyoBean> syolist = new ArrayList<SyoBean>();
		JDBC jdbc = new JDBC();

		//セッション継続・確認(切れてたらnullを出す)
		HttpSession session = req.getSession(false);

		//セッションが切れたら
		if (session == null) {
			session.invalidate();
			//ログイン画面に遷移する
			RequestDispatcher rd =req.getRequestDispatcher("jsp/Login.jsp");
			rd.forward(req, resp);
			return;

		} else {
			//詳細画面用
			if (syosai != null) {
				//インスタンス化(受け取る器)
				ArrayList<SyosaiBean> syosailist = new ArrayList<SyosaiBean>();
				SyosaiBean syosaibean = new SyosaiBean();
				//商品コードをもとに商品データ全てを持ってくる
				syosailist = jdbc.syosai(syosai);
				//カテゴリー名取ってくる用
				syosaibean = syosailist.get(0);
				String catid = syosaibean.getCat_id();
				System.out.println("cat_id:"+catid);
				String catname = jdbc.cana(catid);
				System.out.println("cat_name:"+catname);
				//商品紹介画面で必要なのでセッツ
				session.setAttribute("syobeanlist",syosailist);
				req.setAttribute("cana",catname);
				System.out.println("SerchServlet終了");
				//商品紹介画面に遷移する
				RequestDispatcher rd =req.getRequestDispatcher("jsp/Syosai.jsp");
				rd.forward(req, resp);
				return;

				//検索機能用
			} else {

				//どっちも入力されなかった場合
				if (key.equals("") && cat.equals("")) {
					System.out.println("何も入力されていません");
					req.setAttribute("error", "0件です。");
					//検索結果画面に遷移
					RequestDispatcher rd = req.getRequestDispatcher("jsp/Serch.jsp");
					rd.forward(req, resp);
					return;

					//カテゴリー検索
				} else if (key.equals("")) {
					syolist = jdbc.cate_pro(cat);

					//検索0件の場合
					if (syolist.size() < 1) {
						req.setAttribute("error", "0件です。");
					}
					//商品データを格納
					req.setAttribute("syohin", syolist);
					//検索結果画面に遷移
					RequestDispatcher rd = req.getRequestDispatcher("jsp/SerchResult.jsp");
					rd.forward(req, resp);
					return;

					//キーワード検索
				} else if (cat.equals("")) {
					syolist = jdbc.key_pro(key);

					//検索0件の場合
					if (syolist.size() < 1) {
						req.setAttribute("error", "0件です。");
					}
					//商品データを格納
					req.setAttribute("syohin", syolist);
					//検索結果画面に遷移
					RequestDispatcher rd = req.getRequestDispatcher("jsp/SerchResult.jsp");
					rd.forward(req, resp);
					return;

					//両方検索
				} else if (!(key.equals("") && cat.equals(""))) {
					syolist = jdbc.ken_pro(key, cat);

					//検索0件の場合
					if (syolist.size() < 1) {
						req.setAttribute("error", "0件です。");
					}
					//商品データを格納
					req.setAttribute("syohin", syolist);
					//検索結果画面に遷移
					RequestDispatcher rd = req.getRequestDispatcher("jsp/SerchResult.jsp");
					System.out.println("SerchServlet終了");
					rd.forward(req, resp);
					return;
					//問題時
				} else {
					System.out.println("問題発生");
					//検索画面に遷移
					RequestDispatcher rd = req.getRequestDispatcher("jsp/Serch.jsp");
					System.out.println("SerchServlet終了");
					rd.forward(req, resp);
					return;
				}

			}

		}
	}
}
