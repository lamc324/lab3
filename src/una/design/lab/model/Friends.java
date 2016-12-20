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
public class Friends {
    
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

    public Friends() {
    }

    public Friends(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Friends{" + "id=" + id + ", name=" + name + '}';
    }
    
}
