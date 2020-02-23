package br.com.askfood.domain.service;

import br.com.askfood.domain.exception.RestauranteNaoEncontradoException;
import br.com.askfood.domain.model.Cozinha;
import br.com.askfood.domain.model.Restaurante;
import br.com.askfood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {


    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;


    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

//		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
//			.orElseThrow(() -> new EntidadeNaoEncontradaException(
//					String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarOuFalhar(Long cidadeId) {
        return restauranteRepository.findById(cidadeId)
                .orElseThrow(() -> new RestauranteNaoEncontradoException(cidadeId));
    }


}
