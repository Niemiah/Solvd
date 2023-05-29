package com.solvd.hospital.connections;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.concurrent.*;


public class ThreadMain {

    private static final Logger LOGGER = LogManager.getLogger(ThreadMain.class);
    private static int nextConnectionId = 1;
    public static synchronized int getNextConnectionId() {
        return nextConnectionId++;
    }
    public static void main(String[] args) {
        final int maxConnections = 5;
        final int totalThreads = 7;
        int waitingThreads = totalThreads - maxConnections;

        ConnectionPool connectionPool = ConnectionPool.getInstance(maxConnections);
        ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);


        for (int i =0; i< maxConnections; i++) {
            Connection connection = connectionPool.getConnection();
            executorService.execute(new ConnectionUser(connection));
        }

        for (int i =0; i< waitingThreads; i++) {
            LOGGER.info("Thread " + i + " is waiting for a connection.");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i= maxConnections; i< totalThreads; i++) {
            Connection connection = connectionPool.getConnection();
            executorService.execute(new ConnectionUser(connection));
        }
    }
}
