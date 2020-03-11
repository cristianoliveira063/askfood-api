package br.com.askfood.api.assembler;

import br.com.askfood.api.model.EstadoModel;
import br.com.askfood.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoModelAssembler {

    private final ModelMapper modelMapper;

    public EstadoModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EstadoModel toModel(Estado estado) {
        return modelMapper.map(estado, EstadoModel.class);
    }

    public List<EstadoModel> toCollectionModel(List<Estado> estados) {
        return estados.stream()
                .map(estado -> toModel(estado))
                .collect(Collectors.toList());
    }

}