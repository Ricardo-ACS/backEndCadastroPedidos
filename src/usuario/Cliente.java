package usuario;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import Cozinha.Cozinha;
import Pedido.Pedido;
import Produto.Produto;
import Restaurante.Restaurante;
import Util.Endereco;

public class Cliente extends Usuario{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa");
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, String email, String senha) {
		super(nome, email, senha);
	}

	
	@Override
	public void pedido(Restaurante restaurante, Produto produto, Date dataCriacao, 
			Endereco enderecoEntrega, Integer quantidade, 
			BigDecimal precoUnitario, String observacao) throws InterruptedException {

		Pedido pedido = new Pedido(dataCriacao, enderecoEntrega);
		pedido.fazerListaPedidos(produto, quantidade, precoUnitario, observacao);
		pedido.enviarPedido();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Pedido: " + produto.getNome() 
		+ ", Preço pedido: " + (produto.getPreco().multiply(BigDecimal.valueOf(quantidade))) 
		+ ", Taxa de entrega: " + restaurante.getTaxaFrete()
		+ ", Preço total: " 
		+ ((produto.getPreco().multiply(BigDecimal.valueOf(quantidade))).add(restaurante.getTaxaFrete())  ));
		System.out.println(enderecoEntrega);
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	@Override
	public void cadastrar(String nome, BigDecimal taxaFrete, boolean ativo, boolean aberto, Date dataCadastro,Date dataAtualizacao, Cozinha cozinha,Endereco endereco) {
		System.out.println("Este usuário não tem permissão para cadastrar um Restaurante novo.");
		
	}

	@Override
	public String toString() {
		return " Cliente cadastrado: " + getNome() 
				+ ", \n e-mail: " + getEmail();
	}
	
	
	

}
