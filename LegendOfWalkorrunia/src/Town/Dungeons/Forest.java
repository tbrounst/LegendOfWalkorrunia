/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Dungeons;

import BattleSystem.Battle;
import Enemies.Goblin;
import Enemies.IEnemy;
import GameEngine.GameEngine;
import Town.Town;

/**
 *
 * @author Thomas
 */
public class Forest extends AbstractDungeon {
    private final String thisDungeonName = "Forest";
    
    public Forest(GameEngine game, Town town) {
        super(game, town);
        super.dungeonName = thisDungeonName;
    }
    
    @Override
    public Boolean canAccess() {
        return true;
    }
    
    @Override
    public IEnemy getEnemy() {
        return new Goblin();
    }    
}
