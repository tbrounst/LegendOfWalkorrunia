/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem.Attacks;

import BattleSystem.Battle;
import BattleSystem.ICombatant;

/**
 *
 * @author Thomas
 */
public abstract class AbstractAttack {
    protected String attackName;
    protected String attackDescription;
    protected final Battle battle;
    
    public AbstractAttack(Battle battle) {
        this.battle = battle;
    }
    
    public String getAttackName() {
        return attackName;
    }
    
    public String attackDescription() { 
        return attackDescription;
    }
    
    protected void basicAttack(ICombatant attacker, ICombatant defender) {
        basicAttack(attacker, defender, 0);
    }
    
    protected void basicAttack(ICombatant attacker, ICombatant defender, Integer modifier) {
        Integer attackerAttack = attacker.getStats().attack + modifier;
        Integer defenderDefense = defender.getStats().defense;
        Integer healthChange = (Math.max(1, attackerAttack - defenderDefense))*-1;
        battle.changeHealth(defender, healthChange);
    }
    
    abstract public void attack(ICombatant attacker, ICombatant defender);
}
