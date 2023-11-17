public abstract class AbstractSimulation {

    public static AbstractSimulation simulation;

    /**
     * Creates objects and puts them to work.
     */
    public void run() {
        TimingCustomer jim = new TimingCustomer("Jim", 650);
        TimingCustomer mik = new TimingCustomer("Mik", 650);
        TimingCustomer crista = new TimingCustomer("Crista", 415);

        say("jim calls mik...");
        Call c1 = jim.call(mik);
        wait(1);
        say("mik accepts...");
        mik.pickup(c1);
        wait(4);
        say("jim hangs up...");
        jim.hangup(c1);

        say("jim calls crista...");
        Call c2 = jim.call(crista);
        say("crista accepts...");
        crista.pickup(c2);
        wait(2);
        say("crista hangs up...");
        crista.hangup(c2);

        Call c3 = crista.call(mik);
        mik.pickup(c3);
        wait(2);
        mik.hangup(c3);

        report(jim);
        report(crista);
        report(mik);
    }

    /**
     * Print a report of the connection time for customer
     */
    abstract protected void report(TimingCustomer c);

    protected static void wait(int seconds) {
        Object dummy = new Object();
        synchronized (dummy) {
            try {dummy.wait(seconds* 1000L); }
            catch (Exception ignored) {}
        }
    }

    /**
     * Put a message on standard output
     */
    protected static void say(String s){
        System.out.println(s);
    }

}
