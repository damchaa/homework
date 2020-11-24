package part1.lesson11.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SomeUser {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public SomeUser(Socket socket) {
        this.socket = socket;
    }
    public String getMessage(){
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            return message;
        }
        catch (Exception e){
            return "Не удалось получить";
        }
    }
    public void sendMessage(String message){
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(message);
            out.flush();
        }
        catch (Exception e){
            System.out.println("Не удалось отправить");
        }
    }
}
