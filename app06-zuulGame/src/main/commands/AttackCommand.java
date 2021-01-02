package main.commands;

import main.Game;
import main.models.Arena;
import main.models.Monster;
import main.models.Player;

/**
 * The command attack the boss in the game. If the player is not in the dungeon
 * prints out message. If the player win the fight the game is won. Else the
 * game is over and the player is defeated.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class AttackCommand implements Command 
{    
    private Game game; // instance of this game

    /**
     * The constructor of this command which initialize InputReader
     */
    public AttackCommand(Game game) 
    {
        this.game = game;
    }

    /**
     * Execute this command as attack a monster if there is so.
     */
    @Override
    public void execute() 
    {
        Monster monster = this.game
            .getCurrentLocation()
            .getBoss();

        if(monster == null)
        {
            System.out.println("There is no monsters in this location!");
        }
        else
        {
            Player player = this.game.getPlayer();
            
            new Arena(player, monster);
        }
    }

    /**
     * @return description of this command
     */
    @Override
    public String toString()
    {
        return "attack - attack a monster";
    }
}
