	package web;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

	public class jdbcjava {


		public ArrayList<logicBean> login(String login_cd, String login_pw) {

			String url = "jdbc:mysql://localhost/ec";
			String id = "root";
			String pw = "password";

			Connection cnct = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			// logicBeanを格納するArrayListを定義
			ArrayList<logicBean> list = new ArrayList<logicBean>();

			// DBに接続
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cnct = DriverManager.getConnection(url, id, pw);

				// PreparedStatementを使用する方が理想
				// ※引数の数が変更することがないため
				// ※SQL文で取得するデータを限定すること
				String sql = "SELECT * FROM user WHERE login_cd = ? AND login_pw = ?";
				pst = cnct.prepareStatement(sql);

				// パラメータをセット
				pst.setString(1,login_cd);
				pst.setString(2,login_pw);

				// SQLを実行する
				rs = pst.executeQuery();

				// 取得データ分繰り返し
				while (rs.next()) {
					// logicBeanにuserテーブルのデータを格納
					logicBean logic = new logicBean();
//					logic.setUserId(rs.getInt(1));
//					logic.setUserName(rs.getString(2));
					logic.setLoginCd(rs.getString(3));
					logic.setLoginPw(rs.getString(4));
					// ArrayListに格納
					list.add(logic);
				}

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pst != null)
						pst.close();
					if (cnct != null)
						cnct.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			// 戻り値を返却
			return list;

		}

	}
