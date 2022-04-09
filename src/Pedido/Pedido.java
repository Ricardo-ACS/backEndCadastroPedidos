package Pedido;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import Produto.Produto;
import Restaurante.Restaurante;
import Util.Endereco;

public class Pedido {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa HH:mm:ss");
	
	private String codigo;
	private BigDecimal subTotal;
	private BigDecimal valorTotal;
	private Date dataCriacao;
	private Date dataConfirmacao;
	private Date dataEntrega;
		
	
	private StatusPedido status;
	
	private List<ItemPedido> itens;
	
	private Restaurante restaurante;
	
	private Endereco enderecoEntrega;
	
	private Produto produto;
	
	
	public Pedido() {
	}

	public Pedido(Date dataCriacao, Endereco enderecoEntrega) {
		this.codigo = String.valueOf(new Random().nextInt(9999));
		this.dataCriacao = dataCriacao;
		this.enderecoEntrega = enderecoEntrega;
		
		this.status = StatusPedido.CRIADO;
		System.out.println("Status do pedido: " + status);
	}

	public void fazerListaPedidos(Produto produto, Integer quantidade, BigDecimal precoUnitario, 
								  String observacao) {
		
		this.itens = new ArrayList<ItemPedido>();
		itens.add(new ItemPedido(produto, quantidade, precoUnitario, observacao));
		this.status = StatusPedido.CONFIRMADO;
		this.dataConfirmacao = Date.from(Instant.now());
		System.out.println("Status do pedido: " + status);
	}
	
	public void enviarPedido() throws InterruptedException {
		int quantidadePedido = 0;
		for (ItemPedido itemPedido : itens) {
			quantidadePedido = itemPedido.getQuantidade();
			itemPedido.getProduto().setQuantidade(itemPedido.getProduto().getQuantidade() - quantidadePedido);
		}
		
		System.out.println("Pedido em transporte, aguarde...");
		Thread.sleep(5000);
		System.out.println("Produto entregue");
		this.status = StatusPedido.CONFIRMADO;
		this.dataEntrega = Date.from(Instant.now());
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal() {
		double subTotal = 0.0;
		for (ItemPedido itemPedido : itens) {
			subTotal += itemPedido.getPrecoTotal().doubleValue();
		}
		this.subTotal = BigDecimal.valueOf(subTotal);
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal() {
		this.valorTotal = BigDecimal.valueOf(this.getSubTotal().doubleValue() 
											+ restaurante.getTaxaFrete().doubleValue()); 
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(Date dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatusPedido() {
		return status;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	@Override
	public String toString() {
		return "Pedido \ncodigo: " + codigo 
				+ ", subTotal: " + subTotal 
				+ ", valorTotal: " + valorTotal 
				+ ", data da criação do pedido: " + sdf.format(dataCriacao) 
				+ ", data da confirmação: " + dataConfirmacao 
				+ ", data da entrega: " + dataEntrega 
				+ ", status do pedido: " + status 
				+ ", itens pedidos: " + itens 
				+ ", no restaurante: " + restaurante 
				+ ", para ser entregue no endereco: " + enderecoEntrega;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itens, produto, restaurante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(itens, other.itens) && Objects.equals(produto, other.produto)
				&& Objects.equals(restaurante, other.restaurante);
	}

	
	
	
	
	
	
}
    
