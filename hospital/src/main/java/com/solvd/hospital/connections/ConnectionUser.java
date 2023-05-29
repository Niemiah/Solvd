package com.solvd.hospital.connections;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

class ConnectionUser implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionUser.class);
    private Connection connection;

    public ConnectionUser(Connection connection) {
        this.connection = connection;
}
    public void run() {
        LOGGER.info("Connection " + connection.getConnectionId() + " is currently being utilized.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Connection " + connection.getConnectionId() + " is now ready for use.");
    }
}