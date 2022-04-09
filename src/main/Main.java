package main;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import Cozinha.Cozinha;
import Estado.Estado;
import Produto.Produto;
import Util.Endereco;
import cidade.Cidade;
import usuario.Cliente;
import usuario.Funcionario;
import usuario.Usuario;

public class Main {

	public static void main(String[] args) throws ParseException, InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("-----------------------------------------------------------------------------------------");
		Usuario funcionario = new Funcionario("Antonio Nunes", 
												"nunes.antonio@gmail.com", "admin");
		System.out.println(funcionario);
		System.out.println("-----------------------------------------------------------------------------------------");
		Usuario cliente = new Cliente("Maria Cristina", "maria.cris@hotmail.com", "123654");
		System.out.println(cliente);
		System.out.println("-----------------------------------------------------------------------------------------");
		funcionario.cadastrar("Bodódromo", BigDecimal.valueOf(15.00), true, true,
								sdf.parse("12/03/2017"), Date.from(Instant.now()), 
								new Cozinha("Cozinha nordestina"), 
								new Endereco("56330-095", "Av. São Francisco", "7", "Areia Branca", 
								new Cidade("Petrolina", new Estado("Pernambuco"))));
		System.out.println(funcionario.getRestaurante());
		System.out.println("-----------------------------------------------------------------------------------------");
		funcionario.getRestaurante().cadastrarFormaPagamento("Cartão de crédito");
		System.out.println("-----------------------------------------------------------------------------------------");
		funcionario.getRestaurante().cadastrarProdutos("Bode assado", 50, 
				"Espeto de bodé que acompanha guarnição completa e serve 4 pessoas", 
				70.00, "Foto da carne", "A carne assada perfeitamente no espeto", 
				"Foto do tipo JPG", "5");
		funcionario.getRestaurante().listarProdutos();
		System.out.println("-----------------------------------------------------------------------------------------");
		funcionario.getRestaurante().cadastrarProdutos("Picanha", 30, 
				"Espeto de Picanha argentina que acompanha guarnição completa e serve 3 pessoas", 
				120.00, "Foto da picanha", "A carne assada perfeitamente com a gordura pingando", 
				"Foto do tipo JPG", "8");
		funcionario.getRestaurante().listarProdutos();
		System.out.println("-----------------------------------------------------------------------------------------");
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Estoque de "+ funcionario.getRestaurante().getProduto("Bode assado").getNome() + " " + funcionario.getRestaurante().getProduto("Bode assado").getQuantidade());
		System.out.println("-----------------------------------------------------------------------------------------");
		funcionario.pedido(funcionario.getRestaurante(), funcionario.getRestaurante().getProduto("Bode assado"),
				Date.from(Instant.now()), 
				new Endereco("56380-095", "Av. das nações", "23", "Gercino Coelho", 
				new Cidade("Petrolina", new Estado("Pernambuco"))), 
				3, BigDecimal.valueOf(15.00), 
				"sem queijo");
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Estoque de "+ funcionario.getRestaurante().getProduto("Bode assado").getNome() + " " +funcionario.getRestaurante().getProduto("Bode assado").getQuantidade());
		System.out.println("-----------------------------------------------------------------------------------------");
		cliente.pedido(funcionario.getRestaurante(), funcionario.getRestaurante().getProduto("Bode assado"), 
				Date.from(Instant.now()), 
				new Endereco("56330-095", "Rua maniçoba", "117", "Pedrinhas", 
				new Cidade("Petrolina", new Estado("Pernambuco"))), 
				3, BigDecimal.valueOf(15.00), 
				"sem queijo");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Estoque de "+ funcionario.getRestaurante().getProduto("Bode assado").getNome() + " " + funcionario.getRestaurante().getProduto("Bode assado").getQuantidade());
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Estoque de "+ funcionario.getRestaurante().getProduto("Picanha").getNome() + " " + funcionario.getRestaurante().getProduto("Picanha").getQuantidade());
		System.out.println("-----------------------------------------------------------------------------------------");
		cliente.pedido(funcionario.getRestaurante(), funcionario.getRestaurante().getProduto("Picanha"), 
				Date.from(Instant.now()), 
				new Endereco("56495-195", "Av. Larga", "754", "Pedra do lorde", 
				new Cidade("Juazeiro", new Estado("Bahia"))), 
				3, BigDecimal.valueOf(15.00), 
				"Retirar a cebola");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Estoque de "+ funcionario.getRestaurante().getProduto("Picanha").getNome() + " " + funcionario.getRestaurante().getProduto("Picanha").getQuantidade());
	
	}

	
	
}
