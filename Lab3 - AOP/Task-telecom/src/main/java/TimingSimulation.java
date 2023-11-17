/**
 * This simulation subclass implements AbstractSimulation.report(..)
 *
 */
public class TimingSimulation extends AbstractSimulation {

    public static void main(String[] args){
        System.out.println("\n... Timing simulation 2 ...\n");
        simulation = new TimingSimulation();
        simulation.run();
    }

    /**
     * Print a report of the connection time for customer
     */
    protected void report(Customer c){
        System.out.println(c + " has been connected for "
                + c.getTotalConnectTime()
                + " seconds");
    }

}
