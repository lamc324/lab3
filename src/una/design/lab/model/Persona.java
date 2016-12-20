/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.lab.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *
 * @author Estudiante
 */
public class Persona {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("tags")
    String[] tags;
    @JsonProperty("friends")
    private Friends[] friends;

    public Persona() {
    }

    public Persona(Name name, String email, String[] tags, Friends[] friends) {
        this.name = name;
        this.email = email;
        this.tags = tags;
        this.friends = friends;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Friends[] getFriends() {
        return friends;
    }

    public void setFriends(Friends[] friends) {
        this.friends = friends;
    }
    
    public String getFriendsNames(){
        String friendsNames= "";
        for(Friends friend : friends){
            friendsNames += friend.getName() + ", ";
        }
        return friendsNames;
    }
    
    public String getEachTag(){
        
        String singleTag = "";
        for (String tag : tags){
             singleTag = Arrays.toString(this.tags);
        }
        return singleTag;
    }

    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", email=" + email + ", tags=" + tags + ", friends=" + friends + '}';
    }

}
