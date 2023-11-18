// Represents a long-distance connection with timing information
public class TimingLongDistance extends LongDistance {

    protected long startTime; // Start time of the connection
    protected long stopTime; // Stop time of the connection

    public TimingLongDistance(TimingCustomer caller, TimingCustomer receiver) {
        super(caller, receiver);
    }

    // Gets the time difference between stopTime and startTime in seconds
    public long getTime() {
        // Get the time in nanoseconds
        long elapsedTime = stopTime - startTime;

        // Convert nanoseconds to seconds
        long seconds = elapsedTime / 1_000_000_000;

        return seconds;
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

        // Add charge for the call to both caller and receiver
        ((TimingCustomer) caller).addCharge(getTime(), Billing.LONG_DISTANCE_RATE);
        ((TimingCustomer) receiver).addCharge(getTime(), Billing.LONG_DISTANCE_RATE);
    }
}