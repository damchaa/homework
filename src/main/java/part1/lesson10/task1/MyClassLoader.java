package part1.lesson10.task1;

import java.io.*;


public class MyClassLoader extends ClassLoader {

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //Проверяем, существует ли такой файл
        String p = "src\\main\\java\\part1\\lesson10\\task1\\";
        File f = new File(p+name + ".class" );
        if(!f.isFile())
            throw new ClassNotFoundException("Нет такого класса " + name);
        InputStream ins = null;
        try{
            //С помощью потока считываем файл в массив байт
            ins = new BufferedInputStream(new FileInputStream(f));
            byte[]b = new byte[(int)f.length()];
            ins.read(b);
            //С помощью функции defineClass загружаем класс
            Class c = defineClass(null, b, 0, b.length,this.getClass().getProtectionDomain());
            return c;
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }
        finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
