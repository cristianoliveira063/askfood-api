package br.com.askfood.domain.repository;

import br.com.askfood.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository  extends JpaRepository<Estado,Long> {
}
