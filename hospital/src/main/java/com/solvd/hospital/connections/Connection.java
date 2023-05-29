package com.solvd.hospital.connections;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Connection {

    private static final Logger LOGGER = LogManager.getLogger(Connection.class);
    private int connectionId;

    public Connection(int connectionId) {
        this.connectionId = connectionId;
    }

    public int getConnectionId() {
        return connectionId;
    }
}
