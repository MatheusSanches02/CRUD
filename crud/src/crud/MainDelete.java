package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class MainDelete {

	public static void main(String[] args) throws SQLException {
		
		String connString = "jdbc:oracle:thin:@ORACLE.FIAP.COM.BR:1521:ORCL";
		
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser(Dados.user);
		ods.setPassword(Dados.pwd);
		Connection conn = ods.getConnection();
		
		String sql = "DELETE FROM persons WHERE person_id = 1";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.execute();
		
		conn.close();
		
				
	}

}
