package br.com.loja.controller;


import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import br.com.loja.repository.CategoriaRepository;
import br.com.loja.repository.ProdutoRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	private ProdutoRepository produtoRepository;
	private CategoriaRepository categoriaRepository;

	public ProdutoController(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
	}
	 // Model sempre sera usado para enviar dados do backend para o frontend
	// findall encontra todos os produtos no banco de dados e envia para o frontend equivale ao get e o select * from produtos
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("produtos", produtoRepository.findAll()
		);
		// end point ou url que sera chamado no frontend para acessar a lista de produtos
		return "produtos/lista";
	}
	@GetMapping("/novo")
	public String abrirFormulario(Model model){
		model.addAttribute("produto", new Produto());
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "produtos/formulario";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}

}

//import br.com.loja.dao.ProdutoDAO;
//import br.com.loja.model.Produto;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.math.BigDecimal;
//import java.util.List;

//	private final ProdutoDAO produtoDao;
//
//	public ProdutoController(ProdutoDAO produtoDao) {
//		this.produtoDao = produtoDao;
//	}
//
//	// 1. CREATE (Cadastrar)
//	@PostMapping
//	public ResponseEntity<String> cadastrar(@RequestBody Produto produto) {
//		// Validação do Nome (Regra do Professor)
//		if (produto.getNome() == null || produto.getNome().isBlank() || produto.getNome().trim().length() > 100) {
//			return ResponseEntity.badRequest().body("nome com até 100 caracteres. ");
//		}
//
//		BigDecimal preco = produto.getPreco();
//		// Validação do Preço (Regra do Professor)
//		if (preco == null || preco.signum() <= 0 || preco.compareTo(new BigDecimal("99999999.99")) > 0 || preco.stripTrailingZeros().scale() > 2) {
//			return ResponseEntity.badRequest().body("informe o preço positivo com duas casas decimais");
//		}
//
//		produto.setNome(produto.getNome().trim());
//		produto.setPreco(preco);
//
//		// Executa a inserção no banco
//		produtoDao.inserir(produto);
//		return ResponseEntity.ok().body("Produto cadastrado com sucesso");
//	}
//
//	// 2. READ (Listar Todos)
//	@GetMapping
//	public ResponseEntity<List<Produto>> listarTodos() {
//		List<Produto> produtos = produtoDao.listarTodos();
//
//		// Se não tiver nada no banco, envia o status 204 (Sem conteúdo)
//		if (produtos.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//
//		// Se tiver, envia a lista com status 200 OK (O Spring converte a lista para JSON automaticamente)
//		return ResponseEntity.ok().body(produtos);
//	}
//
//
//	// 2.5 READ (Buscar por ID)
//	@GetMapping("/{id}")
//	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
//		try {
//			Produto produto = (Produto) produtoDao.buscarPorId(id);
//			return ResponseEntity.ok().body(produto);
//		} catch (Exception e) {
//			return ResponseEntity.status(404).body("Produto não encontrado.");
//		}
//	}
//
//	// 3. UPDATE (Atualizar)
//	@PutMapping("/{id}")
//	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
//		// Repete as validações do professor para garantir a segurança na alteração
//		if (produto.getNome() == null || produto.getNome().isBlank() || produto.getNome().trim().length() > 100) {
//			return ResponseEntity.badRequest().body("nome com até 100 caracteres. ");
//		}
//
//		BigDecimal preco = produto.getPreco();
//		if (preco == null || preco.signum() <= 0 || preco.compareTo(new BigDecimal("99999999.99")) > 0 || preco.stripTrailingZeros().scale() > 2) {
//			return ResponseEntity.badRequest().body("informe o preço positivo com duas casas decimais");
//		}
//
//		produto.setId(id);
//		produto.setNome(produto.getNome().trim());
//		produto.setPreco(preco);
//
//		produtoDao.atualizar(produto);
//		return ResponseEntity.ok().body("Produto atualizado com sucesso");
//	}
//
//	// 4. DELETE (Deletar)
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deletar(@PathVariable Long id) {
//		try {
//			produtoDao.deletar(id);
//			return ResponseEntity.ok().body("Produto deletado com sucesso");
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body("Erro ao deletar o produto.");
//		}
//	}
