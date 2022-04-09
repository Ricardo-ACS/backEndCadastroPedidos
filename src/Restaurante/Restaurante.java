
package Restaurante;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import Cozinha.Cozinha;
import Produto.FotoProduto;
import Produto.Produto;
import Util.Endereco;
import formaPagamento.FormaPagamento; 
        

public class Restaurante implements FormaPagamento{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private BigDecimal taxaFrete;
    
    private boolean ativo;
    private boolean aberto;
    
    private Date dataCadastro;
    private Date dataAtualizacao;
    
    private Cozinha cozinha;
    
    private String formaPagamento;
    
    private List<Produto> estoque = new ArrayList<>();
    
    private Endereco endereco;
    
    private int i = 0;
    public Restaurante() {
	}
    
    public Restaurante(String nome, BigDecimal taxaFrete, boolean ativo, 
    				   boolean aberto, Date dataCadastro, 
    				   Date dataAtualizacao, Cozinha cozinha,
    				   Endereco endereco) {
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.cozinha = cozinha;
        this.endereco = endereco;
    }
   
    
    
    public void cadastrarProdutos(String nome, Integer quantidade,
    							  String descricao, double preco, String nomeFoto, 
    							  String descricaoFoto, String TipoConteudo, 
    							  String tamanho) {
    	
    	
    	boolean statusAtivo = true;
    	
    	Produto estoqueProduto = new Produto(nome, quantidade, descricao, 
    										BigDecimal.valueOf(preco), statusAtivo, 
    										new FotoProduto(nomeFoto, descricaoFoto, 
    										TipoConteudo, Long.valueOf(tamanho)));
    	
    	this.estoque.add(estoqueProduto);
    	}
    	
    	
    
    public void cadastrarFormaPagamento(String descricao) {
		
		this.formaPagamento = descricao;
		
		
	}
		
    
    public void listarProdutos() {
    	for (Produto produto : estoque) {
			System.out.println(produto);
		}
    }
    
    public Produto getProduto(String nome) {
    	Produto retorno = new Produto();
    	for (Produto produto : estoque) {
			if (produto.getNome().contains(nome)) {
				retorno = produto;
			}
    	
    	}
    	return retorno;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

	@Override
	public String toString() {
		return "Restaurante: " + nome 
				+ ",\n taxa Frete: R$" + taxaFrete
				+ ",\n data de cadastro: " + sdf.format(dataCadastro) 
				+ ",\n dataAtualizacao: " + sdf.format(dataAtualizacao) 
				+ ",\n cozinha: " + cozinha
				+ ",\n formasPagamento: " + formaPagamento 
				+ ",\n" + endereco;
	}

	
    
    

}
