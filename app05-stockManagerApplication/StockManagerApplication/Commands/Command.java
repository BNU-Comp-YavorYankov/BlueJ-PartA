package StockManagerApplication.Commands;

/**
 * Command interface is a contract for the inherited classes.
 * 
 * @author Yavor Yankov
 * @version 20/11/2020
 */
public interface Command 
{
    /**
     * Abstract method which must be included in the inherited classes as being overridden
     */
    public void execute();
}