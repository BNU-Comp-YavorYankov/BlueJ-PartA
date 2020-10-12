import java.util.ArrayList;

/**
 * TicketMachine models a ticket machine that issues flat-fare tickets. The
 * price of a ticket is specified via the constructor. Instances will check to
 * ensure that a user only enters sensible amounts of money, and will only print
 * a ticket if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 *          Modified by Yavor Yankov
 * @version 10/10/2020
 */
public class TicketMachine {
    // Constant fields for different destinations
    private static final Ticket AMERSHAM_TICKET = new Ticket(Destination.Amersham);
    private static final Ticket AYLESBURY_TICKET = new Ticket(Destination.Aylesbury);
    private static final Ticket HIGH_WYCOMBE_TICKET = new Ticket(Destination.HighWycombe);

    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // Selected tickets by the customer.
    private ArrayList<Ticket> selectedTickets;
    // Last selected ticket. Every time if there is more tickets they will be
    // assigned to this field after printing the last one from the tickets collection.
    // If there is no more tickets this field will be set to null.
    private Ticket lastSelectedTicket;

    /**
     * Create a machine that issues tickets.
     */
    public TicketMachine() {
        printAllAvailableTickets();
        balance = 0;
        total = 0;
        this.selectedTickets = new ArrayList<Ticket>();
    }

    /**
     * Return The amount of money already inserted for the next ticket.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Return total money collected by this ticket machine
     */
    public int getTotal(){
        return this.total;
    }

    /**
     * Return the selected tickets collection
     */
    public ArrayList<Ticket> getSelectedTickets(){
        return this.selectedTickets;
    }

    /**
     * Return the last selected ticket 
     */
    public Ticket getLastSelectedTicket(){
        return this.lastSelectedTicket;
    }

    /**
     * Receive an amount of money from a customer. Accepted coins are p10, p20,
     * p100, p200
     */
    public void insertMoney(Coin coin) {
        if (this.selectedTickets.size() != 0) {
            switch (coin.getValue()) {
                case 10:
                    balance = balance + coin.getValue();
                    break;
                case 20:
                    balance = balance + coin.getValue();
                    break;
                case 100:
                    balance = balance + coin.getValue();
                    break;
                case 200:
                    balance = balance + coin.getValue();
                    break;
                default:
                    System.out.println("Invalid coin!");
                    break;
            }

            // Print on the terminal inserted coin
            System.out.println("Insterted :" + coin.getValue() + " cents");
            // Print on the terminal current balance
            System.out.println("Balance :" + this.balance + " cents");

            printTicket();

        } else {
            System.out.println("There is no selected tickets. Please, select at least one ticket!");
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and reduce the current
     * balance by the ticket price. Print an error message if more money is
     * required.
     */
    public void printTicket() {
        if (balance >= this.lastSelectedTicket.getPrice()) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + this.lastSelectedTicket.getPurchasedDate());
            System.out.println("# Destination ");
            System.out.println("# " + this.lastSelectedTicket.getDestination());
            System.out.println("# " + this.lastSelectedTicket.getPrice() + " cents");
            System.out.println("##################");

            // Update the total collected with the price.
            total = total + this.lastSelectedTicket.getPrice();
            // Reduce the balance by the price.
            balance = balance - this.lastSelectedTicket.getPrice();

            removePrintedTicket();
            setLastTicket();

            if(this.lastSelectedTicket != null){
                System.out.println("You must insert at least: " + (this.lastSelectedTicket.getPrice() - balance) + " more cents to purchase your next selected ticket.");
            }            

        } else {
            System.out.println(
                    "You must insert at least: " + (this.lastSelectedTicket.getPrice() - balance) + " more cents.");
        }
    }

    /**
     * Return the money in the balance. The balance is cleared.
     */
    public int refundBalance() {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;

        System.out.println("Total collected " + this.total + " cents");

        // Print message on the Terminal, if there is an outstanding balance
        if (amountToRefund > 0) {
            System.out.println("Change " + amountToRefund + " cents");
        }

        return amountToRefund;
    }

    /**
     * Select ticket as recieve its destination`s name from the parameter
     */
    public void selectTicket(String destination) {
        // toLowerCase method set user`s input to be with lower case letters
        switch (destination.toLowerCase()) {
            case "aylesbury":
                this.selectedTickets.add(AYLESBURY_TICKET);
                setLastTicket();
                printSelectedTicketMessage();
                break;
            case "amersham":
                this.selectedTickets.add(AMERSHAM_TICKET);
                setLastTicket();
                printSelectedTicketMessage();
                break;
            case "high wycombe":
                this.selectedTickets.add(HIGH_WYCOMBE_TICKET);
                setLastTicket();
                printSelectedTicketMessage();
                break;
            /*
             * If the condition`s value does not match some of the above cases` values,
             * print on the Terminal a message
             */
            default:
                System.out.println("Selected ticket cannot be found!");
        }
    }

    /**
     * Set last selected ticket from the tickets collection
     */
    private void setLastTicket() {
        if (this.selectedTickets.size() != 0) {
            // get the last element of the tickets collection
            this.lastSelectedTicket = this.selectedTickets.get(this.selectedTickets.size() - 1);
        }
        else{
            this.lastSelectedTicket = null;
            refundBalance();
        }
    }

    /**
     * Remove the printed ticket from selectedTickets collection
     */
    private void removePrintedTicket() {
        this.selectedTickets.remove(this.lastSelectedTicket);
    }

    /**
     * Print the last selected ticket at the Terminal
     */
    private void printSelectedTicketMessage() {
        if (lastSelectedTicket != null) {
            System.out.println("Selected ticket: " + this.lastSelectedTicket);
            System.out.println("Please insert coins into the machine to purchase this ticket or select more tickets.");
        }
    }

    /**
     * Print all available tickets
     */
    private void printAllAvailableTickets() {
        System.out.println(" Available tickets and its prices.");
        System.out.println("+--------------------------------+");
        System.out.println("|1. " + AYLESBURY_TICKET);
        System.out.println("|2. " + AMERSHAM_TICKET);
        System.out.println("|3. " + HIGH_WYCOMBE_TICKET);
        System.out.println("+--------------------------------+");
        System.out.println(" Please, select one of the tickets as typing its destination.\n");
    }
}
