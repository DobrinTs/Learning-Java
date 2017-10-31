/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.uni.sofia.fmi.mjt.dungeon.treasure;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

/**
 *
 * @author dobri
 */
public class HealthPotion implements Treasure{
    int healingPoints;
    
    public HealthPotion(int healingPoints)
    {
        this.healingPoints = healingPoints;
    }
    
    public int heal(){ return healingPoints; }
    
    public String collect(Hero h)
    {
        if(h.getHealth() > 0)
            h.takeHealing(healingPoints);
        
        return "Health potion found! " + healingPoints + 
                " health points added to your hero!";
    }
}
