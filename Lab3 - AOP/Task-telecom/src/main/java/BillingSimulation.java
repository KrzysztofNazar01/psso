public class BillingSimulation extends AbstractSimulation {

    public static void main(String[] args){
        System.out.println("\n... Billing simulation 2 ...\n");
        simulation = new BillingSimulation();
        simulation.run();
    }

    /**
     * Print a report of the connection time and the bill for customer
     */
    protected void report(TimingCustomer c){
        System.out.println(c + " has been connected for "
                + c.getTotalConnectTime()
                + " seconds and has a bill of "
                + c.getTotalCharge());
    }
}
