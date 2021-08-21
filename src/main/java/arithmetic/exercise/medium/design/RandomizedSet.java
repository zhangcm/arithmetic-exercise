package arithmetic.exercise.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();

    private boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    private boolean remove(int val) {
        Integer index = map.get(val);
        if (index == null) {
            return false;
        }
        if (index == list.size() - 1) {
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        Integer exchangeVal = list.get(list.size() - 1);
        map.put(exchangeVal, index);
        list.set(index, exchangeVal);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    private int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
