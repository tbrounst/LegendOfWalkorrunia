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
public class TownHall extends AbstractBuilding {
    String thisBuildingName = "Town Hall";
    String thisBuildingDescription = "This is your starting building.  Treat it"
            + "like your home.  Here you can manage your equipment or something.";
    int thisBuildingCost = 0;
    
    public TownHall(GameEngine game, Town town) {
        super(game, town);
        super.buildingName = thisBuildingName;
        super.buildingDescription = thisBuildingDescription;
        super.buildingCost = thisBuildingCost;
        super.build();
    }
    
    @Override
    public boolean canBeBuilt() {
        return true;
    }
  
}
