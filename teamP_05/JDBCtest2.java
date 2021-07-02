package javaexp.a00_exp.teamP_05;

import java.sql.*;

public class JDBCtest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null; // 데이터 베이스와 연결을 위한 객체
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott", pwd = "tiger";

		// 데이터베이스 PW
		String SQL = "SELECT * FROM resume where pNum='pm000001' order by rsNum";
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
			// 2. Connection 객체 생성
			con = DriverManager.getConnection(url, user, pwd);

			// DB 연결
			// 3. Statement 객체 생성
			stmt = con.createStatement();
			// 4. SQL 문장을 실행하고 결과를 리턴
			// stmt.excuteQuery(SQL) : select
			// stmt.excuteUpdate(SQL) : insert, update, delete ..
			rs = stmt.executeQuery(SQL);
			// 5. ResultSet에 저장된 데이터 얻기 - 결과가 2개 이상
			while (rs.next()) {
				String rsNum = rs.getString("rsNum");
				String pNum = rs.getString("pNum");
				String rsTitle = rs.getString("rsTitle");
				String address1 = rs.getString("address1");
				String email = rs.getString(5); // rs.getString("email");

				System.out.println(rsNum + " " + pNum + " " + rsTitle + " " + address1 + " " + email);
			}
			// 5. ResultSet에 저장된 데이터 얻기 - 결과가 1개
			// if(rs.next()) {
			//
			// }
			// else {
			//
			// }
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]");
		} finally { // 사용순서와 반대로 close 함
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
