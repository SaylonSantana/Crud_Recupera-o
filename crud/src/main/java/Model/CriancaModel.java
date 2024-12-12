package Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Define a classe como uma entidade JPA (persistente no banco de dados)
@Table(name = "crianca") // Define o nome da tabela no banco de dados como "crianca"
public class CriancaModel {

	  @Id // Define o campo id como a chave primária da tabela
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id será gerado automaticamente pelo banco de dados
	    private Long id; // Campo que representa o id único da bola

	    private String genero; // Campo para armazenar a cor da bola
	   
	    private Double tamanho; // Campo para armazenar o tamanho da bola
	  
	    private Double peso; // Campo para armazenar o peso da bola
	    

	    // Construtor padrão (sem parâmetros)
	    public CriancaModel() {
	    }

	    // Construtor com parâmetros para inicializar todos os campos da classe
	    public CriancaModel(Long id, String genero,  Double tamanho, Double peso) {
	        this.id = id; // Inicializa o id
	        this.genero = genero; // Inicializa a cor
	       
	        this.tamanho = tamanho; // Inicializa o tamanho
	    
	        this.peso = peso; // Inicializa o peso
	        
	    }

	    // Getters e Setters para acessar e modificar os campos privados da classe
	    public Long getId() { // Getter para o id
	        return id;
	    }

	    public void setId(Long id) { // Setter para o id
	        this.id = id;
	    }

	    public String getCor() { // Getter para a cor
	        return genero;
	    }

	    public void setCor(String cor) { // Setter para a cor
	        this.genero = cor;
	    }

	    
	    public Double getTamanho() { // Getter para o tamanho
	        return tamanho;
	    }

	    public void setTamanho(Double tamanho) { // Setter para o tamanho
	        this.tamanho = tamanho;
	    }


	    public Double getPeso() { // Getter para o peso
	        return peso;
	    }

	    public void setPeso(Double peso) { // Setter para o peso
	        this.peso = peso;
	    }



	      
	    }

