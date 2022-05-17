import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
    ResultSet rs = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.4:3306/study";
			conn = DriverManager.getConnection(url, "root", "gfgd");
			System.out.println("DB 연결 성공");

			// Select 쿼리문
			String sql = " SELECT name, age, birthday FROM test ";
			// 객체 생성
			stmt = conn.createStatement();
			// SQL실행
			rs = stmt.executeQuery(sql);

			// 결과값 출력
			while (rs.next()) {
				String name = rs.getString(1);
				String age = rs.getString(2);
				String birthday = rs.getString(3);

				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
				System.out.println("생년월일 : " + birthday);
			}
		} catch (ClassNotFoundException e){
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