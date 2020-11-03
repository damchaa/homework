package part1.lesson4.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectBox<T extends Number> {
    private List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void addObject(T object){
        list.add(object);
    }

    public  void deleteObject(Object object){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(object))
                list.remove(object);
        }
    }
    public void dump(){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}