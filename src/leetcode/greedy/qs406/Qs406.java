package leetcode.greedy.qs406;

import java.util.*;

public class Qs406 {

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution so = new Solution();
        System.out.println(so.reconstructQueue(people));
    }

}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int minu = o2[0] - o1[0];
                if (minu > 0) {
                    return 1;
                } else if (minu == 0) {
                    return o1[1] - o2[1];
                } else {
                    return -1;
                }
            }
        });
        List<int[]> peopleList = Arrays.asList(people);
        List<int[]> linkedList = new LinkedList<>();
        for (int i = 0; i < peopleList.size(); i ++) {
            linkedList.add(peopleList.get(i)[1], peopleList.get(i));
        }
        return linkedList.toArray(new int[linkedList.size()][]);
    }
}
