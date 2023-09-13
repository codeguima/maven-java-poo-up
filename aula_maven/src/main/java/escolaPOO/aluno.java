//aluno: Jhonny Guimaraes
//rgm: 29318602

package escolaPOO;



public class aluno extends pessoa {
		public aluno(String nome, String cpf, String email) {
			super(email, email, email);
		
			
			
		}
		
		
		public aluno() {}
		
		String aluno;
		String matricula;
	

		public String imprimealuno() {
			
			try {
				String aluno ="nome: " + this.nome + "\ncpf: " + this.cpf + "\nemail: "+ this.email + "\nmatricula: " + matricula;
				return aluno;
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return aluno;
		}
		
		
	}