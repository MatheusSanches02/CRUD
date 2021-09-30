package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class MainInsert {

	public static void main(String[] args) throws SQLException {
		//endereço do banco Oracle
        //String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
		
		
		String connString =  "jdbc:oracle:thin:@ORACLE.FIAP.COM.BR:1521:ORCL";
		
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser(Dados.user);
		ods.setPassword(Dados.pwd);
		Connection conn = ods.getConnection();
		
		String sql = "INSERT INTO persons (first_name, last_name) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "Matheus");
		ps.setString(2, "Sanches");
		ps.execute();
		
		conn.close();
	}

}
