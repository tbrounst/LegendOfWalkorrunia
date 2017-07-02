/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem;

import BattleSystem.Attacks.AbstractAttack;
import BattleSystem.Attacks.BasicAttack;
import Enemies.IEnemy;
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
public class BattleTest {
    GameEngine game;
    AbstractDungeon dungeon;
    Player player;
    IEnemy enemy;
    Battle battle;
    
    public BattleTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        dungeon = game.getTown().getDungeon("Forest");
        player = game.getPlayer();
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
     * Test of turn method, of class Battle.
     */
    @Test
    public void testTurn() {
        System.out.println("testTurn--Basic");
        enemy = new IEnemyImpl(60);
        battle = new Battle(game, dungeon, player, enemy);
        battle.turn(new BasicAttack());
        assertEquals((Integer) 9, battle.getPlayerHealth());
        assertEquals((Integer) 2, battle.getEnemyHealth());
        
        System.out.println("testTurn--Buffs Work");
        battle = new Battle(game, dungeon, player, enemy);
        Stats statBuff = new Stats(0, 6, 2, 0, 0, 0);
        Buff buff = new Buff(enemy, 1, statBuff);
        assertEquals((Integer) 10, battle.getPlayerHealth());
        assertEquals((Integer) 6, battle.getEnemyHealth());
        assertEquals((Integer) 6, battle.getStat(enemy, StatEnum.ATTACK));
        assertEquals((Integer) 6, battle.getStat(enemy, StatEnum.DEFENSE));
        battle.addBuff(buff);
        assertEquals((Integer) 12, battle.getStat(enemy, StatEnum.ATTACK));
        assertEquals((Integer) 8, battle.getStat(enemy, StatEnum.DEFENSE));
        battle.turn(new BasicAttack());
        assertEquals((Integer) 8, battle.getPlayerHealth());
        assertEquals((Integer) 4, battle.getEnemyHealth());
        assertEquals((Integer) 6, battle.getStat(enemy, StatEnum.ATTACK));
        assertEquals((Integer) 6, battle.getStat(enemy, StatEnum.DEFENSE));
        
        //This is mostly for completeness sake.  I wrote it earlier.
        System.out.println("testTurn--End Turn");
        battle = new Battle(game, dungeon, player, enemy);
        statBuff = new Stats(0, 0, 5, 0, 0, 0);
        buff = new Buff(battle.getPlayer(), 1, statBuff);
        battle.addBuff(buff);
        assertEquals((Integer) 15, battle.getStat(player, StatEnum.DEFENSE));
        battle.turn(new BasicAttack());
        assertEquals((Integer) 10, battle.getStat(player, StatEnum.DEFENSE));
        
        System.out.println("testTurn--End Battle--Lose");
        enemy = new IEnemyImpl(1000001);
        battle = new Battle(game, dungeon, player, enemy);
        battle.turn(new BasicAttack());
        assertFalse(dungeon.isCleared());
        
        System.out.println("testTurn--End Battle--Win");
        enemy = new IEnemyImpl(1);
        battle = new Battle(game, dungeon, player, enemy);
        battle.turn(new BasicAttack());
        assertTrue(dungeon.isCleared());
    }

    /**
     * Test of changeHealth method, of class Battle.
     */
    @Test
    public void testChangeHealth() {
        System.out.println("changeHealth");
        enemy = new IEnemyImpl(100);
        battle = new Battle(game, dungeon, player, enemy);
        battle.changeHealth(player, 3);
        assertEquals((Integer) 13, battle.getPlayerHealth());
        battle.changeHealth(player, -10);
        assertEquals((Integer) 3, battle.getPlayerHealth());
        battle.changeHealth(player, -13);
        assertEquals(-10, battle.getPlayerHealth().intValue());
        
        battle.changeHealth(enemy, -3);
        assertEquals((Integer) 7, battle.getEnemyHealth());
        
        battle.changeHealth(null, 5);
        assertEquals(-10, battle.getPlayerHealth().intValue());
        assertEquals((Integer) 7, battle.getEnemyHealth());
    }

    /**
     * Test of getStat method, of class Battle.
     */
    @Test
    public void testGetStat() {
        System.out.println("getStat");
        enemy = new IEnemyImpl(50);
        battle = new Battle(game, dungeon, player, enemy);
        
        ICombatant combatant = battle.getEnemy();
        assertEquals((Integer) 5, battle.getStat(combatant, StatEnum.ATTACK));
        
        Stats statBuff = new Stats(0, 2, -2, 0, 0, 0);
        Buff buff = new Buff(combatant, 3, statBuff);
        battle.addBuff(buff);
        
        assertEquals((Integer) 7, battle.getStat(combatant, StatEnum.ATTACK));
        assertEquals((Integer) 3, battle.getStat(combatant, StatEnum.DEFENSE));
        assertEquals((Integer) 5, battle.getStat(combatant, StatEnum.MAGICATTACK));
    }
    
    public class IEnemyImpl implements IEnemy {
        private final Stats stats = new Stats(1,1,1,1,1,1);
        private final String name = "Test monster";
        private final Integer level;
        
        public IEnemyImpl(int level) {
            this.level = level;
        }
        
        public String enemyName() {
            return name;
        }
        
        public Stats getStats() {
            return stats.computeStatsAtLevel(level);
        }
    }
}
