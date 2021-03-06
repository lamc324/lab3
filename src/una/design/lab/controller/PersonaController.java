/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.lab.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.design.lab.Constants;
import una.design.lab.service.PersonaService;

/**
 *
 * @author Estudiante
 */
public class PersonaController implements ActionListener , KeyListener{
    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private PersonaService personaService;
    private Object[][] personas;

    public PersonaController(JTextField searchTermTextField,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException {
        
        super();
        personaService = new PersonaService();
        personas = personaService.cargarPersonasObjWrapper();
        
        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;
        
        tableModel.setDataVector(personas, Constants.TABLE_HEADER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchTermTextField.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && personas != null && personas.length >= 1) {
            Object[][] newData = new Object[personas.length][];
            int idx = 0;
            for (Object[] obj : personas) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(personas, Constants.TABLE_HEADER);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       displayInfo(e,"key pressed: ");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void displayInfo(KeyEvent e, String keyStatus){
        
        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            String s = Character.toString(e.getKeyChar());
            updateTableSearchTerms(s);
            
        } else {
            /*int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";*/
        }
    }
    
    
}
