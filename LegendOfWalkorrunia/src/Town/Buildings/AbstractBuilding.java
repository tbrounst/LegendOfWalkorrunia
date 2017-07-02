/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Buildings;

import GameEngine.GameEngine;
import Town.Town;

/**
 *
 * @author Thomas
 */
public abstract class AbstractBuilding {
    protected final GameEngine game;
    protected final Town town;
    protected String buildingName;
    protected String buildingDescription;
    protected int buildingCost;
    protected Boolean isBuilt = false;
    
    public AbstractBuilding(GameEngine game, Town town){
        this.game = game;
        this.town = town;
    }
    
    public String getName() {
        return buildingName;
    }
    
    public String getDescription() {
        return buildingDescription;
    }
    
    public int getCost() {
        return buildingCost;
    }
    
    public boolean isBuilt() {
        return isBuilt;
    }
    
    public Integer build() {
        if (this.getCost() > game.getPlayer().getEps()) return 1;
        if (this.isBuilt()) return 2;
        if (!this.canBeBuilt()) return 3;
        game.getPlayer().modifyEps(-this.getCost());
        isBuilt = true;
        return 0;
    }
    
    abstract public boolean canBeBuilt();
}
