
package Produto;
import java.math.BigDecimal;


public class Produto {
   
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private boolean ativo;
    private FotoProduto fotoProduto;
    private Integer quantidade;

    public Produto() {
    }
    
    public Produto(String nome, Integer quantidade, String descricao, 
    			   BigDecimal preco, boolean ativo, FotoProduto fotoProduto) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.preco = preco;
        this.ativo = ativo;
        this.fotoProduto = fotoProduto;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getQuantidade() {
    	return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
    	this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public String estaAtivo(boolean ativo) {
    	if(ativo) {
    		return "ativo";
    	}
    	else {
    		return "desativo";
    	}
    }

	@Override
	public String toString() {
		return nome 
				+ ",\n descricao: " + descricao 
				+ ",\n preco: R$" + preco 
				+ ",\n o produto está ativo? " + estaAtivo(ativo)
				+ "\n"
				+ fotoProduto;
	}    

    
}

