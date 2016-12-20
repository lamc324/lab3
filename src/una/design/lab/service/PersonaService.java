/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.lab.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import una.design.lab.Constants;
import una.design.lab.model.Persona;

/**
 *
 * @author Estudiante
 */
public class PersonaService {

    public PersonaService() {
    }
    
    public Object[][] cargarPersonasObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Persona[] personas = cargarPersonasDeArchivo();
        Object[][] data = null;

        if (personas != null && personas.length > 0) {
            data = new Object[personas.length][5]; // filas y columnas
            int i = 0;
            for (Persona persona : personas) {
                data[i][0] = checkIfNull(persona.getName().getFirst());
                data[i][1] = checkIfNull(persona.getName().getLast());
                data[i][2] = checkIfNull(persona.getEmail());
                data[i][3] = checkIfNull(persona.getTags());
                data[i][4] = checkIfNull(persona.getFriends());
                i++;
            }
        }

        return data;
    }
    
    private Persona[] cargarPersonasDeArchivo() throws JsonGenerationException,
            JsonMappingException, IOException {
        
        Persona[] personas = null;
        ObjectMapper mapper = new ObjectMapper();
        personas = mapper.readValue(new File(Constants.FILENAME), Persona[].class);

        return personas;
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
