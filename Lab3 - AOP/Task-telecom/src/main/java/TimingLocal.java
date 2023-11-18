
// Represents a local connection with timing information
public class TimingLocal extends Local {

    protected long startTime; // Start time of the connection
    protected long stopTime; // Stop time of the connection

    public TimingLocal(TimingCustomer callingCustomer, TimingCustomer receiver) {
        super(callingCustomer, receiver);
    }

    // Gets the time difference between stopTime and startTime in seconds
    public long getTime() {
        return (stopTime - startTime) / 1_000_000_000;
    }

    // Completes the connection and sets the start time
    @Override
    void complete() {
        super.complete();
        startTime = System.nanoTime();
    }

    // Drops the connection and updates connection time and charge
    @Override
    void drop() {
        super.drop();
        stopTime = System.nanoTime();

        // Update total connect time for both caller and receiver
        ((TimingCustomer) caller).addConnectTime(getTime());
        ((TimingCustomer) receiver).addConnectTime(getTime());

        // Add charge for the call to the caller
        ((TimingCustomer) caller).addCharge(getTime(), Billing.LOCAL_RATE);
    }
}
