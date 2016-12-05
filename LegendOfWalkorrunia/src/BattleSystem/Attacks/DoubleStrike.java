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
public class DoubleStrike extends AbstractAttack {
    String thisAttackName = "Double Strike!";
    String thisAttackDescription = "Hit it with a stick!  Twice!  Each hit does less damage.";
    
    public DoubleStrike(/*Battle battle*/) {
        //super(battle);
        super();
        super.attackName = thisAttackName;
        super.attackDescription = thisAttackDescription;
    }
    
    @Override
    public void attack(Battle battle, ICombatant attacker, ICombatant defender) {
        basicAttack(battle, attacker, defender, -2);
        basicAttack(battle, attacker, defender, -2);
    }
    
}
