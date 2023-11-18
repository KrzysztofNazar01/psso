public class TimingLocal extends Local{
    protected long startTime;

    protected long stopTime;

    public TimingLocal(TimingCustomer callingCustomer, TimingCustomer receiver) {
        super(callingCustomer, receiver);
    }

    public long getTime() {
        return (stopTime - startTime) / 1000000000;
    }

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
        ((TimingCustomer) caller).addCharge(getTime(), Billing.LOCAL_RATE);

    }
}
