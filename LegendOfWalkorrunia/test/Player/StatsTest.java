/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class StatsTest {
    
    public StatsTest() {
    }
    
    /**
     * Test of getStat method, of class Stats.
     */
    @Test
    public void testGetStat() {
        System.out.println("getStat");
        Stats instance = new Stats(1,2,3,4,5,6);
        assertEquals((Integer) 1, instance.getStat(Stats.StatEnum.HP));
        assertEquals((Integer) 2, instance.getStat(Stats.StatEnum.ATTACK));
        assertEquals((Integer) 3, instance.getStat(Stats.StatEnum.DEFENSE));
        assertEquals((Integer) 4, instance.getStat(Stats.StatEnum.MAGICATTACK));
        assertEquals((Integer) 5, instance.getStat(Stats.StatEnum.MAGICDEFENSE));
        assertEquals((Integer) 6, instance.getStat(Stats.StatEnum.SPEED));
    }

    /**
     * Test of computeStatsAtLevel method, of class Stats.
     */
    @Test
    public void testComputeStatsAtLevel() {
        System.out.println("computeStatsAtLevel");
        Stats instance = new Stats(1,2,3,4,5,6);
        
        Integer level = 1;
        Stats result = instance.computeStatsAtLevel(level);
        assertEquals((Integer) 1, result.getStat(Stats.StatEnum.HP));
        assertEquals((Integer) 2, result.getStat(Stats.StatEnum.ATTACK));
        assertEquals((Integer) 3, result.getStat(Stats.StatEnum.DEFENSE));
        assertEquals((Integer) 4, result.getStat(Stats.StatEnum.MAGICATTACK));
        assertEquals((Integer) 5, result.getStat(Stats.StatEnum.MAGICDEFENSE));
        assertEquals((Integer) 6, result.getStat(Stats.StatEnum.SPEED));
        
        level = 10;
        result = instance.computeStatsAtLevel(level);
        assertEquals((Integer) 1, result.getStat(Stats.StatEnum.HP));
        assertEquals((Integer) 3, result.getStat(Stats.StatEnum.ATTACK));
        assertEquals((Integer) 5, result.getStat(Stats.StatEnum.DEFENSE));
        assertEquals((Integer) 7, result.getStat(Stats.StatEnum.MAGICATTACK));
        assertEquals((Integer) 9, result.getStat(Stats.StatEnum.MAGICDEFENSE));
        assertEquals((Integer) 11, result.getStat(Stats.StatEnum.SPEED));
        
        level = 25;
        result = instance.computeStatsAtLevel(level);
        assertEquals((Integer) 3, result.getStat(Stats.StatEnum.HP));
        assertEquals((Integer) 6, result.getStat(Stats.StatEnum.ATTACK));
        assertEquals((Integer) 10, result.getStat(Stats.StatEnum.DEFENSE));
        assertEquals((Integer) 13, result.getStat(Stats.StatEnum.MAGICATTACK));
        assertEquals((Integer) 17, result.getStat(Stats.StatEnum.MAGICDEFENSE));
        assertEquals((Integer) 20, result.getStat(Stats.StatEnum.SPEED));
        
        level = 100;
        result = instance.computeStatsAtLevel(level);
        assertEquals((Integer) 10, result.getStat(Stats.StatEnum.HP));
        assertEquals((Integer) 21, result.getStat(Stats.StatEnum.ATTACK));
        assertEquals((Integer) 32, result.getStat(Stats.StatEnum.DEFENSE));
        assertEquals((Integer) 43, result.getStat(Stats.StatEnum.MAGICATTACK));
        assertEquals((Integer) 54, result.getStat(Stats.StatEnum.MAGICDEFENSE));
        assertEquals((Integer) 65, result.getStat(Stats.StatEnum.SPEED));
        
        level = -1;
        result = instance.computeStatsAtLevel(level);
        assertEquals(null, result);
    }

    /**
     * Test of toString method, of class Stats.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Stats instance = new Stats(1,2,3,4,5,6);
        String expResult = "Hp: 1\n" +
                "Attack: 2\n" +
                "Defense: 3\n" +
                "Magic Attack: 4\n" +
                "Magic Defense: 5\n" +
                "Speed: 6";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
