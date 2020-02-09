package br.com.askfood.domain.repository;

import br.com.askfood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
