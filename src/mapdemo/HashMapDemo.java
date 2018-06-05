package mapdemo;

import java.util.*;

public class HashMapDemo {

    public static void main(String []args){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        map.put(1, list);
        map.put(2, list);
        Collection values = map.values();
        Iterator<List<String>> iterator = values.iterator();
        List<List<Integer>> lists = new ArrayList<>();
        while(iterator.hasNext()){
            lists.add((ArrayList)(iterator.next()));
        }
//        List<List<Integer>> lists = new ArrayList<List<Integer>> (values);
        System.out.println(lists);
    }

}
