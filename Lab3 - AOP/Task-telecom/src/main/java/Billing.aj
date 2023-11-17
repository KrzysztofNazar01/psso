/**
 * The Billing aspect deals with... billing.
 * How much money did each connection cost?
 * How much money did each call cost?
 * How much money is being debited to a customer?
 * This aspect can be used by other parts of the system. (not in this example)
 *
 * Billing can depend many things, such as timing, the type of the connection,
 * some special discounts the customer has, special features, etc. In here,
 * it depends only on timing and on the type of the connection.
 */
public aspect Billing {
    // precedence required to get advice on endtiming in the right order
    declare precedence: Billing, Timing; //Najpierw idzie Billing before, potem Timing Before, potem Timing After i na koniec Billing after

    public static final long LOCAL_RATE = 3;
    public static final long LONG_DISTANCE_RATE = 10;

    /**
     * Connections give the appropriate call rate
     */
    public abstract long Connection.callRate();
    public long LongDistance.callRate() { return LONG_DISTANCE_RATE; }
    public long Local.callRate() { return LOCAL_RATE; }

    /**
     * When timing stops, calculate and add the charge from the
     * connection time
     */
    after(Connection conn): Timing.endTiming(conn) {
    	long time = conn.getTimer().getTime();
        long rate = conn.callRate();
        long cost = rate * time;
        conn.getCaller().addCharge(cost);
    }

    /**
     * Customers have a bill paying aspect with state
     */
    private long Customer.totalCharge = 0;
    public long Customer.getTotalCharge() { return totalCharge; }

    public void Customer.addCharge(long charge){
        totalCharge += charge;
    }
}