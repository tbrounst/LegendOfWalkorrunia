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
public class TrainingGrounds implements IBuilding{
    GameEngine game;
    final Town town;
    final int cost = 500;
    final String name = "Training Grounds";
    private Boolean isBuilt = false;
    
    public TrainingGrounds(GameEngine game, Town town) {
        this.game = game;
        this.town = town;
    }

    @Override
    public String description() {
        return "Location where you can train in the art of a sword.  Unlocks " +
                "the knight profession";
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public boolean canBeBuilt() {
        return game.getBuildingPrereqs().trainingGroundsPrereqsMet();
    }
    
    public boolean isBuilt() {
        return isBuilt;
    }
    
    public void build() {
        isBuilt = true;
    }
    
}
