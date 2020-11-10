
/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @modified by Yavor Yankov
 * @version Change
 */
public class Product {
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product. The initial stock quantity is zero.
     * 
     * @param id   The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name) 
    {
        this.id = id;
        this.name = name;
        this.quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Set a name of this product
     * 
     * @param newName The new name of this product 
     */
    public void setName(String newName)
    {
        if(newName.length() < 5)
        {
            System.out.println("The product`s name cannot be less than 5 symbols!");
        }
        else
        {
            this.name = newName;
        }
    }

    /**
     * The quantity of this product.
     * 
     * @return The quantity in stock.
     */
    public int getQuantity() 
    {
        return quantity;
    }

    /**
     * Restock with the given amount of this product. 
     * The current quantity is incremented by the given amount.
     * 
     * @param amount The number of new items added to the stock. 
     * This must be greater than zero.
     */
    public void increaseQuantity(int amount) 
    {
        if (amount > 0) 
        {
            quantity += amount;
            System.out.println(amount + " " + this.name + " has been added on stock!");
        } 
        else 
        {
            System.out.println("Attempt to restock " + name + " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell given amount of these products. 
     * An error is reported if there appears to be no
     * stock or the requested amount is more than the amount on stock.
     * 
     * @param amount The amount of product to be sold.
     */
    public void sell(int amount) 
    {
        if (quantity > 0) 
        {
            if(amount < 0)
            {
                System.out.println("Amount cannot be less than zero!");
            }
            else if(amount <= quantity)
            {
                this.quantity -= amount;
                System.out.println(amount + " "+ this.name + " has been sold!");
            }
            else
            {
                System.out.println("The requested amount of products is more than the available quantity!");
            }
        } 
        else 
        {
            System.out.println("Attempt to sell an out of stock item: " + name);
        }
    }
    

    /**
     * Override toString method as return string with
     * particular pattern.
     * 
     * @return The id, name and quantity in stock.
     */
    @Override
    public String toString() 
    {
        return id + ": " + name + " stock level: " + quantity;
    }
}