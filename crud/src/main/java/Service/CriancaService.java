package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.CriancaModel;
import Repository.CriancaRepository;

                        @Service //       Define a classe como um serviço gerenciado pelo Spring
public class CriancaService {

	                   @Autowired // Injeta automaticamente uma instância do repositório BolaRepository
    private CriancaRepository repo; 

                      
    public List<CriancaModel> listarTodos() {               // Método que retorna uma lista de todas as bolas
        return repo.findAll();                // Chama o método do repositório para retornar todas as bolas do banco
    }

   
    public CriancaModel salvar(CriancaModel crianca) { // Método que recebe uma instância de CriancaModel e a salva
        return repo.save(crianca); // Chama o método do repositório para salvar a criança no banco de dados
    }

    // Método para buscar uma bola pelo ID
    public CriancaModel buscarPorId(Long id) { // Método que recebe um ID e retorna a criança correspondente
        return repo.findById(id).orElse(null); // Chama o método do repositório para buscar a criança pelo ID, retorna null se não encontrar
    }

    // Método para deletar uma bola pelo ID
    public void deletar(Long id) { // Método que recebe um ID e deleta a bola correspondente
        repo.deleteById(id); // Chama o método do repositório para deletar a bola do banco de dados
    }
}

	
	
	

