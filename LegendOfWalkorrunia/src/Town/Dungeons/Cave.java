/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Dungeons;

import BattleSystem.Battle;
import Enemies.Orc;
import GameEngine.GameEngine;
import Town.Town;

/**
 *
 * @author Thomas
 */
public class Cave implements IDungeon{
    private final GameEngine game;
    private final Town town;
    private final String name = "Cave";
    private Boolean isCleared = false;
    
    public Cave (GameEngine game, Town town) {
        this.game = game;
        this.town = town;
    }

    @Override
    public String getDungeonName() {
        return name;
    }

    @Override
    public Boolean canAccess() {
        return game.getDungeonPrereqs().cavePrereqsMet();
    }

    @Override
    public Boolean isCleared() {
        return isCleared;
    }

    @Override
    public void clearDungeon() {
        isCleared = true;
    }

    @Override
    public Battle createBattle() {
        return new Battle(this, game.getPlayer(), new Orc());
    }
    
}
