

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// db�� ����� id == pw ã���ִ� sql
public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public boolean list(MemberVo p) {

		try {
			connDB();

//			String query = "SELECT id, password FROM cmember WHERE id='" + p.getId() + "' AND password ='"+ p.getPassword() + "'";
			String query = "SELECT id, password FROM signup WHERE id='" + p.getId() + "' AND password ='"+ p.getPassword() + "'";
//            System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			// ������ �̵�
			rs.last();

			if (rs.getRow() == 0) {
//                System.out.println("0 row selected.....");
			} else {
				return true;
			}
						

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void connDB() {
		try {
			Class.forName(driver);
//	            System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
//	            System.out.println("oracle connection success.");
			// stmt = con.createStatement();
			// ������ �̵��Ѱ� �����ϱ� ���� ��ɾ��
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//	            System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
