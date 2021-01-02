package main.models;

/**
 * Class Monster - a monster in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Monster" represents the boss in the game. 
 * It keeps information about:
 * 
 * @name it needs to be more than 2 symbols long
 * 
 * @health default value 100%.
 * It is possible to be set different value through
 * the second constructor.
 * 
 * @attack default value 10.
 * It is possible to be set different value through
 * the second constructor.
 * 
 * @author Yavor Yankov
 * @version 02/01/2021
 */
public class Monster 
{
    private String name; // name of this monster
    private int health;  // health of this monster
    private int attack;  // attack points of this monster

    /**
     * Create new monster with default values for health and attack,
     * and set the name of this monster
     */
    public Monster(String name) 
    {
        setName(name);
        this.health = 100;
        this.attack = 10;
    }

    /**
     * Create new monster as set its health, attack and name
     */
    public Monster(String name, int health, int attack)
    {
        setName(name);
        this.health = health;
        this.attack = attack;
    }

    /**
     * @return the name of this monster
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * The monster name can be set only throught the constructor
     * and cannot be changed afterwards.
     * 
     * @exception IllegalArgumentException is thrown
     * if the name lenght is less than 3 symbols 
     * 
     * @param name of this monster
     */
    private void setName(String name) 
    {
        if(name.length() < 3)
        {
            throw new IllegalArgumentException("Monster name cannot be less than 3 symbols!");
        }
        this.name = name;
    }

    /**
     * @return the health of this monster
     */
    public int getHealth()
    {
        return this.health;
    }

    /**
     * @return the attack points of this monster
     */
    public int getAttack()
    {
        return this.attack;
    }

    /**
     * Decrease the health of this monster
     * 
     * @param decrease value
     */
    public void decreaseHealth(int decrease)
    {
        isDecreaseValid(decrease);
        
        this.health -= decrease;
        
        if(this.health < 0)
        {
            this.health = 0;
        }

        System.out.println(
            this.name + ", HP decreased with "+ decrease +
            ", health: " + this.health + "%.\n\r");
    }

    /**
     * @return information about this monster
     */
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("name:   " + this.name + "\n\r");
        strBuilder.append("attack: " + this.attack+ "\n\r");
        strBuilder.append("health: " + this.health + "\n\r");

        return strBuilder.toString();
    }

    /**
     * Checks is the decrease value meets the requirements
     * 
     * @exception IllegalArgumentException is thrown 
     * if decrease value is less than or equal to zero
     * 
     * @param decrease value of health or energy 
     */
    private void isDecreaseValid(int decrease)
    {
        if(decrease <= 0)
        {
            throw new IllegalArgumentException("Decrease value cannot be equal or less than zero!");
        }
    }
}
