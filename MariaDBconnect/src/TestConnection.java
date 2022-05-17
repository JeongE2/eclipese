import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			// mariaDB 드라이버 설정
			Class.forName("org.mariadb.jdbc.Driver");

			// 접속할 DB주소 설정
			String url = "jdbc:mariadb://192.168.0.4:3306/study";

			// 접속할 아이디, 비밀번호 설정
			conn = DriverManager.getConnection(url, "root", "gfgd");
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("mariaDB Driver를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println("Database 연결중 에러가 발생 했습니다.");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}