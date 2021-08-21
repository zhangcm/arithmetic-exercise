package arithmetic.exercise.medium.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务调度器
 *
 * 给你一个用字符数组tasks表示的CPU需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在1个单位时间内执行完。在任何一个单位时间，CPU
 * 可以完成一个任务，或者处于待命状态。然而，两个相同种类的任务之间必须有长度为整数n的冷却
 * 时间，因此至少有连续n个单位时间内CPU在执行不同的任务，或者在待命状态。你需要计算完成所有
 * 任务所需要的最短时间。
 *
 * 示例:
 * ["A", "A", "A", "B", "B", "B"] n = 2 -> 8
 * ["A", "A", "A", "B", "B", "B"] n = 0 -> 6
 * ["A", "A", "A", "A", "A", "A", "B", "C", "D", "E"] n = 2 -> 16
 */
public class TaskLeastInterval {

    private static int solution(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> taskMap = new HashMap<>();
        for (char task : tasks) {
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);
        }

        List<Task> taskList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : taskMap.entrySet()) {
            taskList.add(new Task(entry.getKey(), entry.getValue(), 0));
        }
        taskList.sort(Comparator.comparing(Task::getCount).reversed());
        int remainCount = taskList.size();
        int result = 0;
        while (remainCount > 0) {
            Task scheduledTask = null;
            for (Task task : taskList) {
                if (task.cd == 0 && task.cd > 0) {
                    task.decreaseCount();
                    task.cd = n;
                    if (task.getCount() == 0) {
                        remainCount--;
                    }
                    result++;
                    scheduledTask = task;
                    break;
                }
            }
            if (scheduledTask == null) {
                result++;
            }
            for (Task task : taskList) {
                if (scheduledTask != task) {
                    task.decreaseCd();
                }
            }
        }
        return result;
    }

    private static class Task {
        public char name;
        public int count;
        public int cd;

        public Task(char name, int count, int cd) {
            this.name = name;
            this.count = count;
            this.cd = cd;
        }

        public int getCount() {
            return count;
        }

        public void decreaseCd() {
            if (cd > 0) {
                cd -= 1;
            }
        }

        public void decreaseCount() {
            if (count > 0) {
                count -= 1;
            }
        }
    }
}
