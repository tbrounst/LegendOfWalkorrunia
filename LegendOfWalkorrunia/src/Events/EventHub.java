/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import GameEngine.GameEngine;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class EventHub {
    final GameEngine game;
    final ArrayList<BuildingListener> buildingListeners = new ArrayList();
    
    public EventHub(GameEngine game) {
        this.game = game;
    }
    
    public synchronized void addBuildingListener(BuildingListener l) {
        buildingListeners.add(l);
    }
    
    public synchronized void removeBuildingListener(BuildingListener l) {
        buildingListeners.remove(l);
    }
    
    public synchronized void fireBuildingEvent(BuildingEvent buildingEvent) {
        for (BuildingListener bl : buildingListeners) {
            bl.buildingConstructed(buildingEvent);
        }
    }
    
}
