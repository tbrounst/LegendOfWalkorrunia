/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem;

import GameEngine.GameEngine;
import Player.Stats;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class BuffTest {
    GameEngine game;
    ICombatant player;
    Buff buff;
    
    public BuffTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        player = game.getPlayer();
    }
    
    @After
    public void tearDown() {
        game = null;
        player = null;
    }

    /**
     * Test of decrementTurnsRemaining method, of class Buff.
     */
    @Test
    public void testDecrementTurnsRemaining() {
        System.out.println("decrementTurnsRemaining");
        Stats changes = new Stats(1,1,1,1,1,1);
        buff = new Buff(player, 5, changes);
        assertEquals((Integer) 5, buff.turnsRemaining());
        buff.decrementTurnsRemaining();
        assertEquals((Integer) 4, buff.turnsRemaining());
        buff.decrementTurnsRemaining();
        buff.decrementTurnsRemaining();
        assertEquals((Integer) 2, buff.turnsRemaining());
        
        buff = new Buff(player, -1, changes);
        assertEquals((Integer) 1, buff.turnsRemaining());
    }

    /**
     * Test of isFinished method, of class Buff.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        Stats changes = new Stats(1,1,1,1,1,1);
        buff = new Buff(player, 1, changes);
        assertFalse(buff.isFinished());
        buff.decrementTurnsRemaining();
        assertTrue(buff.isFinished());
        buff.decrementTurnsRemaining();
        buff.decrementTurnsRemaining();
        assertTrue(buff.isFinished());
    }
    
}
