package br.com.sergio.produtos.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergio.produtos.models.Produto;
import br.com.sergio.produtos.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		
		return produtoRepository.findAll();
		
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto especifico de acordo com o id")
	public Optional<Produto> listaProduto(@PathVariable(value="id") long id){
		
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Cadastra um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value="Deleta um produto especifico de acordo com o id")
	public void deletaProduto(@PathVariable(value="id") long id) {
		
		produtoRepository.deleteById(id);
		
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto especifico")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
}
