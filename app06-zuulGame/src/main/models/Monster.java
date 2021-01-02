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
 * @health default value 200%.
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

    /**
     * Create new monster with default value for health
     * and set the name of this monster
     */
    public Monster(String name) 
    {
        setName(name);
        this.health = 100;
    }

    /**
     * Create new monster as set its health and name
     */
    public Monster(String name, int health)
    {
        setName(name);
        this.health = health;
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
}
