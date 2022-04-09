
package Produto;


public class FotoProduto {
    private String nome;
    private String descricao;
    private String contentType;
    private long tamanho;

    public FotoProduto(String nome, String descricao, String contentType, long tamanho) {
        this.nome = nome;
        this.descricao = descricao;
        this.contentType = contentType;
        this.tamanho = tamanho;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

	@Override
	public String toString() {
		return " Nome da foto: " + nome 
				+ ",\n descricao da foto: " + descricao 
				+ ",\n contentType da foto: " + contentType 
				+ ",\n tamanho da foto: " + tamanho + "Mb";
	} 
    
    
}



