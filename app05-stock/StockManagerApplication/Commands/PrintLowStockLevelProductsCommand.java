package StockManagerApplication.Commands;

/**
 * The command for printing all products whose stock levels are low
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
 */
public class PrintLowStockLevelProductsCommand implements Command
{
    // The stock manager of the Stock Management Application
    private StockManager manager;

    /**
     * The constructor of this command
     * 
     * @param manager The manager which is the reciever in the Command Design Pattern
     */
    public PrintLowStockLevelProductsCommand(StockManager manager) {
        this.manager = manager;
    }

    /**
     * Execute this command as print a list of products with low stock level.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        manager.printLowStockLevelProducts();
    }
    
}
