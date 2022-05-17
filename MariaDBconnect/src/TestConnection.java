import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			// mariaDB ����̹� ����
			Class.forName("org.mariadb.jdbc.Driver");

			// ������ DB�ּ� ����
			String url = "jdbc:mariadb://192.168.0.4:3306/study";

			// ������ ���̵�, ��й�ȣ ����
			conn = DriverManager.getConnection(url, "root", "gfgd");
			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("mariaDB Driver�� ã���� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("Database ������ ������ �߻� �߽��ϴ�.");
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