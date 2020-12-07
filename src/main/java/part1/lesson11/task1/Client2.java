package part1.lesson11.task1;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Client2   {
    static String clientName;
    static Socket clientSocket;
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader stdIn;

    public static void main(String[] args) throws IOException {

        clientSocket = new Socket("localhost", 5555);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        MessageClient messageClient = new MessageClient();
        String name = readName();
        messageClient.setName(name);


        new Thread() {
            @Override
            public void run() {
                while(true) {

                    try {
                        String mesage = in.readLine();
                        System.out.println(mesage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        while(true) {
            System.out.println("Введите ваше сообщение");
            String userMessage = stdIn.readLine();
            if (userMessage.equals("exit")){
                break;
            }
            else {
                messageClient.setMessage(userMessage);
                out.write(messageClient + "\n");
                out.flush();
            }

        }


    }


    private static String readName() throws IOException {
        System.out.print("Пожалуйста введите имя: ");
        clientName = stdIn.readLine();
        return clientName;
    }

}
