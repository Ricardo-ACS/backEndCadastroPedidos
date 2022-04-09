package usuario;
import java.math.BigDecimal;
import java.util.Date;

import Cozinha.Cozinha;
import Produto.Produto;
import Restaurante.Restaurante;
import Util.Endereco; 



public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Date dataCadastro = new Date();
    private Restaurante restaurante;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
  
    
    public abstract void pedido(Restaurante restaurante, Produto produto, Date dataCriacao, Endereco enderecoEntrega, 
    							Integer quantidade, BigDecimal precoUnitario, 
    							String observacao) throws InterruptedException;
    
    public abstract void cadastrar(String nome, BigDecimal taxaFrete, boolean ativo, 
									boolean aberto, Date dataCadastro, 
									Date dataAtualizacao, Cozinha cozinha,
									Endereco endereco);
    
    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Restaurante getRestaurante() {
    	return restaurante;
    }

	



}
