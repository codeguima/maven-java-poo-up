package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lojacoisasecoisas.bancodedados;

	

public class estaciona {
	
	double valorhora = 5.50;
	
	
	
	public void acesso(String placa) {
		//metodo para salvar a placa e datetime de acesso ao estacionamento;
		
		
		Connection conexao = conectaBanco.getConexaoMySQL();
		
		
		try {
			
			
			//=================================================================//
			
				//pegar data e hora atual para inseiri no banco;
				LocalDateTime agora = LocalDateTime.now();
			
				DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu-MM-dd "+"HH:mm:ss");
				String chegada = formatterData.format(agora);
			
				
			//=================================================================//
				
				
			String sql = "insert into veiculos(placa, chegada) values(?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, placa);
			
			ps.setString(2, chegada);
			
			int status = ps.executeUpdate();
			
			if(status!= 0) {
				System.out.println("Seja bem vindo....!!!");
			if(status == 0) {
				System.out.println("Tente novamente...!!");
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}


	public void updatesaida(String veiculoplaca) {
		//este metodo envia a hora de saida para o banco de dados quando o 
		//cliente solicita a saida do estacionamento.
		//este metodo é ativado automaticamente pelo metodo calculapermanencia();
		

		//=================================================================//
		
		//pegar data e hora atual para inserir no banco;
		LocalDateTime agora = LocalDateTime.now();
	
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu-MM-dd "+"HH:mm:ss");
		String saida = formatterData.format(agora);
	
		
	//=================================================================//
		
		Connection conexao = conectaBanco.getConexaoMySQL();
	
	
		try {
			
			String sql = "UPDATE veiculos SET saida = ? WHERE (placa = ?)";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, saida);
			ps.setString(2, veiculoplaca);
			
			ps.executeUpdate();
			
		
			
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}


	public double calculapermanencia(String placa) {
		
		updatesaida(placa);
		
		Connection conexao = conectaBanco.getConexaoMySQL();
		
		
		try {
			
			String sql = "SELECT TIMESTAMPDIFF(HOUR, chegada + INTERVAL TIMESTAMPDIFF(DAY,  chegada, saida) DAY, saida) AS PERMANCENCIA from veiculos where placa =?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, placa);
			
			ResultSet rs = ps.executeQuery();
			double saida = 0;
			while(rs.next()) {
				int saida1 = rs.getInt("PERMANCENCIA");
				
				saida = saida1 * valorhora;
				
				
			}
			return saida;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
		
		
	public void receberpagamento(Double valor, String placa) {
		
		Connection conexao = conectaBanco.getConexaoMySQL();
		
		
		try {
			
			String sql = "UPDATE veiculos SET valorpago= ? WHERE (placa = ?)";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setDouble(1, valor);
			ps.setString(2, placa);
			

			
			int retorno = ps.executeUpdate();
			
			if(retorno != 0) {
				System.out.println("Pagamento recebido!");
			}
			
			
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
		
	
	public void liberarveiculo(String veiculoplaca){

		//metodo apenas para consultar o veiculo no estacionamento
	
		Connection conexao = conectaBanco.getConexaoMySQL();
	
	
	try {
		
		String sql = "select valorpago from veiculos where placa= ?";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, veiculoplaca);
		
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()) {
			
			String status = rs.getString("valorpago");
			
			if(status != null) {
				System.out.println("Liberado, volte sempre...!!");
			}
			if(status == null) {
				System.out.println("Favor validar o pagamento...!!");
			}
	}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	
	public void gerarnota(String cpf, String placa, Double valor){
		 
		 Connection conexao = conectaBanco.getConexaoMySQL();
		 
		 try {
			
			String sql = "insert into notafiscal(cpf, descricao) values(?, Nota referenete a servicos prestados de estacionamento no valor de ?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, cpf);
			
			ps.setDouble(2, valor);
			
			int status = ps.executeUpdate();
			
			if(status!= 0) {
				System.out.println("Realizado..");
			if(status == 0) {
				System.out.println("não realizado..!!");
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 
	 }
	 	
	}










	

