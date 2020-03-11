package br.com.askfood.api.assembler;

import br.com.askfood.api.model.input.CidadeInput;
import br.com.askfood.domain.model.Cidade;
import br.com.askfood.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeInput cidadeInput) {
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        cidade.setEstado(new Estado());

        modelMapper.map(cidadeInput, cidade);
    }

}
