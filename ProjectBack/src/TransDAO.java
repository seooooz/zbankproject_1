import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	private Statement stmt;
	private ResultSet rs;
	
	String account;
	String myaccount;

	public boolean list(NewVo n) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

//			String sql = "INSERT INTO cmember(name, id, password, account, cdate) values(?,?,?,accountid.NEXTVAL,sysdate)";
			String sql = "SELECT account FROM usermember WHERE id='" + n.getId() + "'";

			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, n.getName());
//			pstmt.setString(2, n.getId());
//			pstmt.setString(3, n.getPassword());
//			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
	
	public boolean list() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

//			String sql = "INSERT INTO cmember(name, id, password, account, cdate) values(?,?,?,accountid.NEXTVAL,sysdate)";
			String sql = "SELECT account FROM usermember WHERE id='" + account + "'";

			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, n.getName());
//			pstmt.setString(2, n.getId());
//			pstmt.setString(3, n.getPassword());
//			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				myaccount = rs.getString("account");
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

