/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

/**
 *
 * @author Thomas
 */
public class BuildingPrereq {
    GameEngine game;
    
    public BuildingPrereq(GameEngine game) {
        this.game = game;
    }
    
    public boolean townHallPrereqsMet() {
        return true;
    }
    
    public boolean trainingGroundsPrereqsMet() {
        return game.getTown().dungeonIsClear("Forest");
    }
    
    public boolean rangerStationPrereqsMet() {
        return false;
    }
    
}
