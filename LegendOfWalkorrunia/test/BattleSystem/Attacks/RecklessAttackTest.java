/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem.Attacks;

import BattleSystem.Battle;
import BattleSystem.ICombatant;
import Enemies.IEnemy;
import Enemies.TrainingDummy;
import GameEngine.GameEngine;
import Player.Player;
import Player.Stats;
import Player.Stats.StatEnum;
import Town.Dungeons.AbstractDungeon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class RecklessAttackTest {
    GameEngine game;
    AbstractDungeon dungeon;
    Player player;
    IEnemy enemy;
    Battle battle;
    
    public RecklessAttackTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        dungeon = game.getTown().getDungeon("Forest");
        player = game.getPlayer();
        enemy = new TrainingDummy();
        battle = new Battle(game, dungeon, player, enemy);
    }
    
    @After
    public void tearDown() {
        game = null;
        dungeon = null;
        player = null;
        enemy = null;
        battle = null;
    }

    /**
     * Test of attack method, of class RecklessAttack.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        AbstractAttack instance = new RecklessAttack();
        assertEquals((Integer) 100, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        battle.turn(instance);
        assertEquals((Integer) 96, battle.getEnemyHealth());
        assertEquals((Integer) 8, battle.getPlayerHealth());
        assertEquals((Integer) 10, battle.getStat(player, StatEnum.ATTACK));
        assertEquals((Integer) 10, battle.getStat(player, StatEnum.DEFENSE));
        instance = new BasicAttack();
        battle.turn(instance);
        assertEquals((Integer) 94, battle.getEnemyHealth());
        assertEquals((Integer) 7, battle.getPlayerHealth());
    }
    
}
