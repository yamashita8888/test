package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sample1JDBC {

	public static void main(String[] args) {

		//DBに接続する際に使うやつ
		Connection conn = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		//SQLを実行するときに使うやつ
		Statement st = null;

		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに接続する際に必要な情報を変数に格納
			String url = "jdbc:mysql://localhost/ec";
			String id = "root";
			String pass = "password";

			//DBに実際に接続する。
			conn = DriverManager.getConnection(url, id, pass);

			// 接続に失敗した場合SQLExcelptionを投げる
			st = conn.createStatement();

			//SQL文の実行を行っています。
			//実行を結果をrsに代入している
			rs = st.executeQuery("SELECT * FROM product WHERE cat_id=1");

			ResultSet result = statement.executeQuery();



		} catch (ClassNotFoundException ex) {

			System.out.println("エラーが起きました。");

			ex.printStackTrace();

		} catch (SQLException ex) {

			System.out.println("データベースに接続失敗しました。");

			ex.printStackTrace();
		} finally {

			//下記行でDBの接続を解除している。
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
	}
}
