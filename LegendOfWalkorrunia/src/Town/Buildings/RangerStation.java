/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Buildings;

import Town.Town;

/**
 *
 * @author Thomas
 */
public class RangerStation implements IBuilding {
    Town town;
    int cost = 500;
    String name = "Ranger Station";
    
    public RangerStation(Town town) {
        this.town = town;
    }

    @Override
    public String description() {
        return "Location where you can train in the art of a bow.  Unlocks " +
                "the ranger profession";
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean canBeBuilt() {
        return false;
    }

    @Override
    public boolean isBuilt() {
        return false;
    }
    
    @Override
    public void build() {
        
    }
}
