/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.lab.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import una.design.lab.model.Persona;

/**
 *
 * @author Estudiante
 */
public class PersonaService {

    public PersonaService() {
    }
    
    public Object[][] loadStudentsObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Persona[] personas = loadStudentsFromFile();
        Object[][] data = null;

        if (personas != null && personas.length > 0) {
            data = new Object[personas.length][4]; // filas y columnas
            int i = 0;
            for (Persona persona : personas) {
                data[i][0] = checkIfNull(persona.getName().getFirst());
                data[i][1] = checkIfNull(persona.getEmail());
                data[i][2] = checkIfNull(persona.getTags());
                data[i][3] = checkIfNull(persona.getFriends());
                i++;
            }
        }

        return data;
    }
    
    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }
}
