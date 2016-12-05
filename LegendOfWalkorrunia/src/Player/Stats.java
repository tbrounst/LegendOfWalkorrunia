/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author Thomas
 */
public class Stats {
    final private int hp;
    final private int attack;
    final private int defense;
    final private int magicAttack;
    final private int magicDefense;
    final private int speed;
    
    public Stats() {
        this(10);
    }
    
    public Stats(int allValues) {
        this(allValues, allValues, allValues, allValues, allValues, allValues);
    }
    
    public Stats(int hp, int attack, int defense, int magicAttack, int magicDefense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
        this.speed = speed;
    }
    
     public Stats(Stats input) {
        this.hp = input.hp;
        this.attack = input.attack;
        this.defense = input.defense;
        this.magicAttack = input.magicAttack;
        this.magicDefense = input.magicDefense;
        this.speed = input.speed;
    }
     
    public Stats copy() {
        return new Stats(hp, attack, defense, magicAttack, magicDefense, speed);
    }
     
    public Integer getStat(StatEnum stat) {
        switch (stat) {
            case HP : return hp;
            case ATTACK : return attack;
            case DEFENSE : return defense;
            case MAGICATTACK : return magicAttack;
            case MAGICDEFENSE : return magicDefense;
            case SPEED : return speed;
        }
        return null;
    }
    
    public Stats computeStatsAtLevel(Integer level) {
        Double levelMod = 0.9 + level/10.0;
        int computedHp = (int) (hp * levelMod);
        int computedAttack = (int) (attack * levelMod);
        int computedDefense = (int) (defense * levelMod);
        int computedMagicAttack = (int) (magicAttack * levelMod);
        int computedMagicDefense = (int) (magicDefense * levelMod);
        int computedSpeed = (int) (speed * levelMod);
        return new Stats(computedHp, computedAttack, computedDefense, 
                computedMagicAttack, computedMagicDefense, computedSpeed);
    }
    
    public String toString() {
        return "Hp: " + hp + "\n" +
                "Attack: " + attack + "\n" +
                "Defense: " + defense + "\n" +
                "Magic Attack: " + magicAttack + "\n" +
                "Magic Defense: " + magicDefense + "\n" +
                "Speed: " + speed;
    }
    
    public enum StatEnum {
        HP, ATTACK, DEFENSE, MAGICATTACK, MAGICDEFENSE, SPEED
    }
    
}
