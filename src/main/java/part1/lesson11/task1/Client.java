package part1.lesson11.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {


        System.out.println("Старт подключения");
        Socket socket = new Socket("localhost", 4999);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                ));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(
                             socket.getOutputStream()
                     ), true
             );
        Scanner scanner = new Scanner(System.in)){
            while(true) {
                final String line = scanner.nextLine();
                if ("end".equals(line))
                    break;

                String name = scanner.nextLine();
                String text = scanner.nextLine();
                MessageClient messageClient = new MessageClient(name, text);
                out.println(messageClient);

                System.out.println("Ответ от сервера: " + br.readLine());
            }


        }

    }
}
