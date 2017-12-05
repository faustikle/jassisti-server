package br.unipe.series.controller;

import br.unipe.series.dto.DadosUsuarioFacebook;
import br.unipe.series.dto.serie.EpisodioDto;
import br.unipe.series.dto.serie.Serie;
import br.unipe.series.dto.serie.TemporadaDto;
import br.unipe.series.entity.Episodio;
import br.unipe.series.entity.Temporada;
import br.unipe.series.repository.EpisodioRepository;
import br.unipe.series.repository.SerieRepository;
import br.unipe.series.repository.TemporadaRepository;
import br.unipe.series.service.FacebookService;
import br.unipe.series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SerieController {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SerieService serieService;

    @RequestMapping(value = "/serie", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Serie> addSerie(@RequestHeader("Authorization") String accessToken, @RequestParam("nome") String nome){
        Serie serie = serieService.searchSerie(nome);

        if (serie == null) {
            return new ResponseEntity<Serie>(HttpStatus.NOT_FOUND);
        }

        TemporadaDto[] temporadas = serieService.getTemporadas(serie);

        br.unipe.series.entity.Serie serieNova = new br.unipe.series.entity.Serie(
                serie.getShow().getId(),
                serie.getShow().getName(),
                serie.getShow().getSummary(),
                serie.getShow().getImage().getOriginal()
        );

        for (TemporadaDto temporada : temporadas) {
            Temporada temporadaEntidade = new Temporada(temporada.getId(), temporada.getNumber());
            EpisodioDto[] episodioDtos = serieService.getEpisodios(temporada);

            for(EpisodioDto episodioDto : episodioDtos) {
                Episodio episodio = new Episodio(
                        episodioDto.getName(),
                        episodioDto.getSummary(),
                        episodioDto.getImage().getOriginal()
                );

                temporadaEntidade.addEpisodio(episodio);
            }
            serieNova.addTemporada(temporadaEntidade);
        }

        serieRepository.save(serieNova);

        return new ResponseEntity<Serie>(serie, HttpStatus.OK);
    }
}
