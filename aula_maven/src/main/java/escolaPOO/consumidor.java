//aluno: Jhonny Guimaraes
//rgm: 29318602

package escolaPOO;

public class consumidor {

	public static void main(String[] args) {
		
		turma nova; 
		nova= new turma();
		
		nova.professor = new professor();
		
		nova.professor.nome ="jose";
		nova.professor.cpf="654987";
		nova.professor.email="jose@gmail.com";
		nova.curso = "BSI";
		
		
		
		aluno l, g;
		l= new aluno();
		
		l.cpf = "12345";
		l.nome = "joao";
		l.email = "joao@gmail.com";
		l.matricula = "222";
		
		nova.alunos.add(l);
		
		g= new aluno();
		
		g.cpf = "789123";
		g.nome = "pedro";
		g.email = "jopedro@gmail.com";
		g.matricula = "333";
		
		
		nova.alunos.add(g);
		
		nova.turmas.add(nova);
		
		System.out.println("Professor: ");
		System.out.println(nova.imprimeturmas().professor.imprimeprofessor());
		System.out.println("\nAlunos: ");
		
		nova.cadeoaluno();
	}

}
