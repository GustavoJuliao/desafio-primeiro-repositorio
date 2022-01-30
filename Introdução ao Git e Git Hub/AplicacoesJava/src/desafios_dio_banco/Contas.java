package desafios_dio_banco;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class Contas extends Banco{
	private String numero;
	
	private boolean ativa;
	
	private Double saldo;
	
	public Cliente cliente;
	
	private Date dataCriacao;
	
	public Contas() {
		Random random = new Random();
		this.numero = "" + random.nextInt(4) + "-" + random.nextInt(1);
		this.cliente = new Cliente();
		this.saldo = 0.0;
		this.ativa = Boolean.TRUE;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
 
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente nome) {
		this.cliente = nome;
	}   

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}




    public void sacar(Contas conta, double valor) {
		if(Validacao.isPossivelRealizarOperacaoBancaria(conta, valor)) {
			double novoSaldo = conta.getSaldo() - valor;
			conta.setSaldo(novoSaldo);
			
			System.out.println("Você sacou: R$ " + valor);
		}
	}

	public void depositar(Contas conta, double valor) {
		if(Validacao.isPossivelRealizarDeposito(valor)) {
			double novoSaldo = conta.getSaldo() + valor;
			conta.setSaldo(novoSaldo);
			
			System.out.println("Você depositou: R$ " + valor);
		}
	}

	public void transferir(Contas suaConta, Contas contaDestino, double valor) {
		if(Validacao.isPossivelRealizarOperacaoBancaria(suaConta, valor)) {
			sacar(suaConta, valor);
			depositar(contaDestino, valor);
			
			System.out.println("Você transferiu para " + contaDestino.getCliente().getNome() + " o total de: R$ " + suaConta.getSaldo());
			System.out.println("Seu saldo atual da sua contas é: R$ " + suaConta.getSaldo());
		}
	}
	
	public void imprimirInfoComum(Contas conta) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		System.out.println("Nome: " + conta.getCliente().getNome());
		System.out.println("CPF: " + conta.getCliente().getCpf());
		System.out.println("Data de Nascimento: " + simpleDateFormat.format(conta.getCliente().getDataNascimento()));
		System.out.println("Banco: " + conta.getNome());
		System.out.println("Agência: " + conta.getAgencia());
		System.out.println("Nº da Conta: " + conta.getNumero());
	}








}