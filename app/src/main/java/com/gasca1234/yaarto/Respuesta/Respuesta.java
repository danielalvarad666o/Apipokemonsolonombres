package com.gasca1234.yaarto.Respuesta;

import com.gasca1234.yaarto.Pokeomn.pokemonNombre;

import java.util.List;

public class Respuesta {
    private String count;
    private String next;
    private String previous;
    private List<pokemonNombre> results;


    public Respuesta(String count, String next, String previous, List<pokemonNombre> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public List<pokemonNombre> getResults() {
        return results;
    }

    public void setResults(List<pokemonNombre> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
