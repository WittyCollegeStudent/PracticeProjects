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
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

}
