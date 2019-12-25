package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyosaiServlet extends HttpServlet {
	int count =0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SyosaiServlet開始");

		req.setCharacterEncoding("UTF-8");
		//選択された個数を持ってくる
		String kosuu = (String) req.getParameter("kosuu");
		System.out.println("個数"+kosuu);

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
			ArrayList<CartBean> cartlist = new ArrayList<CartBean>();
			System.out.println(count);
			if(count>=1) {
			cartlist = (ArrayList<CartBean>)session.getAttribute("Cartlist");
			}
			count++;

			//商品紹介画面で使った商品のデータを取ってくる
			ArrayList<SyosaiBean> syosailist = new ArrayList<SyosaiBean>();
			syosailist = (ArrayList<SyosaiBean>) session.getAttribute("syobeanlist");

			//商品データを取り出す用
			SyosaiBean syosaibean = new SyosaiBean();
			syosaibean = syosailist.get(0);
			int Price = Integer.parseInt(syosaibean.getPrice());

			//カート画面に必要なデータをbeanに格納する
			CartBean CB = new CartBean();
			CB.setPro_cd(Integer.parseInt(syosaibean.getPro_cd()));
			CB.setName(syosaibean.getPro_name());
			CB.setPrice(Price);
			CB.setKosuu(Integer.parseInt(kosuu));

			//beanに格納したデータをリストに格納する
			cartlist.add(CB);

			int total = 0;

			//リストの中身文の合計金額と消費税を計算
			for (int i = 0; i < cartlist.size(); i++) {
				CartBean CBkeisan = new CartBean();
				CBkeisan = cartlist.get(i);
				//各商品の単価と個数を取り出す
				int keiPrice = CBkeisan.getPrice();
				int keikosuu = CBkeisan.getKosuu();
				//金額を求める
				int kingaku = keiPrice * keikosuu;
				//合計金額を求める
				total = kingaku + total;
			}
			//合計金額をもとに消費税を出す。
			int tax = (int) (total * 0.08);

			//送るためにString型に戻す
			session.setAttribute("Cartlist", cartlist);
			session.setAttribute("total", total);
			session.setAttribute("tax", tax);

			//消費税込みの総額
			int totaltotal = total + tax;
			session.setAttribute("totaltotal", totaltotal);

			System.out.println("SyosaiServlet終了");
			//ログイン画面に遷移する
			RequestDispatcher rd = req.getRequestDispatcher("jsp/Cart.jsp");
			rd.forward(req, resp);
			return;

		}

	}

}
