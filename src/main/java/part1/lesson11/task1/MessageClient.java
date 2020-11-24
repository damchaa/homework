package part1.lesson11.task1;

import java.io.Serializable;

public class MessageClient   {
    private String name;
    private String message;

    public MessageClient(){


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageClient{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
