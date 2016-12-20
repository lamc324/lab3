/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.lab.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.design.lab.Constants;
import una.design.lab.service.PersonaService;

/**
 *
 * @author Estudiante
 */
public class PersonaController {
    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private PersonaService personaService;
    private Object[][] personas;

    public PersonaController(DefaultTableModel tableModel, PersonaService personaService, Object[][] students) {
        
        super();
        personaService = new PersonaService();
        personas = personaService.cargarPersonasObjWrapper();
        
        this.tableModel = tableModel;
        this.personaService = personaService;
        
        tableModel.setDataVector(students, Constants.TABLE_HEADER);
    }
    
    /*public StudentController(JTextField searchTermTextField,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException {
        super();
        studentService = new StudentService();
        students = studentService.loadStudentsObjWrapper();

        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;

        // Load the table with the list of students
        tableModel.setDataVector(students, Constants.TABLE_HEADER);
    }*/
}
