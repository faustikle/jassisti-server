package br.unipe.series.dto.serie;

import java.util.List;

public class SearchSerie {

    private List<Serie> series;

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public SearchSerie() {

    }
}
