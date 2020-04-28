package com.mycompany.serverapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mikyqwe
 */
class ClientThread extends Thread {

    private Socket socket = null;
    private ServerSocket serverSocket = null;

    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true) {
                String request = in.readLine();
                String raspuns = null;
                if (request.equals("stop"))//inchidem sv si client
                {
                    raspuns = "Server Stop";
                    out.println(raspuns);
                    out.flush();
                    serverSocket.close();
                    break;
                } else if (request.equals("exit")) //inchidem doar client
                {
                    break;
                }
                out.println("Server recieved a request " + request);
                out.flush();

            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
