package StockManagerApplication.Commands;

/**
 * The command exits current program by 
 * terminating running Java virtual machine.
 * 
 * @author Yavor Yankov
 * @version 19/11/2020
 */
public class QuitCommand implements Command
{
    /**
     * Execute this command as invoke System.exit method that
     * terminating running Java virtual machine.
     */
    @Override
    public void execute() 
    {
        System.exit(0);
    }
}