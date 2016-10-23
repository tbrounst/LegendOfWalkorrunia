/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Town.Buildings;

/**
 *
 * @author Thomas
 */
public interface IBuilding {
    
    public String description();
    
    public int getCost();
    
    public String getName();
    
    public boolean isBuilt();
    
    public void build();
    
    public boolean canBeBuilt();
}
