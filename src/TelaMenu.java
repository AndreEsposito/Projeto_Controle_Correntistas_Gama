import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TelaMenu {

	public static void main(String[] args) throws IOException {
		ArrayList<ControleDados> contas = new ArrayList<ControleDados>();
	
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		int ag;
		String conta;
		String telefone;
		String nome;
		String email; 
		double saldo;
		
		while (opcao != 5) {
			System.out.println("\n============== MENU ==============");
			System.out.println("1 - Cadastrar Clientes");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Gravar em arquivo texto");
			System.out.println("4 - Consultar arquivo texto");
			System.out.println("5 - Sair");
			System.out.println("==================================");
			System.out.println("Escolha a op��o desejada : ");
			opcao = entrada.nextInt();
			
			if (opcao == 5) {
				System.out.println("Saindo do Sistema!!");
			} else {
				switch (opcao) {
				case 1:
					System.out.println("Digite sua ag�ncia: ");
					ag = entrada.nextInt();
					System.out.println("Digite sua conta: ");
					conta = entrada.next();
					System.out.println("Digite seu nome: ");
					nome = entrada.next();
					System.out.println("Digite seu email: ");
					email = entrada.next();
					System.out.println("Digite seu tefelone: ");
					telefone = entrada.next();
					System.out.println("Digite o saldo da conta: ");
					saldo = entrada.nextDouble();
					
					ControleDados cadastros = new ControleDados(ag, conta, nome, email, telefone, saldo);
					contas.add(cadastros);
					
					System.out.println("Contas cadastradas com sucesso!");
					break;
				case 2:
					if (contas.isEmpty()) {
						System.out.println("Nenhum cliente cadastrado!");
					} else {
						for (ControleDados registros:contas) {
							System.out.println(registros);
						}
					}
					break;
				case 3:
					// abre um espa�o na mem�ria
					FileWriter arquivo = new FileWriter("E:\\Documentos\\Lightshot\\Trein_Itau\\Trein_Complementar\\Registro_de_cadastros.txt");
					
					// guarda o conte�do no espa�o alocado
					PrintWriter gravarArquivo = new PrintWriter(arquivo);
					
					gravarArquivo.println("Registro de Contas :");
					for (ControleDados registros:contas) {
						gravarArquivo.println(registros); 
					}
					
					arquivo.close();	
					System.out.println("Gravado na mem�ria.");
					System.out.println("Local salvo: E:\\Documentos\\Lightshot\\Trein_Itau\\Trein_Complementar");
					System.out.println("Nome do arquivo: Registro_de_cadastros");
					break;
				case 4:
					String nomeArquivo="E:\\Documentos\\Lightshot\\Trein_Itau\\Trein_Complementar\\Registro_de_cadastros.txt"; 
					String linha = "";
					File arq = new File(nomeArquivo);
					
					// analisa para verificar se o arquivo existe
					if(arq.exists()) {					
						// processo de tentativa da leitura das informac�es contidas no arquivo
						try {
							FileReader reader = new FileReader(nomeArquivo);
							
							// l� todo o arquivo e armazena no Buffer da mem�ria
							BufferedReader leitor = new BufferedReader(reader);
							while(true) {
								linha = leitor.readLine();
								System.out.println(linha);
								if(linha == null)
									break;
							}
						}
						catch(Exception erro) {}
					} else {
						System.out.println("Arquivo Nao Existe!");
					} 
					break;
				case 5:
					System.out.println("Saindo...");
					System.out.println("Obrigado, volte sempre!");
					break;
				default:
					System.out.println("Op��o inv�lida. Tente novamente!");
				}
			}
		}
		
		entrada.close();
	}
}