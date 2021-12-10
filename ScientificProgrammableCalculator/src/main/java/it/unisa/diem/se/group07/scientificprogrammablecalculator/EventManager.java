/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EventManager manages the events and the listeners.
 * 
 * @author clari
 */
public class EventManager {
    private final Map<String, List<EventListener>> listeners;

    /**
     * Constructs the map of listeners for the specified operation.
     * 
     * @param operations are all the operations for this event manager.
     */
    public EventManager(String... operations) {
        this.listeners = new HashMap<>();
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * This method adds a listener in the map of specified operation.
     * 
     * @param eventType is the name of event.
     * @param listener is the listener interesting of the changes.
     */
    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * This method deletes a listener in the map of specified operation.
     * 
     * @param eventType is the name of event.
     * @param listener is the listener no more interesting of the changes.
     */
    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * This method notifies the changing to the listeners of the specified event.  
     * 
     * @param eventType is the name of event.
     * @param o is the change to notify.
     */
    public void notify(String eventType, Object o) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, o);
        }
    }
}