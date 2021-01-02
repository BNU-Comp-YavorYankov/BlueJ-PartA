package main.models;

import java.util.concurrent.TimeUnit;

public class Arena 
{
    private Player player;   // player of this game
    private Monster monster; // opponent of the player

    public Arena(Player player, Monster monster) 
    {
        this.player = player;
        this.monster = monster;
        
        fight();
    }

    /**
     * Fight between the player and monster
     * while one of them is defeated.
     */
    private void fight() 
    {
        try 
        {
            while(true)
            {
                this.monster.decreaseHealth(this.player.getAttackPoints());
                if(this.monster.getHealth() == 0)
                {
                    this.player.increaseScore(50);
                    
                    System.out.println(
                        this.player.getName() + ", you defeated " + 
                        this.monster.getName());
                    System.out.println("You won the game with score " + this.player.getScore() +"!!!");
                    break;
                }

                this.player.decreaseHealth(this.monster.getAttack());
                if(this.player.getHealth() == 0)
                {
                    System.out.println(
                        this.player.getName() + 
                        ", you died in a cruel fight...\n\r");
                    System.out.println("GAME OVER");
                    System.out.println("Score: " + this.player.getScore());

                    break;
                }
                TimeUnit.SECONDS.sleep(1);
            }         
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
