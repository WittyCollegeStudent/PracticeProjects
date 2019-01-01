package instancedemo;

/**
 * 测试instance关键字的用法
 */

public class InstanceDemo {

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        System.out.println("soldier instanceof Person : " + (soldier instanceof Person));
        System.out.println("soldier instanceof Man : " + (soldier instanceof Man));
    }

}

class Person{

    private int age;

    private String sex;

}

class Man extends Person{}

class Soldier extends Man{}