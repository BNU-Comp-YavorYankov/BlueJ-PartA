import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @modified by Yavor Yankov
 * @version 03/11/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    // The random generator.
    private Random random;
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        this.random = new Random();

        manager.addProduct(new Product(101, "Samsung Galaxy S20"));
        manager.addProduct(new Product(102, "Apple iPhone 12"));
        manager.addProduct(new Product(103, "Google Pixel 4A"));
        manager.addProduct(new Product(104, "Sony Xperia 1 ||"));
        manager.addProduct(new Product(105, "Samsung Note 9"));
        manager.addProduct(new Product(106, "OnePlus 8 Pro"));
        manager.addProduct(new Product(107, "Samsung Galaxy Note 20 Ultra"));
        manager.addProduct(new Product(108, "Motorola Edge Plus"));
        manager.addProduct(new Product(109, "Xiaomi Mi Note 10"));
        manager.addProduct(new Product(110, "Apple iPhone SE"));
        manager.addProduct(new Product(110, "A duplicate Id"));
        manager.addProduct(new Product(111, "Apple iPhone SE"));
    }
    
    /**
     * Provide a demonstration of how the StockManager meets all
     * the user requirements by making a delivery of each product 
     * re-stocking it by various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        manager.printAllProducts();

        demoDeliverProducts();

        demoSellProducts();

        demoRenameProduct();

        demoRemoveProduct();

        demoPrintAllProducts();

        demoPrintProductsWithPartName();

        demoPrintProductsWithLowStockLevel();
    }

    /**
     * Demonstrate delivery of products.
     */
    private void demoDeliverProducts()
    {
        System.out.println();
        System.out.println("Delivery:");
        // Show details of all of the products before delivery.
        for(int productId = 101; productId <= 110; productId++)
        {
            // Print the product before delivery
            manager.printProduct(productId);
            
            // Generate a number between 1 and 10
            int amount = random.nextInt(10) + 1;

            manager.delivery(productId, amount);

            // Print the product after delivery
            manager.printProduct(productId);

            System.out.println();
        }

        // Testing non existing Id
        manager.delivery(10, 5);

        // Testing amount less than zero
        manager.delivery(101, -1);
    }

    /**
     * Demonstrate selling of products.
     */
    private void demoSellProducts()
    {
        System.out.println();
        System.out.println("Selling products:");
        // Show details of all of the products before delivery.
        for(int productId = 101; productId <= 110; productId++)
        {
            // Print the product before being sold
            manager.printProduct(productId);
             
            // Generate a number between 1 and 10
            int amount = random.nextInt(10) + 1;
            
            manager.sellProduct(productId, amount);
 
            System.out.println();
        }
    }

    /**
     * Demonstrate renaming of a product 
     */
    private void demoRenameProduct()
    {
        String newProductName = "New Product Name";

        manager.renameProduct(101, newProductName);
        
        // Testing: new name length with less than 5 symbols
        newProductName = "None";
        manager.renameProduct(101, newProductName);

        // Print out the renamed product details
        manager.printProduct(101);

        System.out.println();
    }
    
    /**
     * Demonstrate removing of a product
     */
    private void demoRemoveProduct()
    {
        // Delete the product
        manager.deleteProduct(101);

        // Try to print out the deleted product details
        manager.printProduct(101);

        System.out.println();
    }

    /**
     * Print out all products
     */
    private void demoPrintAllProducts()
    {
        manager.printAllProducts();
        
        System.out.println();
    }

    /**
     * Print products based on part of the product name
     */
    private void demoPrintProductsWithPartName()
    {
        manager.printProductsWithPartName("Apple");

        // Testing: non existing word
        manager.printProductsWithPartName("Not Exists");
        
        System.out.println();
    }

    /**
     * Print products with low stock level
     */
    private void demoPrintProductsWithLowStockLevel()
    {
        manager.printLowStockLevelProducts();
    }
}