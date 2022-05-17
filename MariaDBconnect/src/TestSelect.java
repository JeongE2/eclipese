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
			System.out.println("DB ���� ����");

			// Select ������
			String sql = " SELECT name, age, birthday FROM test ";
			// ��ü ����
			stmt = conn.createStatement();
			// SQL����
			rs = stmt.executeQuery(sql);

			// ����� ���
			while (rs.next()) {
				String name = rs.getString(1);
				String age = rs.getString(2);
				String birthday = rs.getString(3);

				System.out.println("�̸� : " + name);
				System.out.println("���� : " + age);
				System.out.println("������� : " + birthday);
			}
		} catch (ClassNotFoundException e){
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