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
public class DungeonPrereq {
    private final GameEngine game;
    
    public DungeonPrereq(GameEngine game) {
        this.game = game;
    }
    
    public boolean forestPrereqsMet() {
        return true;
    }

    public Boolean cavePrereqsMet() {
        return game.getTown().dungeonIsClear("Forest");
    }
}
