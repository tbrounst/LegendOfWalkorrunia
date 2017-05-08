/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import BattleSystem.Battle;
import java.util.EventObject;

/**
 *
 * @author Thomas
 */
public class BattleEvent extends EventObject {
    
    public BattleEvent(Battle source) {
        super(source);
    }
    
    public Battle getBattle() {
        return (Battle) source;
    }
    
}
