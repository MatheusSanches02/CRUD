package TestCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.pool.OracleDataSource;

public class GerenciadorClientes {
	
	private String connString = "jdbc:oracle:thin:@ORACLE.FIAP.COM.BR:1521:ORCL";
	private Connection conn;
	
	public GerenciadorClientes() throws Exception{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser(Dados.user);
		ods.setPassword(Dados.pwd);
		conn = ods.getConnection();
	}
	
	public List<Cliente> listar() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM persons";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("person_id");
			String nome = rs.getString("first_name");
			String sobrenome = rs.getString("last_name");
			clientes.add(new Cliente(id, nome, sobrenome));
		}
		return clientes;
	}
	
	public void inserir(Cliente c) throws Exception{
		String sql = "INSERT INTO persons (first_name, last_name) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getNome());
		ps.setString(2, c.getSobrenome());
		ps.execute();
	}
	
	public void atualizar(Cliente c) throws Exception{
		String sql = "UPDATE persons SET first_name=? WHERE person_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getNome());
		ps.setString(2, c.getSobrenome());
		ps.setInt(3, 1);
		
		ps.executeQuery();
	}
	
	public void excluir(Integer id) throws Exception{
		String sql = "DELETE FROM persons WHERE person_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, 1);
		ps.execute();
	}
}
