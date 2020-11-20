package StockManagerApplication.Commands;

import StockManagerApplication.*;

/**
 * The command for printing all products on stock
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
 */
public class PrintAllProductsCommand implements Command 
{
    // The stock manager of the Stock Management Application
    private StockManager manager;

    /**
     * The constructor of this command
     * 
     * @param manager The manager which is the reciever in the Command Design Pattern
     */
    public PrintAllProductsCommand(StockManager manager) 
    {
        this.manager = manager;
    }

    /**
     * Execute this command as print all products on stock.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() {
        this.manager.printAllProducts();
    }
}
