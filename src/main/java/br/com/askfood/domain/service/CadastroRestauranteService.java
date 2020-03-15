package br.com.askfood.domain.service;

import br.com.askfood.domain.exception.RestauranteNaoEncontradoException;
import br.com.askfood.domain.model.Cozinha;
import br.com.askfood.domain.model.Restaurante;
import br.com.askfood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroRestauranteService {


    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;


    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);


        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public void ativar(Long restauranteId) {
        Restaurante restauranteAtual = buscarOuFalhar(restauranteId);

        restauranteAtual.ativar();
    }

    @Transactional
    public void inativar(Long restauranteId) {
        Restaurante restauranteAtual = buscarOuFalhar(restauranteId);

        restauranteAtual.inativar();
    }


    public Restaurante buscarOuFalhar(Long cidadeId) {
        return restauranteRepository.findById(cidadeId)
                .orElseThrow(() -> new RestauranteNaoEncontradoException(cidadeId));
    }


}
