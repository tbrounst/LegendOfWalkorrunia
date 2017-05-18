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
    private final IEnemy thisEnemy = new Goblin();
    
    public Forest(GameEngine game, Town town) {
        super(game, town);
        super.dungeonName = thisDungeonName;
        super.enemy = thisEnemy;
    }
    
    @Override
    public Boolean canAccess() {
        return true;
    }
}
