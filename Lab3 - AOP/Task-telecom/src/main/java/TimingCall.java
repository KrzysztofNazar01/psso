// Represents a call with timing information
public class TimingCall extends Call {

    /**
     * Create a new call by connecting the caller to the receiver.
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
