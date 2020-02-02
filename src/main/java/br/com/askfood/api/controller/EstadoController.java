package br.com.askfood.api.controller;

import br.com.askfood.domain.model.Estado;
import br.com.askfood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository  estadoRepository;

    @GetMapping
    public List<Estado> listar(){
        return  estadoRepository.findAll();
    }
}
