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
public class TrainingGrounds extends AbstractBuilding{
    String thisBuildingName = "Training Grounds";
    String thisBuildingDescription = "Location where you can train in the art of"
            + " the sword.  Unlocks the knight profession.";
    int thisBuildingCost = 500;
    
    public TrainingGrounds(GameEngine game, Town town) {
        super(game, town);
        super.buildingName = thisBuildingName;
        super.buildingDescription = thisBuildingDescription;
        super.buildingCost = thisBuildingCost;
    }
  
    @Override
    public boolean canBeBuilt() {
        return  town.dungeonIsClear("Forest");
    }    
}
