package br.unipe.series.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Television {

    private List<TelevisionData> data;

    public Television() {
    }

    public List<TelevisionData> getData() {
        return data;
    }

    public void setData(List<TelevisionData> data) {
        this.data = data;
    }
}
