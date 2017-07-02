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
import Town.Dungeons.AbstractDungeon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class HealTest {
    GameEngine game;
    AbstractDungeon dungeon;
    Player player;
    IEnemy enemy;
    Battle battle;
    
    public HealTest() {
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
     * Test of attack method, of class Heal.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        AbstractAttack instance = new Heal();
        assertEquals((Integer) 100, battle.getEnemyHealth());
        assertEquals((Integer) 10, battle.getPlayerHealth());
        instance.attack(battle, player, enemy);
        assertEquals((Integer) 100, battle.getEnemyHealth());
        assertEquals((Integer) 15, battle.getPlayerHealth());
    }
    
}
