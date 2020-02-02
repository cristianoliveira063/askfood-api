package br.com.askfood.domain.repository;

import br.com.askfood.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository  extends JpaRepository<Cidade,Long> {
}
