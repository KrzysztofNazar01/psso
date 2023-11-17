/**
 * Simple timer machine used to record elapsed time
 */
public class Timer {
    protected long startTime;
    protected long stopTime;

    /**
     * set the start time
     */
    public void start() {
        startTime = System.currentTimeMillis();
        stopTime = startTime;
    }

    /**
     * set the end time
     */
    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    /**
     * set how much time passed between last start and stop?
     */
    public long getTime() {
        if(stopTime <= startTime) throw new RuntimeException("The timer has not been stopped");
        return (stopTime - startTime)/1000;
    }
}
