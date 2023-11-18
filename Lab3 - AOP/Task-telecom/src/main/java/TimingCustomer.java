
// Represents a customer with timing and billing information
public class TimingCustomer extends Customer {

    private long totalConnectTime; // Total time connected in seconds
    private long totalCharge; // Total charge for calls

    /**
     * Calculate connection time and charge for a call made by the customer.
     */
    public TimingCustomer(String name, int areaCode) {
        super(name, areaCode);
        totalConnectTime = 0;
        totalCharge = 0;
    }

    // Initiates a call to a specified receiver
    public TimingCall call(TimingCustomer receiver) {
        TimingCall timingCall = new TimingCall(this, receiver);
        addCall(timingCall);
        return timingCall;
    }

    // Gets the total time connected
    public long getTotalConnectTime() {
        return totalConnectTime;
    }

    // Adds connection time to the total
    public void addConnectTime(long connectionTime) {
        totalConnectTime += connectionTime;
    }

    // Gets the total charge for calls
    public long getTotalCharge() {
        return totalCharge;
    }

    // Adds charge for a call to the total charge
    public void addCharge(long connectionTime, int cost) {
        totalCharge += cost * connectionTime;
    }
}