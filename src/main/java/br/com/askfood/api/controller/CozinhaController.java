package br.com.askfood.api.controller;

import br.com.askfood.domain.model.Cozinha;
import br.com.askfood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private  CozinhaRepository cozinhaRepository;


    @GetMapping
    public List<Cozinha> listar(){
        return  cozinhaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cozinha buscar(@PathVariable  Long id){
        return  cozinhaRepository.findById(id).get();
    }


}


