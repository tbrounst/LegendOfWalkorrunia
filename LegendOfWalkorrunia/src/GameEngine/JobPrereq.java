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
public class JobPrereq {
    private GameEngine game;
    
    public JobPrereq(GameEngine game) {
        this.game = game;
    }
    
    public boolean royalPrereqsMet() {
        return true;
    }
    
    public boolean knightPrereqsMet() {
        return game.getTown().buildingIsBuilt("Training Grounds");
    }
}
