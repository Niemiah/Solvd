package com.solvd.hospital.connections;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Connection implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(Connection.class);
    private int connectionId;

    public Connection(int connectionId) {
        this.connectionId = connectionId;
    }

    public void run() {
        LOGGER.info("Connection " + connectionId + " is currently being utilized.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Connection " + connectionId + " is now ready for use.");
    }
}
