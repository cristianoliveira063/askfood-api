package br.com.askfood.domain.service;

import br.com.askfood.domain.exception.EntidadeEmUsoException;
import br.com.askfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.askfood.domain.model.Cidade;
import br.com.askfood.domain.model.Estado;
import br.com.askfood.domain.repository.CidadeRepository;
import br.com.askfood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.
                        format("Não existe cadastro de estado com código %d", estadoId)));

        cidade.setEstado(estado);
        return cidadeRepository.save(cidade);
    }


    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }


    }

}
