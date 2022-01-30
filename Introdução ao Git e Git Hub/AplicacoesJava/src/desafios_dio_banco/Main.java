package desafios_dio_banco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        List<Contas> contas = new ArrayList<Contas>();

        String opcao = "";
        boolean sair = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("*------------------------------------------------------------*");
		System.out.println("|              Bem vindo ao Banco do Brasileiro!             |");
		System.out.println("*------------------------------------------------------------*");
		
		try {
			do {
				System.out.println("*------------------------------------------------------------*");
				System.out.println("|0 - Sair                                                    |");
				System.out.println("|1 - Criar Conta                                             |");
				System.out.println("|2 - Exibir Dados Bancários                                  |");
				System.out.println("|3 - Visualizar Saldo                                        |");
				System.out.println("|4 - Sacar                                                   |");
				System.out.println("|5 - Depositar Poupança                                      |");
				System.out.println("|6 - Transferir                                              |");
				System.out.println("*------------------------------------------------------------*");
				
				System.out.print("Informe a opção: ");
				opcao = scanner.nextLine();
				
				switch (opcao) {
				case "0":
					System.out.println("*------------------------------------------------------------*");
					System.out.println("|              APLICAÇÃO ESTÁ SENDO ENCERRADA ...            |");
					System.out.println("|                       OBRIGADO!                            |");
					System.out.println("*------------------------------------------------------------*");
					sair = true;
					
					break;
				case "1":
					System.out.println("-> CRIAR CONTA");
					Contas c1 = new Contas();
					System.out.print("Informe o nome da pessoa: ");
					c1.getCliente().setNome(scanner.nextLine());
					
					System.out.print("Informe o CPF da pessoa: ");
					c1.getCliente().setCpf(scanner.nextLine());
					
					System.out.print("Informe a data de nascimento da pessoa: ");
					String dataNascimento = scanner.nextLine();
					
					if(!dataNascimento.isEmpty()) {
						c1.getCliente().setDataNascimento(simpleDateFormat.parse(dataNascimento));
					}
					
					if(Validacao.isPossivelCadastrarConta(c1)) {
						contas.add(c1);
						
						System.out.println("Conta criada com sucesso!");
					}
					
					break;



				case "2":
					System.out.println("-> LISTAR CONTAS");
					
					if(!contas.isEmpty()) {
						for (Contas conta : contas) {
							System.out.println("Número:" + conta.getNumero() + "Agência: " + conta.agencia);
						}
					}else{
                        System.out.println("Não há contas cadastradas!");
                    }
					
					break;


                    
				case "3":
					System.out.println("-> SALDO");
					
					System.out.print("Informe o CPF da pessoa: ");
					String cpfSaldo = scanner.nextLine();
					
					if(Validacao.isContaExistente(contas, cpfSaldo)) {
						for (Contas conta : contas) {
							if(conta.getCliente().getCpf().equals(cpfSaldo)) {
								System.out.println("O saldo é de: " + conta.getSaldo());
							}
						}	
					}
					break;



                    
				case "4":
					System.out.println("-> SAQUE");
					
					System.out.print("Informe o CPF da pessoa: ");
					String cpfSacar = scanner.nextLine();
					
					if(Validacao.isContaExistente(contas, cpfSacar)) {
						String valor;
						
						System.out.print("Informe o valor do saque: ");
						valor = scanner.nextLine();
						
						for (Contas conta : contas) {
							if(conta.getCliente().getCpf().equals(cpfSacar)) {
								conta.sacar(conta, Double.parseDouble(valor));
							}
						}
					}
					
					break;	



                    
				case "5":
					System.out.println("-> DEPÓSITO");
					
					System.out.print("Informe o CPF da pessoa: ");
					String cpfDeposito = scanner.nextLine();
					
					if(Validacao.isContaExistente(contas, cpfDeposito)) {
						String valor;
						
						System.out.print("Informe o valor do depósito: ");
						valor = scanner.nextLine();
						
						for (Contas conta : contas) {
							if(conta.getCliente().getCpf().equals(cpfDeposito)) {
								conta.depositar(conta, Double.parseDouble(valor));
							}
						}
					}
					
					break;



                    
				case "6":
                    Contas c2 = new Contas();
					System.out.println("-> TRANSFERÊNCIA");
					
					System.out.print("Informe o CPF do depositante: ");
					String cpfDepositante = scanner.nextLine();
					
					System.out.print("Informe o CPF do recebedor: ");
					String cpfRecebedor = scanner.nextLine();
					
					if(Validacao.isContaExistente(contas, cpfDepositante) 
								&& Validacao.isContaExistente(contas, cpfRecebedor)) {
						Contas contaDepositante = null, contaRecebedor = null;
						String valor;
						
						System.out.print("Informe o valor do depósito: ");
						valor = scanner.nextLine();
						
						for (Contas conta : contas) {
							if(conta.getCliente().getCpf().equals(cpfDepositante)) {
								contaDepositante = conta;
							}else if (conta.getCliente().getCpf().equals(cpfRecebedor)){
								contaRecebedor = conta;
							}
						}
						c2.transferir(contaDepositante, contaRecebedor, Double.parseDouble(valor));
					}
					
					break;	
				default:
					break;
				}



                    
			}while(!sair);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}

        

    }
}
