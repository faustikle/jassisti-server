package br.unipe.series.service;

import br.unipe.series.dto.DadosUsuarioFacebook;
import br.unipe.series.dto.serie.EpisodioDto;
import br.unipe.series.dto.serie.SearchSerie;
import br.unipe.series.dto.serie.Serie;
import br.unipe.series.dto.serie.TemporadaDto;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SerieService {

    public Serie searchSerie(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Serie[] series = restTemplate.getForObject("http://api.tvmaze.com/search/shows?q=" + name, Serie[].class);

        if (series.length == 0) {
            return null;
        }

        return series[0];
    }

    public TemporadaDto[] getTemporadas(Serie serie) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "http://api.tvmaze.com/shows/"+ serie.getShow().getId() +"/seasons", TemporadaDto[].class
        );
    }

    public EpisodioDto[] getEpisodios(TemporadaDto temporadaDto) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
            "http://api.tvmaze.com/seasons/"+ temporadaDto.getId() +"/episodes", EpisodioDto[].class
        );
    }

}
