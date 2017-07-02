/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import Events.EventHub;
import Player.Player;
import Town.Buildings.AbstractBuilding;
import Town.Town;

/**
 *
 * @author Thomas
 */
public class GameEngine {
    private final Town town;
    private final Player player;
    private Integer eps = 1000;
    //private final JobPrereq jp;
    //private final BuildingPrereq bp;
    //private final DungeonPrereq dp;
    private final EventHub eh = new EventHub(this);
    
    
    public GameEngine() {
        this.player = new Player(this, "Tom");
        this.town = new Town(this);
        //this.player = new Player(this, "Tom");
        this.eps = 1000;
        //this.jp = new JobPrereq(this);
        //this.bp = new BuildingPrereq(this);
        //this.dp = new DungeonPrereq(this);
        //eh.addBuildingListener(jp);
    }
    
    public Town getTown() {
        return town;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    /**
    public Integer getEps() {
        return player.getEps();
    }
    
    public void setEps(Integer eps) {
        player.setEps(eps);
    }
    
    public void modifyEps(int change) {
        eps += change;
    }
    
    public JobPrereq getJobPrereqs() {
        return jp;
    }
    
    public BuildingPrereq getBuildingPrereqs() {
        return bp;
    }
    
    public DungeonPrereq getDungeonPrereqs() {
        return dp;
    }
    **/

    
    public EventHub getEventHub() {
        return eh;
    }
    
    /**
    public Integer build(AbstractBuilding bldg) {
        return build(bldg.getName());
    }
    
    public Integer build(String bldgString) {
        /**
        AbstractBuilding bldg = town.getBuilding(bldgString);
        if (bldg.getCost() > eps) return 1;
        if (bldg.isBuilt()) return 2;
        if (!bldg.canBeBuilt()) return 3;
        town.constructBuilding(bldgString);
        eps -= bldg.getCost();
        return 0;

        return town.constructBuilding(bldgString);
    }
    **/
        
}
