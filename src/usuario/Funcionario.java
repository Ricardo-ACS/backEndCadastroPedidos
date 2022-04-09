package usuario;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import Cozinha.Cozinha;
import Pedido.Pedido;
import Produto.Produto;
import Restaurante.Restaurante;
import Util.Endereco;

public class Funcionario extends Usuario{

	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa");
	Restaurante restaurante = new Restaurante();
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String email, String senha) {
		super(nome, email, senha);
	}

	@Override
	public void pedido(Restaurante restaurante, Produto produto, Date dataCriacao, Endereco enderecoEntrega, 
					   Integer quantidade, BigDecimal precoUnitario, 
					   String observacao) throws InterruptedException {

		Pedido pedido = new Pedido(dataCriacao, enderecoEntrega);
		//BigDecimal precoDesconto = precoUnitario.subtract(precoUnitario.multiply(BigDecimal.valueOf(0.05)));
		pedido.fazerListaPedidos(produto, quantidade, precoUnitario, observacao);
		pedido.enviarPedido();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Pedido: " + produto.getNome() 
		+ ", Preço pedido: " + ((produto.getPreco().multiply(BigDecimal.valueOf(quantidade)).multiply(BigDecimal.valueOf(0.95)))) 
		+ ", Taxa de entrega: " + this.getRestaurante().getTaxaFrete()
		+ ", Preço total: " 
		+ (((produto.getPreco().multiply(BigDecimal.valueOf(quantidade)).multiply(BigDecimal.valueOf(0.95)))).add(this.getRestaurante().getTaxaFrete())));
		System.out.println(enderecoEntrega);
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	@Override
	public void cadastrar(String nome, BigDecimal taxaFrete, boolean ativo, 
			boolean aberto, Date dataCadastro, 
			Date dataAtualizacao, Cozinha cozinha,
			Endereco endereco) {
			restaurante = new Restaurante(nome, taxaFrete, ativo,
				aberto, dataCadastro, dataAtualizacao, cozinha, endereco);
		
		System.out.println("Restaurante cadastrado com sucesso.");
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}
	@Override
	public String toString() {
		return "Funcionario cadastrado: " + getNome() 
			   + ", \n e-mail: " + getEmail();
	}

	
	

}
