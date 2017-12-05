package br.unipe.series.repository;

import br.unipe.series.entity.Serie;
import br.unipe.series.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SerieRepository extends CrudRepository<Serie, Long> {

}
