package leetcode.binarysearch.qs278;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }
    public int binarySearch(int start, int end) {
        if (start >= end) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return binarySearch(start, mid);
        } else {
            return binarySearch(mid + 1, end);
        }
    }
}
class VersionControl {
    public boolean isBadVersion(int n) {
        return true;
    }
}