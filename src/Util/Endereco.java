package Util;

import cidade.Cidade;

public class Endereco {
    
        private String cep; 
        private String logradouro; 
        private String numero; 
        private String bairro;
        
        private Cidade cidade;
        
        public Endereco () {  
        }
        
        public Endereco(String cep, String logradouro, String numero, 
        				String bairro, Cidade cidade) {
        	this.cep = cep;
			this.logradouro = logradouro;
			this.numero = numero;
			this.bairro = bairro;
			this.cidade = cidade;
		}

        
        public String getCep() {
            return cep; 
        }
        
        public void setCep(String cep) {
            this.cep = cep; 
        }
        
        public String getLograouro(){
            return logradouro; 
        }
        
        public void setLogradouro(String logradouro){
            this.logradouro = logradouro; 
        }
        
        public String getNuemro() {
            return numero; 
        }
        
        public void setNumero(String numero) {
            this.numero = numero; 
        }
        
        public String getBairro () {
            return bairro; 
        }
        
        public void setBairro (String bairro) {
            this.bairro = bairro ; 
        }

		public Cidade getCidade() {
			return cidade;
		}

		@Override
		public String toString() {
			return "Endereco: \n cep: " + cep + ", \n logradouro: " + logradouro 
					+ ", numero: " + numero + ", bairro: " + bairro
					+ ", cidade: " + cidade;
		}
		       
		
        
 
}
