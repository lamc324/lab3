/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.lab.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Estudiante
 */
public class Name {

    @JsonProperty("first")
    private String first;
    @JsonProperty("last")
    private String last;

    public Name() {
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "Name{" + "first=" + first + ", last=" + last + '}';
    }

}
