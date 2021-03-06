package edu.bit.problemsolving.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @see <href>https://10kloc.wordpress.com/2013/03/03/java-multithreading-steeplechase-stopping-threads/</href>
 * Demonstrates non-standard thread cancellation.
 */
public class SocketCancellation {

    /**
     * Main entry point.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CancelleableSocketThread cst = new CancelleableSocketThread(8080);
        cst.start();
        Thread.sleep(3000);
        cst.interrupt();
    }

    /**
     * ServerSocket.accept() doesn't detect or respond to interruption. The class below overrides the
     * interrupt() method to support non-standard cancellation by canceling the underlying
     * ServerSocket forcing the accept() method to throw Exception, on which we act by breaking the
     * while loop.
     *
     * @author umermansoor
     */
    static class CancelleableSocketThread extends Thread {

        private final ServerSocket server;

        CancelleableSocketThread(int port) throws IOException {
            server = new ServerSocket(port);
        }

        @Override
        public void interrupt() {
            try {
                server.close();
            } catch (IOException ignored) {
            } finally {
                super.interrupt();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Socket client = server.accept();
                } catch (Exception se) {
                    break;
                }
            }
        }
    }
}
