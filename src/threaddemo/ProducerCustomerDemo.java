package threaddemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbo22479
 * @date 2018/12/19
 */
public class ProducerCustomerDemo {

    public static void main(String[] args) {
        Basket basket = Basket.getBasket();
        Producer p1 = new Producer(basket, "生产者1");
        Customer c1 = new Customer(basket, "消费者1");
        new Thread(p1).start();
        new Thread(c1).start();
    }

}

class Basket{

    private static Basket basket = null;

    private List<String> appleList = null;

    private Basket() {
        this.appleList = new ArrayList<>();
    }

    public static Basket getBasket() {
        if (basket == null) {
            basket = new Basket();
            return basket;
        } else {
            return basket;
        }
    }

    List<String> getApples() {
        return appleList;
    }

}

/**
 * 生产者
 */
class Producer implements Runnable{

    private Basket basket = null;

    private String producerName = null;

    public Producer(Basket basket, String name) {
        this.basket = basket;
        this.producerName = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (basket) {
                for (int i = 0; i < 5 ;i ++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String appleName = "apple" + i;
                    basket.getApples().add(appleName);
                    System.out.println(producerName + "生产了" + appleName);
                    System.out.println("篮子里还有" + basket.getApples().size() + "个apple");
                }
                basket.notify();
                try {
                    basket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

/**
 * 消费者
 */
class Customer implements Runnable{

    private Basket basket = null;

    private String customerName = null;

    public Customer(Basket basket, String name) {
        this.basket = basket;
        this.customerName = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (basket) {
                for (int i = 0; i < 2 && basket.getApples().size() > 0;i ++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String appleName = basket.getApples().get(basket.getApples().size() - 1);
                    basket.getApples().remove(basket.getApples().size() - 1);
                    System.out.println(customerName + "消费了" + appleName);
                    System.out.println("篮子里还有" + basket.getApples().size() + "个apple");
                }
                basket.notify();
                try {
                    basket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}