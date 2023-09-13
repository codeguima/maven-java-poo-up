//Aluno: Jhonny Guimarães
//BSI - praça osorio
//RGM: 29318602


package hierarquia;

public abstract class pessoa {
	protected String cpf;
	protected String nome;
	protected String email;
	protected String aniversario;
	protected String telefone;
	
	
	
	public pessoa(String cpf, String nome, String email, String telefone, String aniversario) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.aniversario = aniversario;
		this.telefone = telefone;
		
		
	}
	
	public pessoa() {}
	
	
	
	
	public boolean save() {
		return false;}
	
	public boolean delete() {
		return false;}
	
	public void find_one() {}
	
}
