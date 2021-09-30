package TestCrud;

import java.util.List;

public class TestaBancoDados {
	public static void main(String[] args) throws Exception {
		GerenciadorClientes gc = new GerenciadorClientes();
		
		gc.inserir(new Cliente("Fernando", "Almeida"));
		List<Cliente> clientes = gc.listar();
		
		for(Cliente c : clientes) {
			System.out.println(c.toString());
		}
	}
}
