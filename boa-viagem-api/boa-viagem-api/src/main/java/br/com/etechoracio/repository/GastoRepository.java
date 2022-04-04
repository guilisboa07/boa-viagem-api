package br.com.etechoracio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.etechoracio.boa_viagem.entity.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

}
