/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import Events.BuildingEvent;
import Events.EventHub;
import Player.Player;
import Town.Buildings.IBuilding;
import Town.Town;

/**
 *
 * @author Thomas
 */
public class GameEngine {
    private final Town town;
    private final Player player;
    private Integer eps;
    private final JobPrereq jp;
    private final BuildingPrereq bp;
    private final DungeonPrereq dp;
    //public final EventHub eh = new EventHub(this);
    
    
    public GameEngine() {
        this.town = new Town(this);
        this.player = new Player(this, "Tom");
        this.eps = 1000;
        this.jp = new JobPrereq(this);
        this.bp = new BuildingPrereq(this);
        this.dp = new DungeonPrereq(this);
        //eh.addBuildingListener(jp);
    }
    
    public Town getTown() {
        return town;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public Integer getEps() {
        return eps;
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
    
    public void build(IBuilding bldg) {
        build(bldg.getName());
    }
    
    public void build(String bldgString) {
        IBuilding bldg = town.getBuilding(bldgString);
        if (bldg.getCost() > eps) return;
        if (bldg.isBuilt()) return;
        if (!bldg.canBeBuilt()) return;
        town.constructBuilding(bldgString);
        eps -= bldg.getCost();
        fireBuildingEvent(bldg);
    }
    
    private synchronized void fireBuildingEvent(IBuilding bldg) {
        BuildingEvent buildingEvent = new BuildingEvent(bldg);
        //eh.fireBuildingEvent(buildingEvent);
    }
    
    
    
}
