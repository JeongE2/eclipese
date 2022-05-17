import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.4:3306/study";
			conn = DriverManager.getConnection(url, "root", "gfgd");
			System.out.println("DB 연결 성공");

			// Insert문 ?부분은 아래의 입력값이 자동으로 변환이 됩니다.
			String sql = " INSERT INTO test VALUES (?,?,?) ";
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			// Insert 데이터값
			// 이름은 String형태 TEST
			pstmt.setString(index++, "Jon");
			// 나이는 Int형태 99살
			pstmt.setInt(index++, 23);
			// 나이는 String형태 20200607
			pstmt.setString(index++, "20000807");

			// SQL실행
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("데이터값에 이상이 있습니다.");
			} else {
				System.out.println("데이터 Insert 성공!");
			}
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