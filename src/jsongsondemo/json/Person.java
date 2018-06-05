package jsongsondemo.json;

import java.util.Arrays;

/**
 * @Author: weianyang
 * @Date: 2018/5/22 17:02
 * @Description: weianyang
 */
public class Person{

//    @SerializedName("NAME")
    private String name ;
    private Integer age ;
    private String[] cars;
    private transient String ignore;

    public String getIgnore() {
        return ignore;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + Arrays.toString(cars) +
                ", ignore='" + ignore + '\'' +
                '}';
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
