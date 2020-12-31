package main;

import java.util.HashMap;
import main.commands.*;
import main.utilities.InputReader;

/**
 * CommandInvoker checks user input against the known commands, 
 * and if the input is not one of the known commands, 
 * it prints out an error message.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class CommandInvoker 
{
    /**
     * All commands which can be executed 
     * @key Keeps the name of the command
     * @value Keeps the command class
     */
    private static final HashMap<String,Command> COMMANDS = new HashMap<>();

    private InputReader reader; // user input source
    private Game game;          // the new game instance

    /**
     * The constructor of this command invoker class
     * which adds the known commands into the commands collection.
     * Also, it initializes the game.
     */
    public CommandInvoker() 
    {
        this.reader = new InputReader();
        this.game = new Game();
        
        seedAvailableCommands();
    }

    /**
     *  Main play routine. Loops until end of play.
     *  Add new player into the game.
     */
    public void run() 
    {            
        this.game.printWelcome();

        addPlayer();

        this.game.printCurrentLocationLongDescription();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the user run quit command and confirm it.
        while (true) 
        {
            String userCommand = reader.getString();
            System.out.println();
            execute(userCommand);
        }
    }

    /**
     * Execute the command based on the user input.
     * 
     * The way it works is: Recieve the user input
     * and gets all the words in its input.
     * If there is a second word it will be set to direction field.
     * It gets the command from the commands collection,
     * if command exists it will be executed,
     * if no it prints out an error message.
     * 
     * @param userInput The user input which will execute a command.
     */
    private void execute(String userInput) 
    {
        /**
         * Firts index is the command.
         * Second item is additional value such as direction.
         */
        String[] userInputWords = userInput.split(" ");

        Command command = COMMANDS.get(userInputWords[0]);

        if(command == null)
        {
            System.out.println("I don't know what you mean...");
        }
        else
        {
            // If the user command is 'go' and there is more than one word
            if(userInputWords[0].equals("go") && userInputWords.length > 1)
            {
                //Gets the go command from commands collection
                command = COMMANDS.get("go");

                /**
                 * Cast command interface to GoCommand child class
                 * and set direction from second word of the user input.
                 */ 
                ((GoCommand) command).setDirection(userInputWords[1]);
            }
            // If the user command is 'pick' and there is more than one word
            else if(userInputWords[0].equals("pick") && userInputWords.length > 1)
            {
                //Gets the pick command from commands collection
                command = COMMANDS.get("pick");

                /**
                 * Cast command interface to PickCommand child class
                 * and set the item name from second word
                 * of the user input.
                 */
                 ((PickCommand) command).setItem(userInputWords[1]);
            }
            command.execute();
        }
    }
    
    /**
     * Add all available commands in the commands collection
     */
    private void seedAvailableCommands() 
    {
        COMMANDS.put("go", new GoCommand(this.game));
        COMMANDS.put("pick", new PickCommand(this.game));
        COMMANDS.put("map", new PrintMapCommand(this.game));
        COMMANDS.put("help", new HelpCommand(COMMANDS.values(), this.game));
        COMMANDS.put("quit", new QuitCommand());
    }

    /**
     * Add new player into the game as
     * creates new AddPlayerCommand and executes it.
     */
    private void addPlayer()
    {
        Command command = new AddPlayerCommand(this.game);
        command.execute();        
    }
}