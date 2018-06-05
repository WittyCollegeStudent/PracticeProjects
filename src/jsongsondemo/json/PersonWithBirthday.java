package jsongsondemo.json;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author: weianyang
 * @Date: 2018/5/22 17:02
 * @Description: 含有日期类的bean
 */
public class PersonWithBirthday {

//    @SerializedName("NAME")
    private String name ;
    private Integer age ;
    private String[] cars;
    private Date birthday;
    private transient String ignore;

    @Override
    public String toString() {
        return "PersonWithBirthday{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + Arrays.toString(cars) +
                ", birthday=" + birthday +
                ", ignore='" + ignore + '\'' +
                '}';
    }

    public String getIgnore() {
        return ignore;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
