package br.com.askfood.domain.repository;

import br.com.askfood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento,Long> {
}
