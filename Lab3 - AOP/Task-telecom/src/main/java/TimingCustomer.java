public class TimingCustomer extends Customer{

    private long totalConnectTime;
    private long totalCharge;
    public TimingCustomer(String name, int areacode) {
        super(name, areacode);
        totalConnectTime = 0;
        totalCharge = 0;
    }

    public TimingCall call(TimingCustomer receiver) {
        TimingCall timingCall = new TimingCall(this, receiver);
        addCall(timingCall);
        return timingCall;
    }

    public void addConnectTime(long connectionTime) {
        totalConnectTime += connectionTime;
    }
    public void addCharge(long connectionTime, Integer cost) {
        totalCharge += cost * connectionTime;
    }

    public long getTotalConnectTime() {
        return totalConnectTime;
    }
    public long getTotalCharge() {
        return totalCharge;
    }
}
