

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankIdAccountDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	String name;
	String id;
	String account;

	public boolean list(MemberVo v) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

//			String sql = "select id, account from cmember where id = '" + v.getId() + "'";
			String sql = "select id, account from usermember where id = '" + v.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
				account = rs.getString("account");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
}
