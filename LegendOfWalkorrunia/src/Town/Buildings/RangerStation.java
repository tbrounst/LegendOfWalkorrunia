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
public class RangerStation extends AbstractBuilding {
    String thisBuildingName = "Ranger Station";
    String thisBuildingDescription = "Location where you can train in the art "
            + "of a bow.  Unlocks the ranger profession.";
    int thisBuildingCost = 2000;
    
    public RangerStation(GameEngine game, Town town) {
        super(game, town);
        super.buildingName = thisBuildingName;
        super.buildingDescription = thisBuildingDescription;
        super.buildingCost = thisBuildingCost;        
    }
    
    @Override
    public boolean canBeBuilt() {
        return false;
    }
}
