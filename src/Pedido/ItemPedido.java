package Pedido;

import java.math.BigDecimal;

import Produto.Produto;

public class ItemPedido {

	private Integer quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal precoTotal;
	private String observacao;
	
	private Produto produto;
	
	public ItemPedido() {
	}
	
	
	
	public ItemPedido(Produto produto, Integer quantidade, BigDecimal precoUnitario, String observacao) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.precoTotal = getPrecoTotal();
		this.observacao = observacao;
	}


	

	public Produto getProduto() {
		return produto;
	}



	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario() {
		this.precoUnitario = precoProduto(produto);
	}
	public BigDecimal getPrecoTotal() {
		setPrecoTotal();
		return this.precoTotal;
	}
	public void setPrecoTotal() {
		this.precoTotal = BigDecimal.valueOf(quantidade * getPrecoUnitario().doubleValue()) ;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public BigDecimal precoProduto(Produto produto) {
		return BigDecimal.valueOf(produto.getPreco().doubleValue());
	}



	@Override
	public String toString() {
		
		return "Itens Pedidos: \n quantidade = " + quantidade + ",\n preco unitário = " + precoUnitario + ",\n preco total = "
				+ precoTotal + ",\n observação = " + observacao + ",\n produto = " + produto + "]";
	}
	
	
	
}
