package leetcode.binarysearch.qs744;

public class Qs744 {

    public static void main(String[] args) {
        Solution so = new Solution();
        char[] letters = new char[] {'c', 'f', 'j'};
        char target = 'f';
        System.out.println(so.nextGreatestLetter(letters, target));
    }

}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        for (char letter : letters) {
            if (res <= target) {
                if (letter < res || letter > target) {
                    res = letter;
                }
            }
            if (res >= target) {
                if (letter > target && letter < res) {
                    res = letter;
                }
            }
        }
        return res;
    }
}