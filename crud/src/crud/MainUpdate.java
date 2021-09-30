package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class MainUpdate {

	public static void main(String[] args) throws SQLException {
		
		String connString =  "jdbc:oracle:thin:@ORACLE.FIAP.COM.BR:1521:ORCL";
		
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser(Dados.user);
		ods.setPassword(Dados.pwd);
		Connection conn = ods.getConnection();
		
		String sql = "UPDATE persons SET first_name=?, last_name=? WHERE person_id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "nome");
		ps.setString(2, "sobrenome");
		ps.setInt(3, 32);
		
		ps.executeQuery();
		
		conn.close();
	}

}
