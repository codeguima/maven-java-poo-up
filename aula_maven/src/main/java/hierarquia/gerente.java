//Aluno: Jhonny Guimarães
//BSI - praça osorio
//RGM: 29318602


package hierarquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gerente extends pessoa{
	
	public gerente(String cpf, String nome, String email, String telefone, String aniversario) {
		super(cpf, nome, email, telefone, aniversario);
	
	
	}
	public gerente() {}
	
	
	Double bonus;
	int departamento;
	
	
	
	public boolean save(String cpf, int funcao, int dpto) {
		
		this.cpf = cpf;
		this.departamento = dpto;
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into func_dpto_funcao(cpf_colaborador, id_funcao, cod_departamento, situacao_cadastral)values(?,?,?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, this.cpf);
			ps.setInt(2, funcao);
			ps.setInt(3, this.departamento);
			ps.setString(4, "Ativo");
			
			
			
			int status = ps.executeUpdate();
			
			
			if(status == 1) {
			
				
				return true;
			}
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
	        
			
		}
		
		
		
		
		
		
		
		
		return false;}

	
	public boolean delete() {
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
		
			
			
			String sql = "delete from func_dpto_funcao where cpf_colaborador = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		
			ps.setString(1, this.cpf);
			
			
			ps.executeUpdate();
			
			int status = ps.executeUpdate();
			
			if(status== 1) {
				return true;
				}
			
			
			
		}catch (SQLException e) {
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
			 
	         
		}
		return false;
		}
	
	
	public void find_one() {
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from func_dpto_funcao where cpf_colaborador = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, this.cpf);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String cpf = rs.getString("cpf_colaborador");
				String ifuncao = rs.getString("id_funcao");
				String cod_departamento = rs.getString("cod_departamento");
				System.out.println("CPF: " +cpf + " \nFUNCAO: " + ifuncao + " \nCODIGO DEPARTAMENTO: " + cod_departamento);
				
			}
		
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
		}
		
	}

	
	public double calculabonus() {
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			
		
		String sql = "SELECT * FROM hierarquia.vw_salario_fucionario where cpf_colaborador = ?";
		
		PreparedStatement  ps = conexao.prepareStatement(sql);
		
		
		ps.setString(1, this.cpf);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			double salario = rs.getDouble("salario");
			
			this.bonus = (salario /100) * 30;
			
			return this.bonus;
		}
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
	        
			
		}
		return this.bonus;
		
		
		
		
	}
}
