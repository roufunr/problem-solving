package leetcode.two_thousand_23.binary_search.find_k_closest_elements;
import java.util.*;


class Pair {
    public int closeness;
    public int element;

    public Pair(int closeness, int element) {
        this.closeness = closeness;
        this.element = element;
    }
}
public class Solution {

    public int findClosestElement(int[] arr, int x) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int closeness = Math.abs(arr[mid] - x);
            int left_closeness = Math.abs(arr[mid-1] - x);
            int right_closeness = Math.abs(arr[mid+1] - x);

            if(closeness <= right_closeness && closeness <= left_closeness) {
                return mid;
            } else if (closeness > right_closeness) {
                left = mid;
            } else if (closeness > left_closeness) {
                right = mid;
            }
        }
        int left_closeness = Math.abs(arr[left] - x);
        int right_closeness = Math.abs(arr[right] - x);
        if (left_closeness == right_closeness) {
            return arr[left] < arr[right] ? left : right;
        } else {
            return left_closeness < right_closeness ? left : right;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int closed_idx = findClosestElement(arr, x);
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                int closenessComparison = Integer.compare(pair1.closeness, pair2.closeness);
                if (closenessComparison == 0) {
                    return Integer.compare(pair1.element, pair2.element);
                }
                return closenessComparison;
            }
        });
        int startIdx = (closed_idx - (k - 1)) < 0 ? 0 : (closed_idx - (k - 1));
        int endIdx = (closed_idx + (k - 1)) >= arr.length ? arr.length - 1 : (closed_idx + (k - 1));
        for(int i = startIdx; i <= endIdx; i++) {
            pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
        }
        PriorityQueue<Pair> pqElement = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.element));
        for(int i = 0; i < k; i++) {
            pqElement.add(pq.poll());
        }
        for(int i = 0; i < k; i++) {
            int element = pqElement.poll().element;
            ans.add(element);
        }

        return ans;
    }
}
