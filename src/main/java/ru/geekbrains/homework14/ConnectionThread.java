package ru.geekbrains.homework14;

import java.io.*;
import java.net.Socket;

public class ConnectionThread extends Thread {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public ConnectionThread(Socket socket) throws IOException {
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            start();
        }
        @Override
        public void run() {
            String word;
            try {
                while (true) {
                    word = in.readUTF();
                    if(word.equals("stop")) {
                        break;                }
                    for (ConnectionThread vr : MultiThreadTCPServer.serverList) {
                        vr.send(word); // отослать принятое сообщение с
                        // привязанного клиента всем остальным включая его
                    }
                }
            } catch (IOException e) {
            }
        }

        private void send(String msg) {
            try {
                out.writeUTF(msg + "\n");
            } catch (IOException ignored) {}
        }
    }


