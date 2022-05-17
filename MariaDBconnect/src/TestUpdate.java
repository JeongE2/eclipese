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
			System.out.println("DB ���� ����");

			// Update ������
			String sql = " UPDATE test SET name = ?, age = ?, birthday = ? ";
			// ��ü ������ �������� �Ѱ��ݴϴ�.
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			// Update �����Ͱ�
			// �̸��� String���� AkibaTV
			pstmt.setString(index++, "AkibaTV");
			// ���̴� Int���� 15��
			pstmt.setInt(index++, 15);
			// ���̴� String���� 19990101
			pstmt.setString(index++, "19990101");

			// SQL����
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("�����Ͱ��� �̻��� �ֽ��ϴ�.");
			} else {
				System.out.println("������ Update ����!");
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