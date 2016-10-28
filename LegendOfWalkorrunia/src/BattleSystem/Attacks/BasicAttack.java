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
public class BasicAttack extends AbstractAttack {
    String thisAttackName = "Basic attack";
    String thisAttackDescription = "Hit it with a stick!";
    
    public BasicAttack(Battle battle) {
        super(battle);
        super.attackName = thisAttackName;
        super.attackDescription = thisAttackDescription;
    }
    
    @Override
    public void attack(ICombatant attacker, ICombatant defender) {
        basicAttack(attacker, defender);
    }
    
}
