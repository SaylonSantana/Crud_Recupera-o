package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.CriancaDTO;
import Model.CriancaModel;
import Service.CriancaService;

@RestController                         // Define que a classe é um controlador REST
@RequestMapping("/crianca")             // Define a URL base para os endpoints como "/crianca"
public class CriancaController {

	 @Autowired                         // Injeta automaticamente a instância do serviço CriancaService
	    private CriancaService CriancaService; 

	    @GetMapping("/listar")                                      // Define um endpoint HTTP GET para listar todas as crianças
	    public ResponseEntity<List<CriancaModel>> listar() {
	        List<CriancaModel> criancas = CriancaService.listarTodos();               // Chama o serviço para listar todas as crianças
	        return ResponseEntity.ok(criancas);                                      // Retorna a lista de criancas com status HTTP 200 (OK)
	    }

	    @PostMapping("/criar") // Define um endpoint HTTP POST para criar uma nova bola
	    public ResponseEntity<CriancaModel> criar(@RequestBody CriancaModel crianca) {
	        CriancaModel novaCrianca = CriancaService.salvar(crianca); // Chama o serviço para salvar a bola
	        return new ResponseEntity<>(novaCrianca, HttpStatus.CREATED); // Retorna a criança criada com status HTTP 201 (Criado)
	    }

	    @GetMapping("/listar/{id}")     // Define um endpoint HTTP GET para buscar uma criança pelo ID
	    public ResponseEntity<CriancaModel> buscarPorId(@PathVariable Long id) {
	        CriancaModel crianca = CriancaService.buscarPorId(id);      // Chama o serviço para buscar a criança pelo ID
	        if (crianca != null) { // Se a bola for encontrada
	            return ResponseEntity.ok(crianca); // Retorna a criança com status HTTP 200 (OK)
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna status HTTP 404 (Não Encontrado)
	        }
	    }

	    @PutMapping("/atualizar/{id}") // Define um endpoint HTTP PUT para atualizar uma criança existente
	    public ResponseEntity<String> atualizarBola(@PathVariable Long id, @RequestBody CriancaDTO dto) {
	        CriancaModel crianca = CriancaService.buscarPorId(id);           // Chama o serviço para buscar a criança pelo ID
	        if (crianca != null) {                                           // Se a criança for encontrada
	            crianca.getClass() ;               // Atualiza a criança com os dados do DTO
	            CriancaService.salvar(crianca);                                 // Chama o serviço para salvar a criança atualizada
	            return ResponseEntity.ok("registro atualizado com sucesso");           // Retorna mensagem de sucesso com status HTTP 200 (OK)
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("criança não encontrada"); // Retorna erro se a criança não for encontrada
	        }
	    }

	    @DeleteMapping("/deletar/{id}")                                          // Define um endpoint HTTP DELETE para excluir uma criança pelo ID
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        CriancaModel crianca = CriancaService.buscarPorId(id);               // Chama o serviço para buscar a criança pelo ID
	        if (crianca != null) { // Se a criança for encontrada
	            CriancaService.deletar(id);                                       // Chama o serviço para deletar a criança
	            return ResponseEntity.noContent().build();                        // Retorna status HTTP 204 (Sem Conteúdo) após deletar
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();             // Retorna erro se criança não for encontrada
	        }
	    }
	}
