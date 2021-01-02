package main.models;

import main.items.Apple;
import main.items.Item;
import main.items.Potion;
import main.items.PotionType;
import main.items.Shield;

/**
 * Class Player - a player in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Player" represents an user in the game. 
 * It keeps information about:
 * 
 * @name it needs to be more than 2 symbols long
 * 
 * @energy default value 100%. 
 * Increase from food. Decrease from changing location and battles.
 * If energy become 0% each other action will decrease the health of the player.
 * 
 * @health default value 100%
 * Increase from food. Decrease from battles.
 * If health go below 0% the player dies.
 * 
 * @author Yavor Yankov
 * @version 22/12/2020
 */
public class Player 
{
    private String name;           // name of this player
    private int energy;            // energy of this player
    private int score;             // score points of this player
    private int health;            // health of this player
    private Inventory inventory;   // inventory of this player
    private int maxHealthCapacity; // maximum health of this player
    private int attack;            // attack points of this player

    /**
     * The constructor of this player which
     * initialize new player as recieve its name
     * and set default values of energy, score and health.
     * 
     * @param name of this player
     */
    public Player(String name)
    {
        this.setName(name);
        this.energy = 100;
        this.score = 0;
        this.health = 100;
        this.attack = 0;
        this.maxHealthCapacity = 100;
        this.inventory = new Inventory(this);
    }

    /**
     * @return player`s name
     */
    public String getName() 
    {
        return this.name;
    }

    /**
     * The player name can be set only throught the constructor
     * and cannot be changed afterwards.
     * 
     * @exception IllegalArgumentException is thrown
     * if the name lenght is less than 3 symbols 
     * 
     * @param newName of this player
     */
    private void setName(String newName) 
    {
        if(newName.length() < 3)
        {
            throw new IllegalArgumentException("Player name cannot be less than 3 symbols!");
        }
        this.name = newName;
    }

    /**
     * @return energy of this player
     */
    public int getEnergy() 
    {
        return this.energy;
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
        isIncreaseValid(increase);
        
        int newEnergyLevels = this.energy + increase;

        if(newEnergyLevels > 100)
        {
            this.energy = 100;
            System.out.println(this.name + " your energy levels are full.\n\r");
        }
        else
        {
            this.energy = newEnergyLevels;
            
            System.out.println(
                this.name + " your energy levels has been increased with " + increase + "%.\n\r" +
                "Now you have " + this.energy + "% energy.\n\r");
        }
    }

    /**
     * Decrease energy of this player.
     * 
     * @param decrease energy levels of this player
     */
    public void decreaseEnergy(int decrease)
    {
        isDecreaseValid(decrease);

        int newEnergyLevels = this.energy - decrease;

        if(newEnergyLevels < 20)
        {
            System.out.println("Energy levels are below 20 take an energy potion or an apple...");
        }

        if(newEnergyLevels <= 0)
        {
            this.energy = 0;
            System.out.println(
                this.name + ", you are out of energy!\n\r" +
                "You should find an energy potion or an apple" +
                "Every other action will decrease your health with 1%");
            
            // Decrease the health of this player
            this.health -= 1;
            System.out.println("Now you have " + this.health + "% health.\n\r");
        }
        else 
        {
            this.energy = newEnergyLevels;
            System.out.println(
                this.name + ", your energy levels has been decreased with " + decrease + "%.\n\r"+
                "Now you have " + this.energy + "% energy.\n\r");
        }
    }

    /**
     * @return score points of this player
     */
    public int getScore() 
    {
        return this.score;
    }

    /**
     * Player`s score can be increased from fights
     * 
     * @param increase the score of this player
     */
    public void increaseScore(int increase) 
    {
        isIncreaseValid(increase);
        
        this.score += increase;
        System.out.println("score: " + this.score);
    }

    /**
     * @return health levels of this player
     */
    public int getHealth() 
    {
        return this.health;
    }

    /**
     * Increases current health values of this player.
     * 
     * @param increase health of this player
     */
    public void increaseHealth(int increase) 
    {
        isIncreaseValid(increase);        

        int newHealthLevels = this.health + increase;

        if(newHealthLevels > this.maxHealthCapacity)
        {
            this.health = this.maxHealthCapacity;
            System.out.println(this.name + " your health is full.\n\r");
        }
        else
        {
            this.health = newHealthLevels;
            
            System.out.println(
                this.name + " your health has been increased with " + increase + ".\n\r" +
                "Now you have " + this.health + " HP.\n\r");
        }
    }

    /**
     * Increases current health values of this player.
     * 
     * @param decrease health of this player
     */
    public void decreaseHealth(int decrease) 
    {
        isDecreaseValid(decrease);

        int newHealthLevels = this.health - decrease;

        if(newHealthLevels <= 0)
        {
            System.out.println(this.name + " , you died in a cruel fight...\n\r");
            System.out.println("GAME OVER");
            System.out.println("Score: " + this.score);
        }
        else 
        {
            this.health = newHealthLevels;
            
            System.out.println(
                this.name + " , after a fight with monster\n\r"+
                "your health has decreased with " + decrease + "%.\n\r"+
                "Now your health is " + this.health + "%.\n\r");
        }
    }

    /**
     * Increase the maximum health of this player
     * 
     * @param increase the amount to be increased with
     */
    public void increaseHealthCapacity(int increase)
    {
        this.maxHealthCapacity += increase;
        System.out.println("Your max health capacity is " + this.maxHealthCapacity);
    }

    /**
     * @return inventory of this player
     */
    public Inventory getInventory()
    {
        return this.inventory;
    }

    /**
     * Adds a new item in the player`s inventory.
     * If the item is potion it will be applied 
     * to the player and will not be added into
     * the inventory. Same action would be taken
     * for apple item.
     * 
     * @param item new item to be added in the inventory
     */
    public void addItem(Item item)
    {
        if(item instanceof Potion)
        {
            Potion potion = (Potion)item;

            if(potion.getType().equals(PotionType.HP))
            {
                increaseHealth(item.getPoints());
            }
            else if(potion.getType().equals(PotionType.ENERGY))
            {
                increaseEnergy(item.getPoints());
            }
        }
        else if(item instanceof Apple)
        {
            increaseHealth(item.getPoints());
            increaseEnergy(item.getPoints());
        }
        else if(item instanceof Shield)
        {
            this.inventory.equipShield(item);
        }
        else
        {
            this.inventory.equipWeapon(item);
        }
    }

    /**
     * @return attack points of this player
     */
    public int getAttackPoints()
    {
        return this.attack;
    }

    /**
     * Set attack points of this player depending
     * on the equiped weapon/s.
     * 
     * @param points that would be player`s attack 
     */
    public void setAttackPoints(int points) 
    {
        this.attack = points;
        System.out.println(this.name + ", your attack points are " + this.attack);
	}

    /**
     * Checks is the increase value meets the requirements
     * 
     * @exception IllegalArgumentException is thrown 
     * if increase value is less than or equal to zero
     * 
     * @param increase value of health, energy or score
     */
    private void isIncreaseValid(int increase)
    {
        if(increase <= 0)
        {
            throw new IllegalArgumentException("Increase value cannot be equal or less than zero!");
        }
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