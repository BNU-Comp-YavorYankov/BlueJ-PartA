
/**
 * Program class is the starting point of the Product Stock Application.
 * It create an object of the StockApp class 
 * and invokes the run method of the StockApp class. 
 *
 * @author Yavor Yankov
 * @version 19/11/2020
 */
public class Program
{
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
