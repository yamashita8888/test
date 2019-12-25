package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {

	String url = "jdbc:mysql://localhost/ec_ans";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	//ログインメソッド
	public ArrayList<String> login(int name, String pass) {
		ArrayList<String> user = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);

			String sql ="select * from user where user_id = ? and login_pw = ?";
			pst = cnct.prepareStatement(sql);
			pst.setInt(1,name);
			pst.setString(2,pass);
			rs = pst.executeQuery();

			//user情報をarraylistに格納する。
			if(rs.next()) {
				user.add(rs.getString("user_id"));
				user.add(rs.getString("user_name"));
				user.add(rs.getString("login_cd"));
				user.add(rs.getString("user_id"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			//使っているやつ全部閉じる
			try {
				if(rs!=null)rs.close();
				if(pst!=null)pst.close();
				if(cnct!=null)cnct.close();

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return user;
	}

	//カテゴリー名メソッド
	public ArrayList<CateBean> cate_name() {
		ArrayList<CateBean> catename = new ArrayList<CateBean>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);


			st = cnct.createStatement();
			String sql ="select * from category";
			rs = st.executeQuery(sql);

			//商品情報をarraylistに格納する。
			while(rs.next()) {
				CateBean CB = new CateBean();
				CB.setId(rs.getInt("cat_id"));
				CB.setCana(rs.getString("cat_name"));
				catename.add(CB);
			}
			return catename;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			//使っているやつ全部閉じる
			try {

				if(rs!=null)rs.close();
				if(pst!=null)pst.close();
				if(cnct!=null)cnct.close();
				return catename;

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return catename;
	}

	//キーワード検索メソッド
	public ArrayList<SyoBean> key_pro(String keyname) {
		ArrayList<SyoBean> syolist = new ArrayList<SyoBean>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);



			String sql ="select * from product where pro_name=? ";
			pst = cnct.prepareStatement(sql);
			pst.setString(1,keyname);
			rs = pst.executeQuery();

			//商品情報をarraylistに格納する。
			while(rs.next()) {
				SyoBean SB = new SyoBean();
				SB.setProcd(rs.getInt("pro_cd"));
				SB.setProname(rs.getString("pro_name"));
				SB.setProprice(rs.getInt("pro_price"));
				syolist.add(SB);
			}
			return syolist;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			//使っているやつ全部閉じる
			try {

				if(rs!=null)rs.close();
				if(pst!=null)pst.close();
				if(cnct!=null)cnct.close();
				return syolist;

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return syolist;
	}

	//カテゴリー検索メソッド
		public ArrayList<SyoBean> cate_pro(String catecd) {
			ArrayList<SyoBean> syolist = new ArrayList<SyoBean>();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				cnct = DriverManager.getConnection(url, id, pw);


				String sql ="select * from product where cat_id=? ";
				pst = cnct.prepareStatement(sql);
				pst.setString(1,catecd);
				rs = pst.executeQuery();

				//商品情報をarraylistに格納する。
				while(rs.next()) {
					SyoBean SB = new SyoBean();
					SB.setProcd(rs.getInt("pro_cd"));
					SB.setProname(rs.getString("pro_name"));
					SB.setProprice(rs.getInt("pro_price"));
					syolist.add(SB);
				}
				return syolist;

			} catch (SQLException | ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} finally {
				//使っているやつ全部閉じる
				try {

					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					if(cnct!=null)cnct.close();
					return syolist;

				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			return syolist;
		}

		//両方検索メソッド
				public ArrayList<SyoBean> ken_pro(String keyname,String catecd) {
					ArrayList<SyoBean> syolist = new ArrayList<SyoBean>();

					try {
						Class.forName("com.mysql.jdbc.Driver");
						cnct = DriverManager.getConnection(url, id, pw);


						String sql ="select * from product where pro_name=? and cat_id=?";
						pst = cnct.prepareStatement(sql);
						pst.setString(1,keyname);
						pst.setString(2,catecd);
						rs = pst.executeQuery();

						//商品情報をarraylistに格納する。
						while(rs.next()) {
							SyoBean SB = new SyoBean();
							SB.setProcd(rs.getInt("pro_cd"));
							SB.setProname(rs.getString("pro_name"));
							SB.setProprice(rs.getInt("pro_price"));
							syolist.add(SB);
						}
						return syolist;

					} catch (SQLException | ClassNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} finally {
						//使っているやつ全部閉じる
						try {

							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
							if(cnct!=null)cnct.close();
							return syolist;

						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					return syolist;
				}

				//詳細画面メソッド
				public ArrayList<SyosaiBean> syosai(String procd) {
					ArrayList<SyosaiBean> syosailist = new ArrayList<SyosaiBean>();

					try {
						Class.forName("com.mysql.jdbc.Driver");
						cnct = DriverManager.getConnection(url, id, pw);


						String sql ="select * from product where pro_cd=?";
						pst = cnct.prepareStatement(sql);
						pst.setString(1,procd);
						rs = pst.executeQuery();

						//商品情報をarraylistに格納する。
						while(rs.next()) {
							SyosaiBean SB = new SyosaiBean();
							SB.setPro_cd(rs.getString("pro_cd"));
							SB.setPro_name(rs.getString("pro_name"));
							SB.setPrice(rs.getString("pro_price"));
							SB.setCat_id(rs.getString("cat_id"));
							SB.setStock(rs.getString("stock_no"));
							SB.setImg(rs.getString("pro_img"));
							SB.setMsg(rs.getString("pro_msg"));
							syosailist.add(SB);
						}
						return syosailist;

					} catch (SQLException | ClassNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} finally {
						//使っているやつ全部閉じる
						try {

							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
							if(cnct!=null)cnct.close();
							return syosailist;

						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					return syosailist;
				}

				//特定カテゴリー名メソッド
				public String cana(String catid) {
					String catname ="";

					try {
						Class.forName("com.mysql.jdbc.Driver");
						cnct = DriverManager.getConnection(url, id, pw);


						String sql ="select * from category where cat_id=?";
						pst = cnct.prepareStatement(sql);
						pst.setString(1,catid);
						rs = pst.executeQuery();

						//商品情報をarraylistに格納する。
						rs.next();
							catname = rs.getString("cat_name");

						return catname;

					} catch (SQLException | ClassNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} finally {
						//使っているやつ全部閉じる
						try {

							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
							if(cnct!=null)cnct.close();
							return catname;

						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					return catname;
				}

				//a特定在庫取得メソッド
				public int stockget(int procd) {
					int restock=0;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						cnct = DriverManager.getConnection(url, id, pw);


						String sql ="select * from product where pro_cd=?";
						pst = cnct.prepareStatement(sql);
						pst.setInt(1,procd);
						rs = pst.executeQuery();

						//a商品情報をarraylistに格納する。
						rs.next();
							restock = rs.getInt("stock_no");

							System.out.println("在庫は、"+restock);

						return restock;

					} catch (SQLException | ClassNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} finally {
						//a使っているやつ全部閉じる
						try {

							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
							if(cnct!=null)cnct.close();
							return restock;

						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					return restock;
				}

				//a在庫数再セットメソッド
				public void stockdown(int procd,int stock) {

					try {
						Class.forName("com.mysql.jdbc.Driver");
						cnct = DriverManager.getConnection(url, id, pw);


						String sql ="update product set stock_no=? where pro_cd=?";
						pst = cnct.prepareStatement(sql);
						pst.setInt(1,stock);
						pst.setInt(2,procd);
						pst.executeUpdate();

					} catch (SQLException | ClassNotFoundException e) {
						e.printStackTrace();
					} finally {
						//使っているやつ全部閉じる
						try {

							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
							if(cnct!=null)cnct.close();

						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
				}

				//a明細セットメソッド
				public void meiset(int userid,int procd,int total) {

					try {
						Class.forName("com.mysql.jdbc.Driver");
						cnct = DriverManager.getConnection(url, id, pw);

						String sql ="insert into meisai values(null,?,?,now(),?)";
						pst = cnct.prepareStatement(sql);
						System.out.println(userid+"をセット！");
						pst.setInt(1,userid);
						System.out.println(procd+"をセット！");
						pst.setInt(2,procd);
						System.out.println(total+"をセット！");
						pst.setInt(3,total);
						System.out.println("いっけえええええええ");
						pst.executeUpdate();
						System.out.println("やったああああああああああああ");

					} catch (SQLException | ClassNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} finally {
						//使っているやつ全部閉じる
						try {

							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
							if(cnct!=null)cnct.close();

						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
				}
}
