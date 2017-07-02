/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem.Attacks;

import BattleSystem.Battle;
import BattleSystem.Buff;
import BattleSystem.ICombatant;
import Enemies.IEnemy;
import Enemies.TrainingDummy;
import GameEngine.GameEngine;
import Player.Player;
import Player.Stats;
import Town.Dungeons.AbstractDungeon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class DoubleStrikeTest {
    GameEngine game;
    AbstractDungeon dungeon;
    Player player;
    IEnemy enemy;
    Battle battle;
    
    public DoubleStrikeTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        dungeon = game.getTown().getDungeon("Forest");
        player = game.getPlayer();
        enemy = new TrainingDummy(new Stats(100, 1, 100, 10, 10, 10));
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
     * Test of attack method, of class DoubleStrike.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        AbstractAttack instance = new DoubleStrike();
        assertEquals((Integer) 100, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance.attack(battle, player, enemy);
        assertEquals((Integer) 98, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance = new BasicAttack();
        instance.attack(battle, player, enemy);
        assertEquals((Integer) 97, battle.getEnemyHealth());
        Buff debuff = new Buff(enemy, 10, new Stats(0,0,-93,0,0,0));
        battle.addBuff(debuff);
        instance.attack(battle, player, enemy);
        assertEquals((Integer) 94, battle.getEnemyHealth());
        instance = new DoubleStrike();
        instance.attack(battle, player, enemy);
        assertEquals((Integer) 92, battle.getEnemyHealth());
        
    }
    
}
