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
			System.out.println("DB ���� ����");

			// Update ������
			String sql = " DELETE FROM test WHERE name = ? ";
			// ��ü ������ �������� �Ѱ��ݴϴ�.
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			// Delete �����Ͱ�
			pstmt.setString(index++, "AkibaTV");

			// SQL����
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("�����Ͱ��� �̻��� �ֽ��ϴ�.");
			} else {
				System.out.println("������ Delete ����!");
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