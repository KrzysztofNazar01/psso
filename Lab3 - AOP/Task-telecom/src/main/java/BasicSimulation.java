/**
 * This simulation subclass implements AbstractSimulation.run(..)
 * with  a test script for the telecom system with only the
 * basic objects.
 */
public class BasicSimulation extends AbstractSimulation {

    public static void main(String[] args){
        System.out.println("\n------Basic simulation------\n");
        simulation = new BasicSimulation();
        simulation.run();
    }

    protected void report(TimingCustomer c) {
        System.out.println(c + " has been connected for " + c.getTotalConnectTime() + " seconds");
    }

}
