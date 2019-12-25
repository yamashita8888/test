package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakuninServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("KakuninServlet開始");
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

			//aカートに入ってる商品を持ってくる
			ArrayList<CartBean> cartlist = new ArrayList<CartBean>();
			cartlist = (ArrayList<CartBean>) session.getAttribute("Cartlist");
			//a購入履歴をデータベースに入れる用
			ArrayList<String> user =new ArrayList<String>();

			JDBC jdbc = new JDBC();

			//a総額取ってくる
			int total = (int)session.getAttribute("totaltotal");

			/*//a現在時間取得
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	        String date = sdf.format(timestamp);*/

	        //aユーザデータ取得
	        user = (ArrayList<String>)session.getAttribute("user");
	      //aユーザのID取得
			int userid = Integer.parseInt(user.get(0));

			//a商品分在庫を減らす
			for (int i = 0; i < cartlist.size(); i++) {
				CartBean CB = new CartBean();
				CB = cartlist.get(i);
				//a(購入した)各商品の商品コードと個数を取り出す
				int procd = CB.getPro_cd();
				int kosuu = CB.getKosuu();
				//a特定の商品の在庫数を取得する
				int stock = jdbc.stockget(procd);
				//a在庫数から買った数を引く
				int nokori = stock - kosuu;
				//a計算された在庫をDBに更新する
				jdbc.stockdown(procd, nokori);
				System.out.println("ユーザーID:"+userid);
				System.out.println("商品コード："+procd);
				//System.out.println("日にち："+date);
				System.out.println("総額（税込）："+total);

				//a明細データ送信
				jdbc.meiset(userid, procd,total);
			}




			//aカートに入ってる商品を初期化する
			ArrayList<CartBean> cartlistzero = new ArrayList<CartBean>();
			session.setAttribute("Cartlist", cartlistzero);


			System.out.println("KakuninServlet終了");
			//a完了画面に遷移する
			RequestDispatcher rd = req.getRequestDispatcher("jsp/Kanryo.jsp");
			rd.forward(req, resp);
			return;
		}
	}
}
