import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.4:3306/study";
			conn = DriverManager.getConnection(url, "root", "gfgd");
			System.out.println("DB 연결 성공");

			// Update 쿼리문
			String sql = " UPDATE test SET name = ?, age = ?, birthday = ? ";
			// 객체 생성과 쿼리문을 넘겨줍니다.
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			// Update 데이터값
			// 이름은 String형태 AkibaTV
			pstmt.setString(index++, "AkibaTV");
			// 나이는 Int형태 15살
			pstmt.setInt(index++, 15);
			// 나이는 String형태 19990101
			pstmt.setString(index++, "19990101");

			// SQL실행
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("데이터값에 이상이 있습니다.");
			} else {
				System.out.println("데이터 Update 성공!");
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