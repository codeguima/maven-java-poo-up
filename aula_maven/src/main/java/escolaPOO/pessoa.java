//aluno: Jhonny Guimaraes
//rgm: 29318602

package escolaPOO;

public abstract class pessoa {
	String nome;
	String cpf;
	String email;
	
	
	public pessoa() {}
	
	
	public pessoa(String nome, String cpf, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}


	public String imprimeturma() {
		
		String turma;
		turma = this.nome + " " + this.cpf + " " + this.email;
		
		return turma;
	}


	public String imprimealuno() {
		
		String aluno;
		
		aluno = this.nome + " " + this.cpf + " " + this.email;
		
		return aluno;
		
	}


	
}


