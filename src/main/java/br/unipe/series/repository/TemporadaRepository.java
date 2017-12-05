package br.unipe.series.repository;

import br.unipe.series.entity.Serie;
import br.unipe.series.entity.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface TemporadaRepository extends CrudRepository<Temporada, Long> {

}
