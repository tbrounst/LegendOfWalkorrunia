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
    private final GameEngine game;
    private ArrayList<IListener> listenersToRemove = new ArrayList();
    private final ArrayList<BuildingListener> buildingListeners = new ArrayList();
    private final ArrayList<BattleListener> battleListeners = new ArrayList();
    
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
    
    public synchronized void addBattleListener(BattleListener l) {
        battleListeners.add(l);
    }
    
    public synchronized void removeBattleListener(BattleListener l) {
        battleListeners.remove(l);
    }
    
    public synchronized void fireBattleEvent(BattleEvent battleEvent) {
        listenersToRemove = new ArrayList();
        for (BattleListener bl : battleListeners) {
            bl.battleFinished(battleEvent);
            if (bl.toRemove()) addListenerForRemoval(bl);
        }
        battleListeners.removeAll(listenersToRemove);
    }
    
    private synchronized void addListenerForRemoval(IListener listener) {
        listenersToRemove.add(listener);
    }
    
}
