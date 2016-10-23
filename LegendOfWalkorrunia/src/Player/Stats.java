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
    final public int hp;
    final public int attack;
    final public int defense;
    final public int magicAttack;
    final public int magicDefense;
    final public int speed;
    
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
    
    public String toString() {
        return "Hp: " + hp + "\n" +
                "Attack: " + attack + "\n" +
                "Defense: " + defense + "\n" +
                "Magic Attack: " + magicAttack + "\n" +
                "Magic Defense: " + magicDefense + "\n" +
                "Speed: " + speed;
    }
    
}
