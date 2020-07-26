import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permutation {

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] array = new int[]{1,2,3};
        List<List<Integer>> arrayList = so.perm(array);
        System.out.println(arrayList);
    }

}

class Solution {

    private List<List<Integer>> arrayList = null;

    public List<List<Integer>> perm(int[] arr) {
        this.arrayList = null;
        if (arr == null || arr.length <= 0) {
            return arrayList;
        }
        arrayList = new ArrayList<>();
        execute(arr, new Stack<>());
        return this.arrayList;
    }

    private void execute(int[] currArray, Stack<Integer> stack) {
        if (currArray.length <= 0) {
            arrayList.add(new ArrayList<>(stack));
        } else {
            for (int i = 0 ; i < currArray.length ; i ++) {
                int[] newArray = new int[currArray.length - 1];
                System.arraycopy(currArray, 0, newArray, 0, i);
                System.arraycopy(currArray, i+1, newArray, i, currArray.length - i - 1);
                stack.push(currArray[i]);
                execute(newArray, stack);
                stack.pop();
            }
        }
    }

}