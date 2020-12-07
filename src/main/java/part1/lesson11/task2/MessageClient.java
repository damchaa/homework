package part1.lesson11.task2;

public class MessageClient   {
    private String name;
    private String message;
    private String getter;

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

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
        return
                "Пользователь: '" + name + '\'' +
                ", Вещает '" + message + '\'' ;
    }
}
