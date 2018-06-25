import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class sort {

    public static void main(String []args){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("B");
        list.add("A");
        list.add("5");
        list.add("9");
        list.add("0");
        list.add("-1");
        //按照顺序排序
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

}
