/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * MemoryListener represents an ObservableList observer.
 * 
 * @author clari
 */
public class MemoryListener implements EventListener{
    public ObservableList<String> list; 

    /**
     * Constructs the ObservableList.
     */
    public MemoryListener() {
        this.list = FXCollections.observableArrayList();
    }
    
    /**
     * This method updates the ObservableList.  
     * 
     * @param eventType is the name of event.
     * @param array is the changing of the specified object.
     */
    @Override
    public void update(String eventType, Object array) {
        list.setAll((String[])array);
    }
    
}
