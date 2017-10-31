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
public class ManaPotion implements Treasure{
    int manaPoints;
    
    public ManaPotion(int manaPoints)
    {
        this.manaPoints = manaPoints;
    }
    
    public int heal(){ return manaPoints; }
    
    public String collect(Hero h)
    {
        h.takeMana(manaPoints);
        
        return "Mana potion found! " + manaPoints + 
                " mana points added to your hero!";
    }
}
