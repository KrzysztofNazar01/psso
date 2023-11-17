public class TimingCall extends Call{

    /**
     * Create a new call connecting caller to receiver
     * with a new connection. This should really only be
     * called by Customer.call(...)
     *
     * @param caller
     * @param receiver
     */
    public TimingCall(TimingCustomer caller, TimingCustomer receiver) {
        super(caller, receiver);
        Connection c;
        if (receiver.localTo(caller)) {
            c = new TimingLocal(caller, receiver);
        } else {
            c = new TimingLongDistance(caller, receiver);
        }
        connections.addElement(c);
    }
}
