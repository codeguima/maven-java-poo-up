//aluno: Jhonny Guimaraes
//rgm: 29318602

package escolaPOO;

import java.util.ArrayList;

public class turma {
	
	String curso;
	professor professor;
	
	public ArrayList<turma> turmas = new ArrayList<turma>();
	public ArrayList<aluno> alunos = new ArrayList<aluno>();
	
	
	
	public ArrayList<aluno> acessoarrayalunos() {
		
		
			for( turma x : turmas) {
			
			 return x.alunos;
		}
		
		return null;
		
		
		
	}
	
	public void cadeoaluno() {
		
		
		for(int cont = 0; cont< acessoarrayalunos().size(); cont ++) {
			
			System.out.println(acessoarrayalunos().get(cont).imprimealuno());
			System.out.println();
			
		}
		
		
	}
	
	
	
	
	
	public turma imprimeturmas() {
		
		
		
		for( turma x : turmas){
			
			return x;
			
		}
		return null;
		
	}


	
}
