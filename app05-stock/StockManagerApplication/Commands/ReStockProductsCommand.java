package StockManagerApplication.Commands;

import StockManagerApplication.*;

/**
 * The command for re-stock all the low stock items up to a set minimum level
 * 
 * @author Yavor Yankov
 * @version 19/11/2020
 */
public class ReStockProductsCommand implements Command 
{
    // The stock manager of the Stock Management Application
    private StockManager manager;

    /**
     * The constructor of this command
     * 
     * @param manager The manager which is the reciever in the Command Design Pattern
     */
    public ReStockProductsCommand(StockManager manager) 
    {
        this.manager = manager;
    }

    /**
     * Execute this command as re-stock all the low stock items up to a set minimum level
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        manager.restockLowStockLevelProducts();
    }
}