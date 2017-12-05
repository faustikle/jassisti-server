package br.unipe.series.repository;

import br.unipe.series.entity.Episodio;
import br.unipe.series.entity.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface EpisodioRepository extends CrudRepository<Episodio, Long> {

}
