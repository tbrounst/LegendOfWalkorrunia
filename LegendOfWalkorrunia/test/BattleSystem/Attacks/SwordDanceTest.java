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
import Town.Dungeons.AbstractDungeon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class SwordDanceTest {
    GameEngine game;
    AbstractDungeon dungeon;
    Player player;
    IEnemy enemy;
    Battle battle;
    
    public SwordDanceTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        dungeon = game.getTown().getDungeon("Forest");
        player = game.getPlayer();
        enemy = new TrainingDummy(new Stats(100,12,10,10,10,10));
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
     * Test of attack method, of class SwordDance.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        AbstractAttack instance = new SwordDance();
        assertEquals((Integer) 100, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance.attack(battle, player, enemy);
        assertEquals((Integer) 100, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        assertEquals((Integer) 12, battle.getStat(player, Stats.StatEnum.ATTACK));
        assertEquals((Integer) 12, battle.getStat(player, Stats.StatEnum.DEFENSE));
        instance = new BasicAttack();
        battle.turn(instance);
        assertEquals((Integer) 98, battle.getEnemyHealth());
        assertEquals((Integer) 9, battle.getPlayerHealth());
        assertEquals((Integer) 12, battle.getStat(player, Stats.StatEnum.ATTACK));
        assertEquals((Integer) 12, battle.getStat(player, Stats.StatEnum.DEFENSE));
        battle.turn(instance);
        battle.turn(instance);
        battle.turn(instance);
        battle.turn(instance);
        assertEquals((Integer) 90, battle.getEnemyHealth());
        assertEquals((Integer) 5, battle.getPlayerHealth());
        assertEquals((Integer) 10, battle.getStat(player, Stats.StatEnum.ATTACK));
        assertEquals((Integer) 10, battle.getStat(player, Stats.StatEnum.DEFENSE));
        battle.turn(instance);
        assertEquals((Integer) 89, battle.getEnemyHealth());
        assertEquals((Integer) 3, battle.getPlayerHealth());
        assertEquals((Integer) 10, battle.getStat(player, Stats.StatEnum.ATTACK));
        assertEquals((Integer) 10, battle.getStat(player, Stats.StatEnum.DEFENSE));
    }
    
}
