import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ticket class represents a ticket in the ticket machine program. It keeps data
 * for destination, price and the date purchased.
 *
 * @author Yavor Yankov
 * @version 10/10/2020
 */
public class Ticket {
    // destination of this ticket
    private Destination destination;
    // price of this ticket based on the destination
    private int price;
    // date when this ticket has been purchased
    private Date datePurchased;

    /**
     * Constructor for objects of class Ticket with parameters for destination
     */
    public Ticket(Destination destination) {

        this.destination = destination;
        // new instance of Date class without any parameters is the current date
        this.datePurchased = new Date();
        // get the value of the destination which is the price of this ticket.
        this.price = destination.getPriceInPennies();
    }

    /**
     * Return the destionation of this ticket
     */
    public String getDestination() {
        return this.destination.getDestinationName();
    }

    /**
     * Return the price of this ticket
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Return the price of this ticket in pounds
     */
    private String getPriceInPounds(){
        // DecimalFormat class is used to format decimal numbers
        // The parameter represents the pattern 
        DecimalFormat df = new DecimalFormat("##.00");
        // format the price in pounds up to 2 digits after the point
        return df.format((this.price / 100d));
    }

    /**
     * Return the purchased date of this ticket in a format day/month/year
     */
    public String getPurchasedDate() {
        // date format day/month/year
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        
        // format the purchased date in dd/mm/yyyy and return the new date
        return dateFormat.format(this.datePurchased);
    }

    /**
     * Print on the Terminal this ticket
     */
    @Override
    public String toString()
    {
        return (this.destination.getDestinationName() + " costing £" + this.getPriceInPounds());
    }
}