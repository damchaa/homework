package part1.lesson11.task2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.Socket;

public class SomeUser extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    private MessageClient messageClient;
    private Gson gson = new Gson();
    JsonParser jsonParser = new JsonParser();


    SomeUser(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        start();
    }

    public void run() {
        try {
            while(true) {
                String clientMessage = in.readLine();
                System.out.println(clientMessage);
                // MessageClient messageClient = gson.fromJson(clientMessage,MessageClient.class);
                Object ob = jsonParser.parse(clientMessage);
                System.out.println(ob);

                JsonObject jsonObject = (JsonObject) ob;
                 messageClient = new MessageClient();
                 name = jsonObject.get("name").toString();
                messageClient.setGetter(jsonObject.get("getter").toString());
                messageClient.setName(jsonObject.get("name").toString());
                messageClient.setMessage(jsonObject.get("message").toString());
                if (messageClient.getGetter().equals(null)){
                    for (SomeUser ct : Server.clientsList) {
                        ct.out.write(clientMessage + "\n");
                        ct.out.flush();
                    }
                }
                else {
                    for (SomeUser ct: Server.clientsList){
                        if (ct.name.equals(messageClient.getGetter())){
                            ct.out.write(messageClient.getMessage());
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
