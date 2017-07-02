/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem.Attacks;

import BattleSystem.Battle;
import BattleSystem.ICombatant;
import Enemies.Goblin;
import Enemies.IEnemy;
import GameEngine.GameEngine;
import Player.Player;
import Town.Dungeons.AbstractDungeon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class AbstractAttackTest {
    GameEngine game;
    AbstractDungeon dungeon;
    Player player;
    IEnemy enemy;
    Battle battle;
    
    public AbstractAttackTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        dungeon = game.getTown().getDungeon("Forest");
        player = game.getPlayer();
        enemy = new Goblin();
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
     * Test of basicAttack method, of class AbstractAttack.
     */
    @Test
    public void testBasicAttack_3args() {
        System.out.println("basicAttack");
        AbstractAttack instance = new AbstractAttackImpl();
        assertEquals((Integer) 6, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance.basicAttack(battle, player, enemy);
        assertEquals((Integer) 4, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance.basicAttack(battle, enemy, player);
        assertEquals((Integer) 4, battle.getEnemyHealth());
        assertEquals((Integer) 8, battle.getPlayerHealth());
    }

    /**
     * Test of basicAttack method, of class AbstractAttack.
     */
    @Test
    public void testBasicAttack_4args() {
        System.out.println("basicAttack");
        assertEquals((Integer) 6, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        AbstractAttack instance = new AbstractAttackImpl();
        instance.basicAttack(battle, player, enemy, 1);
        assertEquals((Integer) 3, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance.basicAttack(battle, player, enemy, -1);
        assertEquals((Integer) 2, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
    }

    public class AbstractAttackImpl extends AbstractAttack {

        public void attack(Battle battle, ICombatant attacker, ICombatant defender) {
        }
    }
    
}
