package com.stealthcopter.networktools.ping;

import java.net.InetAddress;

/**
 * Created by mat on 09/12/15.
 */
public class PingStats {
    private final InetAddress ia;
    private final long noPings;
    private final long packetsLost;
    private final float averageTimeTaken;
    private final float medianTimeTaken;
    private final float minTimeTaken;
    private final float maxTimeTaken;
    private final boolean isReachable;

    public PingStats(InetAddress ia, long noPings, long packetsLost, float totalTimeTaken, float minTimeTaken, float maxTimeTaken, float medianTimeTaken) {
        this.ia = ia;
        this.noPings = noPings;
        this.packetsLost = packetsLost;
        long packetsDelivered = noPings - packetsLost;
        this.isReachable = packetsDelivered > 0;
        this.averageTimeTaken = (this.isReachable ? totalTimeTaken / packetsDelivered : -1);
        this.minTimeTaken = minTimeTaken;
        this.maxTimeTaken = maxTimeTaken;
        this.medianTimeTaken = medianTimeTaken;
    }

    public InetAddress getAddress() {
        return ia;
    }

    public long getNoPings() {
        return noPings;
    }

    public long getPacketsLost() {
        return packetsLost;
    }

    public float getMedianTimeTaken() {
        return medianTimeTaken;
    }

    public float getAverageTimeTaken() {
        return averageTimeTaken;
    }

    public float getMinTimeTaken() {
        return minTimeTaken;
    }

    public float getMaxTimeTaken() {
        return maxTimeTaken;
    }

    public boolean isReachable() {
        return isReachable;
    }

    public long getAverageTimeTakenMillis() {
        return (long) (averageTimeTaken * 1000);
    }

    public long getMinTimeTakenMillis() {
        return (long) (minTimeTaken * 1000);
    }

    public long getMaxTimeTakenMillis() {
        return (long) (maxTimeTaken * 1000);
    }

    @Override
    public String toString() {
        return "PingStats{" +
                "ia=" + ia +
                ", noPings=" + noPings +
                ", packetsLost=" + packetsLost +
                ", medianTimeTaken=" + medianTimeTaken +
                ", averageTimeTaken=" + averageTimeTaken +
                ", minTimeTaken=" + minTimeTaken +
                ", maxTimeTaken=" + maxTimeTaken +
                '}';
    }
}
