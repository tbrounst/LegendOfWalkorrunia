/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Dungeons;

import BattleSystem.Battle;
import Enemies.IEnemy;
import Enemies.Orc;
import GameEngine.GameEngine;
import Town.Town;

/**
 *
 * @author Thomas
 */
public class Cave extends AbstractDungeon{
    private final String thisDungeonName = "Cave";
    private final IEnemy thisEnemy = new Orc();
    
    public Cave (GameEngine game, Town town) {
        super(game, town);
        super.dungeonName = thisDungeonName;
        super.enemy = thisEnemy;
    }

    @Override
    public Boolean canAccess() {
        return town.dungeonIsClear("Forest");
    }
}
