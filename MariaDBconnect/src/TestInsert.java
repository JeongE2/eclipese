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
			System.out.println("DB ���� ����");

			// Insert�� ?�κ��� �Ʒ��� �Է°��� �ڵ����� ��ȯ�� �˴ϴ�.
			String sql = " INSERT INTO test VALUES (?,?,?) ";
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			// Insert �����Ͱ�
			// �̸��� String���� TEST
			pstmt.setString(index++, "Jon");
			// ���̴� Int���� 99��
			pstmt.setInt(index++, 23);
			// ���̴� String���� 20200607
			pstmt.setString(index++, "20000807");

			// SQL����
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("�����Ͱ��� �̻��� �ֽ��ϴ�.");
			} else {
				System.out.println("������ Insert ����!");
			}
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