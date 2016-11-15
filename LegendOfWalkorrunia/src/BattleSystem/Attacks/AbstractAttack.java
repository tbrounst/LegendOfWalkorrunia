/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem.Attacks;

import BattleSystem.Battle;
import BattleSystem.ICombatant;
import Player.Stats;

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
        //Integer attackerAttack = attacker.getStats().getStat(Stats.StatEnum.ATTACK) + modifier;
        Integer attackerAttack = battle.getStat(attacker, Stats.StatEnum.ATTACK);
        Integer defenderDefense = battle.getStat(defender, Stats.StatEnum.DEFENSE);
        Integer healthChange = (Math.max(1, attackerAttack - defenderDefense))*-1;
        battle.changeHealth(defender, healthChange);
    }
    
    abstract public void attack(ICombatant attacker, ICombatant defender);
}
