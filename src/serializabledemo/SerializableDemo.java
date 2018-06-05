package serializabledemo;

import java.io.*;

public class SerializableDemo {

    public static void main(String[] args) {
        ObjectOutputStream writer = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("C:\\Users\\witty\\Desktop\\a.txt"));
            writer = new ObjectOutputStream(fos);
            Person p = new Person();
            p.setName("zhangbo22479");
            p.setAge(23);
            //这里是以二进制形式写文件，所以内容对人而言是不可读的
            writer.writeObject(p);
            writer.flush();
        } catch (IOException e) {
            try {
                fos.close();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}

class Person implements Serializable{

    //名字
    String name;
    //年龄
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
