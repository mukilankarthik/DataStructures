import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        Solution_OnePassHashTable solu = new Solution_OnePassHashTable();
        int[] que = new int[10];
        int[] arr;
        que[0] = 11;
        que[1] = 5;
        que[2] = 5;
        que[3] = 2;
        arr = solu.twoSum(que, 13);
        for (int a : arr) {
            System.out.println("ans" + a);
        }
    }
}
class Solution1 {
    public Solution1 () {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        outerloop :
        for (int a = 0 ; a <= nums.length - 1 ; a ++) {
            for (int b = 1 ; b <= nums.length -1 ; b ++) {
                if (nums[a] + nums[b] == target && (a != b)) {
                    ans[0] = a;
                    ans[1] = b;
                    break outerloop;
                }
            }

        }
        return ans;
    }
}

class Solution_OnePassHashTable {
    public Solution_OnePassHashTable () {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

class Solution_TwoPassHashTable {
    public Solution_TwoPassHashTable () {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
