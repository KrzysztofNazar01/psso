public class TimingLocal extends Local{
    protected long startTime;

    protected long stopTime;

    public TimingLocal(TimingCustomer caller, TimingCustomer receiver) {
        super(caller, receiver);
    }

    public long getTime() {
        return (stopTime - startTime) / 1000000000;
    }

    @Override
    void complete() {
        super.complete();
        startTime = System.nanoTime();
    }

    @Override
    void drop() {
        super.drop();
        stopTime = System.nanoTime();

        ((TimingCustomer) caller).addConnectTime(getTime());
        ((TimingCustomer) receiver).addConnectTime(getTime());
        ((TimingCustomer) caller).addCharge(getTime(), Billing.LOCAL_RATE);

    }
}
