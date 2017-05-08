/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Dungeons;

import BattleSystem.Battle;
import Enemies.IEnemy;
import GameEngine.GameEngine;
import Town.Town;

/**
 *
 * @author Thomas
 */
public abstract class AbstractDungeon {
    protected final GameEngine game;
    protected final Town town;
    protected String dungeonName;
    protected Boolean isCleared = false;
    
    public AbstractDungeon(GameEngine game, Town town) {
        this.game = game;
        this.town = town;
    }
    
    public String getDungeonName() {
        return dungeonName;
    }
    
    public Boolean isCleared() {
        return isCleared;
    }
    
    public void clearDungeon() {
        isCleared = true;
    }
    
    public Battle createBattle() {
        return new Battle(game, this, game.getPlayer(), getEnemy());
    }
    
    abstract public Boolean canAccess();
    
    abstract public IEnemy getEnemy();
    
    
    
}
