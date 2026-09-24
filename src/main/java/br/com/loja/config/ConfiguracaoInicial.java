package br.com.loja.config;

import br.com.loja.model.Categoria;
import br.com.loja.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoInicial {

   @Bean
   CommandLineRunner carregarCategoria(
       CategoriaRepository categoriaRepository ){
    return args -> {
        if (categoriaRepository.count() == 0) {
            // Carregar categorias iniciais
            categoriaRepository.save(new Categoria("Informáica","Produtos de informática"));
            categoriaRepository.save(new Categoria("Escritório","Produtos para escritorio"));
        }
    };
   }
}
