/**
 * The Timing aspect is concerned with the duration
 * of connections and with customer's cumulative
 * connection time.
 */
public aspect Timing {

    /**
     * Every Customer has a total connection time
     */
    private long Customer.totalConnectTime = 0;

    public long Customer.getTotalConnectTime() {
        return totalConnectTime;
    }

    /**
     * Every connection has a timer
     */
    private Timer Connection.timer = new Timer();
    public Timer Connection.getTimer() { return timer; }

    /**
     * When to start the timer
     */
    pointcut startTiming(Connection c):
    	target(c) && call(void Connection.complete());

    /**
     * Start the timer when call completed
     */
    after (Connection c): startTiming(c) {
    	c.getTimer().start();
    }

    /**
     * When to stop the timer
     */
    pointcut endTiming(Connection c):
    	target(c) && call(void Connection.drop());

    /**
     * Stop the timer when call dropped and update the involved parties
     */
    after(Connection c): endTiming(c) {
    	Timer timer = c.getTimer();
    	timer.stop();
        c.getCaller().totalConnectTime += timer.getTime();
        c.getReceiver().totalConnectTime += timer.getTime();
    }
}
