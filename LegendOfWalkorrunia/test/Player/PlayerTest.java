/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import BattleSystem.Attacks.AbstractAttack;
import GameEngine.GameEngine;
import Player.Jobs.AbstractJob;
import Player.Stats.StatEnum;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class PlayerTest {
    GameEngine game;
    String name = "Tom Test";
    Player player;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        game = new GameEngine();
        //player = new Player(game, name);
        player = game.getPlayer();
    }
    
    @After
    public void tearDown() {
        game = null;
        player = null;
    }

    /**
     * Test of changeJob method, of class Player.
     */
    @Test
    public void testChangeJob_String() {
        System.out.println("changeJob");
        
        String job = "Knight";
        player.changeJob(job);
        assertEquals("Royal", player.getJob().getJobName());
        
        game.getTown().getDungeon("Forest").clearDungeon();
        game.getTown().constructBuilding("Training Grounds");
        player.changeJob(job);
        assertEquals(job, player.getJob().getJobName());
        assertEquals((Integer) 15, player.getStats().getStat(StatEnum.HP));
        player.changeJob("Royal");
        assertEquals("Royal", player.getJob().getJobName());
        assertEquals((Integer) 10, player.getStats().getStat(StatEnum.HP));
    }    
}
