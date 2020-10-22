package part1.lesson4.task2;

import java.util.ArrayList;
import java.util.List;

public class ObjectBox {
    private List<Object> list = new ArrayList<>();



    public void addObject(Object object){
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
            System.out.print(list.get(i) + " ");
        }
    }
}