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
public class TownHall implements IBuilding {
    final int cost = 0;
    final String name = "Town Hall";
    final Town town;
    
    public TownHall(Town town) {
        this.town = town;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String description() {
        return "This is your starting building.  Treat it like your home.  " +
                "Here you can manage your equipment or something";
    }

    @Override
    public int getCost() {
        return cost;
    }
    
    @Override
    public boolean canBeBuilt() {
        return true;
    }

    @Override
    public boolean isBuilt() {
        return true;
    }    

    @Override
    public void build() {
        
    }
}
