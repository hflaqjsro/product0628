package javaexp.a00_exp.teamP_05;
import java.sql.*;

public class JDBCtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null; // 데이터 베이스와 연결을 위한 객체 
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
		
		//1. JDBC Driver Class
		String driver="oracle.jdbc.driver.OracleDriver";
				
		//2. 데이터베이스 연결 정보
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott", pwd="tiger";
		
		String SQL = "insert into resume(rsNum, pNum, rsTitle, email, mobile, address1) values(?, ?, ?, ?, ?,?)";

		
		
		int i=0;
		try {
			
			//1. JDBC 드라이버 로딩
			Class.forName(driver);
		
			//2. Connection 생성 
			con = DriverManager.getConnection(url, user, pwd);
			
			// 3. PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장 
			pstmt = con.prepareStatement(SQL); 
			// 4. pstmt.set<데이터타입>(? 순서, 값) ex).setString(), .setInt ... 
			pstmt.setString(1, "rs000004"); 
			pstmt.setString(2, "pm000001"); 
			pstmt.setString(3, "이력서 제목3"); 
			pstmt.setString(4, "allg@gmail.com");
			pstmt.setString(5, "01049211354"); 
			pstmt.setString(6, "서울시 강남구 청담동"); 
			
			
			// 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴 
			int r = pstmt.executeUpdate(); 
			System.out.println(i);
			
			// pstmt.excuteQuery() : select 
			// pstmt.excuteUpdate() : insert, update, delete .. 
			System.out.println("변경된 row : " + r);
			System.out.println(i);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//사용순서와 반대로 close 함 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				} if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
		}
		
		
		
	}

}
