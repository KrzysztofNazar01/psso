public class TimingLongDistance extends LongDistance{
    protected long startTime;

    protected long stopTime;

    public TimingLongDistance(TimingCustomer caller, TimingCustomer receiver) {
        super(caller, receiver);
    }

    public long getTime() {
        // Get the time in nanoseconds
        long elapsedTime = stopTime - startTime;

        // Convert nanoseconds to seconds
        long seconds = elapsedTime / 1_000_000_000;

        return seconds;
    }

    // Complete connection and set start time of connection
    @Override
    void complete() {
        super.complete();
        startTime = System.nanoTime();
    }

    /**
     * Drop connection and update connection time and charge.
     */
    @Override
    void drop() {
        super.drop();
        stopTime = System.nanoTime();
        ((TimingCustomer) caller).addConnectTime(getTime());
        ((TimingCustomer) receiver).addConnectTime(getTime());
        ((TimingCustomer) caller).addCharge(getTime(), Billing.LONG_DISTANCE_RATE);
        ((TimingCustomer) receiver).addCharge(getTime(), Billing.LONG_DISTANCE_RATE);
    }
}
