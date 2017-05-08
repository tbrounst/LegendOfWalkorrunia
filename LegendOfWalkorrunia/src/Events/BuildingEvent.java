/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Town.Buildings.AbstractBuilding;
import java.util.EventObject;

/**
 *
 * @author Thomas
 */
public class BuildingEvent extends EventObject {
    
    public BuildingEvent(AbstractBuilding source) {
        super(source);
    }
    
    public AbstractBuilding getBuilding() {
        return (AbstractBuilding) source;
    }
    
}
