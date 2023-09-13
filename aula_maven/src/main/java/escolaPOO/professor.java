//aluno: Jhonny Guimaraes
//rgm: 29318602

package escolaPOO;


public class professor extends pessoa {
	public professor(String nome, String cpf, String email) {
		super(email, email, email);
		
	}
		
	public professor() {}
	
	String prof;
	
	public String imprimeprofessor() {
		
		try {
			String prof = "nome: " + this.nome + "\ncpf: " + this.cpf + "\nemail: "+ this.email;
			return prof;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prof;
	}
	
}

