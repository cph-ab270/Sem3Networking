package org.cba.networking.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by adam on 27/09/2017.
 */
public class EchoServer {
    private static int port = 1234;
    private static String ip = "localhost";
    private static ServerSocket ss;

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            port = Integer.parseInt(args[0]);
            ip = args[1];
        }
        ss = new ServerSocket(port);
        System.out.println("Waiting for clients");
        int i = 0;
        while (true) {
            Socket client = ss.accept();
            String name = "User" + i++;
            System.out.println("Client "+name+" connected");
            Thread thread = new Thread(new EchoClientHandler(client, name));
            thread.start();
        }
    }
}
