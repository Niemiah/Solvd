package com.solvd.hospital.connections;
import java.util.concurrent.*;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final ExecutorService executorService;
    private final int maxConnections;

    private ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.executorService = Executors.newFixedThreadPool(maxConnections);
    }

    public static synchronized ConnectionPool getInstance(int maxConnections) {
        if (instance == null) {
            instance = new ConnectionPool(maxConnections);
        }
        return instance;
    }

    public Connection getConnection() {
        return new Connection(ThreadMain.getNextConnectionId());
    }

    public int getMaxConnections() {
            return maxConnections;
    }

}
