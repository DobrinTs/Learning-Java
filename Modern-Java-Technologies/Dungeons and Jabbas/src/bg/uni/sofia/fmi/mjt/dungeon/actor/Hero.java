/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.uni.sofia.fmi.mjt.dungeon.actor;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
/**
 *
 * @author dobri
 */
public class Hero implements Actor{
    String name;
    int currentHealth;
    int maxHealth;
    int currentMana;
    int maxMana;
    Position position;
    Weapon weapon;
    Spell spell;
    
    
    public Hero(String name, int health, int mana, Position position)
    {
        this.name = name;
        this.currentHealth = health;
        this.maxHealth = health;
        this.currentMana = mana;
        this.maxMana = mana;
        this.position = new Position(position.getX(), position.getY());
        weapon = null;
        spell = null;
    }
    
    public String getName(){ return name; }
    public int getHealth(){ return currentHealth; }
    public int getMana(){ return currentMana; }
    public Position getPosition(){ return position; }
    
    public boolean isAlive()
    {
        return currentHealth > 0;
    }
    
    public void takeHealing(int healingPoints)
    {
        currentHealth += healingPoints;
        if( currentHealth > maxHealth )
            currentHealth = maxHealth;
    }
    
    public void takeDamage(int damagePoints)
    {
        currentHealth -= damagePoints;
        if( currentHealth < 0 )
            currentHealth = 0;
    }
    
    public void takeMana(int manaPoints)
    {
        currentMana += manaPoints;
        if( currentMana > maxMana )
            currentMana = maxMana;
    }
    
    public void equip(Weapon weapon)
    {
        if(this.weapon == null || this.weapon.getDamage() < weapon.getDamage())
        {
            this.weapon = weapon;
        }
    }
    
    public Weapon getWeapon()
    {
        return weapon;
    }
    
    public void learn(Spell spell)
    {
        if(this.spell == null || this.spell.getDamage() < spell.getDamage())
        {
            this.spell = spell;
        }
    }
    
    public Spell getSpell()
    {
        return spell;
    }
    
    public int attack()
    {
        int att = 0;
        if(weapon != null)
            att = weapon.getDamage();
        
        if(spell != null && spell.getDamage() > att 
                && currentMana >= spell.getManaCost())
        {
            att = spell.getDamage();
            currentMana -= spell.getManaCost();
        }
        
        return att;
    }
}
