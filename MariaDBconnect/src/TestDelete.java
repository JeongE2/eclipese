import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.4/study";
			conn = DriverManager.getConnection(url, "root", "gfgd");
			System.out.println("DB 연결 성공");

			// Update 쿼리문
			String sql = " DELETE FROM test WHERE name = ? ";
			// 객체 생성과 쿼리문을 넘겨줍니다.
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			// Delete 데이터값
			pstmt.setString(index++, "AkibaTV");

			// SQL실행
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("데이터값에 이상이 있습니다.");
			} else {
				System.out.println("데이터 Delete 성공!");
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