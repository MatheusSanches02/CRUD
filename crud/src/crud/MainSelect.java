package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class MainSelect {

	public static void main(String[] args) throws SQLException {
		//endereço do banco Oracle
        //String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
		
		String connString = "jdbc:oracle:thin:@ORACLE.FIAP.COM.BR:1521:ORCL";
		
		OracleDataSource ods  = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser(Dados.user); //adicione o seu usuário - "userName"
		ods.setPassword(Dados.pwd); //adicione seu password - "userPwd"
		Connection conn = ods.getConnection();
		
		String sql = "SELECT * FROM persons";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs  = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("person_id"));
			System.out.println(rs.getString("first_name"));
			System.out.println(rs.getString("last_name"));
		}
		
		conn.close();

	}

}
