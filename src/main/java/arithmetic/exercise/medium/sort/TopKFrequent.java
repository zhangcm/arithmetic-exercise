package arithmetic.exercise.medium.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int num : nums) {
            Integer value = map.computeIfAbsent(num, (key) -> 0);
            map.put(num, ++value);
        }

        Entry[] arr = new Entry[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            arr[index++] = new Entry(item.getKey(), item.getValue());
        }

        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[arr.length - i - 1].key;
        }
        return result;
    }

    private static class Entry implements Comparable<Entry> {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[] {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6}, 3);;
        System.out.println(Arrays.toString(result));
    }

}
