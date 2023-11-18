public class TimingCustomer extends Customer{

    private long totalConnectTime;
    private long totalCharge;

    /**
     * Calculate connection time and charge
     * for a call made by the customer.
     */
    public TimingCustomer(String name, int areaCode) {
        super(name, areaCode);
        totalConnectTime = 0;
        totalCharge = 0;
    }

    public TimingCall call(TimingCustomer receiver) {
        TimingCall timingCall = new TimingCall(this, receiver);
        addCall(timingCall);
        return timingCall;
    }

    public long getTotalConnectTime() {
        return totalConnectTime;
    }
    public void addConnectTime(long connectionTime) {
        totalConnectTime += connectionTime;
    }

    public long getTotalCharge() {
        return totalCharge;
    }
    public void addCharge(long connectionTime, Integer cost) {
        totalCharge += cost * connectionTime;
    }
}
