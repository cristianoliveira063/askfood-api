package br.com.askfood.domain.service;

import br.com.askfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.askfood.domain.model.Cozinha;
import br.com.askfood.domain.model.Restaurante;
import br.com.askfood.domain.repository.CozinhaRepository;
import br.com.askfood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElse(null);

        if (cozinha == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
        }

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }





}
