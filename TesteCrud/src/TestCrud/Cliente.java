package TestCrud;

public class Cliente {
	private Integer id;
	private String nome;
	private String sobrenome;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Cliente(Integer id, String nome, String sobrenome) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome;
	}
}
