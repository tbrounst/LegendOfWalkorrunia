/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town;

import GameEngine.GameEngine;
import Town.Buildings.AbstractBuilding;
import Town.Dungeons.AbstractDungeon;
import java.util.Collection;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Thomas
 */
public class TownTest {
    GameEngine game;
    Town town;
    
    public TownTest() {
    }

    @Before
    public void setUp() throws Exception {
        game = new GameEngine();
        town = game.getTown();
    }

    @After
    public void tearDown() throws Exception {
        game = null;
        town = null;
    }

    /**
     * Test of getBuildings method, of class Town.
     */
    @Test
    public void testGetBuildings() {
        System.out.println("getBuildings");
        assertEquals(3, town.getBuildings().size());
    }

    /**
     * Test of getBuilding method, of class Town.
     */
    @Test(expected=NullPointerException.class)
    public void testGetBuilding() {
        System.out.println("getBuilding");
        
        String buildingName = "Town Hall";
        AbstractBuilding result = town.getBuilding(buildingName);
        assertEquals(buildingName, result.getName());
        
        buildingName = "Training Grounds";
        result = town.getBuilding(buildingName);
        assertEquals(buildingName, result.getName());
        
        buildingName = "I'm not real";
        result = town.getBuilding(buildingName);
    }

    /**
     * Test of buildingIsBuilt method, of class Town.
     */
    @Test
    public void testBuildingIsBuilt() {
        System.out.println("buildingIsBuilt");
        Boolean result = town.buildingIsBuilt("Town Hall");
        assertTrue(result);
        
        result = town.buildingIsBuilt("Training Grounds");
        assertFalse(result);
    }

    /**
     * Test of getDungeons method, of class Town.
     */
    @Test
    public void testGetDungeons() {
        System.out.println("getDungeons");
        assertEquals(2, town.getDungeons().size());
    }

    /**
     * Test of getDungeon method, of class Town.
     */
    @Test (expected=NullPointerException.class)
    public void testGetDungeon() {
        System.out.println("getDungeon");
        
        String dungeonName = "Cave";
        AbstractBuilding result = town.getBuilding(dungeonName);
        assertEquals(dungeonName, result.getName());
        
        dungeonName = "Forest";
        result = town.getBuilding(dungeonName);
        assertEquals(dungeonName, result.getName());
        
        dungeonName = "I'm not real";
        result = town.getBuilding(dungeonName);
    }

    /**
     * Test of dungeonIsClear method, of class Town.
     */
    @Test
    public void testDungeonIsClear() {
        System.out.println("dungeonIsClear");
        
        Boolean result = town.dungeonIsClear("Cave");
        assertFalse(result);
    }

    /**
     * Test of constructBuilding method, of class Town.
     */
    @Test
    public void testConstructBuilding_AbstractBuilding() {
        System.out.println("constructBuilding");
        
        assertFalse(town.buildingIsBuilt("Training Grounds"));
        
        AbstractBuilding bldg = town.getBuilding("Training Grounds");
        game.modifyEps(-1000);
        int result = town.constructBuilding(bldg);
        assertEquals(1, result);
        
        game.modifyEps(1000);
        result = town.constructBuilding(bldg);
        assertEquals(3, result);
        
        town.getDungeon("Forest").clearDungeon();
        result = town.constructBuilding(bldg);
        assertEquals(0, result);
        
        result = town.constructBuilding(bldg);
        assertEquals(2, result);
        
        assertTrue(town.buildingIsBuilt("Training Grounds"));
    }

    /**
     * Test of constructBuilding method, of class Town.
     */
    @Test
    public void testConstructBuilding_String() {
        System.out.println("constructBuilding");
        
        assertFalse(town.buildingIsBuilt("Training Grounds"));
        
        String bldg = "Training Grounds";
        game.modifyEps(-1000);
        int result = town.constructBuilding(bldg);
        assertEquals(1, result);
        
        game.modifyEps(1000);
        result = town.constructBuilding(bldg);
        assertEquals(3, result);
        
        town.getDungeon("Forest").clearDungeon();
        result = town.constructBuilding(bldg);
        assertEquals(0, result);
        
        result = town.constructBuilding(bldg);
        assertEquals(2, result);
        
        assertTrue(town.buildingIsBuilt("Training Grounds"));
    }
    
}
