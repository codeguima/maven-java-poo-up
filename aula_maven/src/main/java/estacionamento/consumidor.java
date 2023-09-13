package estacionamento;

import java.util.Scanner;



public class consumidor {

	public static void main(String[] args) {
		
		String placa;
		
		int opcao = 0;
		Scanner teclado = new Scanner(System.in);
		
		
		while(opcao != 4){
			
			System.out.println(" ");
			System.out.println("----------- Digite a opcaoo que desejada -------------");
			System.out.println(" 1 - Entrar Estacionamento  | 2 - Pagar Estacionamento ");
			System.out.println(" 3 - Solicitar Saida        | 4 - Encerrar             ");
			System.out.println();
			System.out.print("Digite: ");
			Integer tipo = teclado.nextInt();teclado.nextLine();
			
			
			if(tipo == 1) {
				System.out.print("Digite a placa do carro: ");
				placa = teclado.nextLine();
		
				estaciona carro = new estaciona();
				carro.acesso(placa);
			}
			if(tipo == 2) {
				
				System.out.print("Digite a placa do carro: ");
				placa = teclado.nextLine();
					
				estaciona carro = new estaciona();
				carro.receberpagamento(carro.calculapermanencia(placa), placa);//grava o valor da permancencia no banco;
				
				System.out.printf("Valor a pagar: %.2f",carro.calculapermanencia(placa));
				System.out.println();
				
				System.out.println("Deseja CPF na nota? 1 - sim | 2-nao ");
				int j = teclado.nextInt();
				
				switch(j) {
				
				case 1:
					
					System.out.print("Digite o seu cpf: ");
					String cpf = teclado.nextLine();
					notafiscal nota = new notafiscal();
					double valor = carro.calculapermanencia(placa);
					carro.gerarnota(cpf, placa, valor);
					break;
					
				case 2:
					System.out.println("Obrigado, volte sempre...!!!");
					break;
				
				}
			}
			
			if(tipo == 3) {
				
				System.out.print("Digite a placa do carro: ");
				placa = teclado.nextLine();
				estaciona carro = new estaciona();
				carro.liberarveiculo(placa);
				opcao = 4;
			}
			if(tipo == 4) {
				System.out.println("Obrigado..!!");
				opcao = 4;
			}
			
			
		}
	}
}
		
		
	

