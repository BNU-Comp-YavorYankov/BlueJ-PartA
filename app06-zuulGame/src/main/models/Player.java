package main.models;

/**
 * Class Player - a player in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Player" represents an user in the game. It keeps information
 * about energy and score points. Each player has a max 100% energy and
 * score 0 at the start of the game. After every movement from 
 * one location to another it decreases the energy with 1%.
 * If player`s energy is 0%, he dies.
 * In order to increase the energy level, the player has to
 * eat some food.
 *  @author Yavor Yankov
 * @version 22/12/2020
 */
public class Player 
{
    private String name; // name of this player
    private int energy;  // energy of this player
    private int score;   // score points of this player
    
    /**
     * The constructor of this player which
     * initialize new player as recieve its name
     * and set default values for energy and score.
     * 
     * @param name of this player
     */
    public Player(String name)
    {
        this.name = name;
        this.energy = 100;
        this.score = 0;
    }

    /**
     * @return player`s name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @param newName of this player
     */
    public void setName(String newName) 
    {
        this.name = newName;
    }

    /**
     * @return energy of this player
     */
    public int getEnergy() 
    {
        return energy;
    }

    /**
     * Increase energy of this player.
     *
     * @exception IllegalArgumentException is thrown 
     * if increase value is less than or equal to zero
     * 
     * @param increase energy levels of this player
     */
    public void increaseEnergy(int increase) 
    {
        if(increase <= 0)
        {
            throw new IllegalArgumentException("Increase value cannot be equal or less than zero!");
        }
        
        int newEnergyLevels = this.energy + increase;

        if(newEnergyLevels > 100)
        {
            this.energy = 100;
            System.out.println(this.name + " your energy levels are full.");
        }
        else
        {
            this.energy = newEnergyLevels;
            
            System.out.println(
                this.name + " your energy levels has been increased with " + increase + ".\n\r" +
                "Now you have " + this.energy + " energy.");
        }
    }

    /**
     * Decrease energy of this player.
     * 
     * @exception IllegalArgumentException is thrown 
     * if increase value is less than or equal to zero
     * 
     * @param decrease energy levels of this player
     */
    public void decreaseEnergy(int decrease)
    {
        if(decrease <= 0)
        {
            throw new IllegalArgumentException("Decrease value cannot be equal or less than zero!");
        }

        int newEnergyLevels = this.energy - decrease;

        if((newEnergyLevels) <= 0)
        {
            System.out.println(this.name + " ,you died in a cruel fight...");
        }
        else 
        {
            this.energy = newEnergyLevels;
            
            System.out.println(
                this.name + " ,after the fight with the monster\n\r"+
                "your energy levels has decreased with " + decrease + "%.\n\r"+
                "Now your energy levels are " + this.energy + "%.");
        }
    }

    /**
     * @return score points of this player
     */
    public int getScore() 
    {
        return score;
    }

    /**
     * Player`s score can be increased from fights
     * 
     * @param increase the score of this player
     */
    public void increaseScore(int increase) 
    {
        this.score = increase;
    }
}
