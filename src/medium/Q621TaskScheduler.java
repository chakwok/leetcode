package medium;

public class Q621TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[27];

        for (char task: tasks) {
            taskCounts[task - 'A']++;
        }

        // count of process with most occurence
        int max = -1;
        //numbers of processes with the same number of occurence
        int maxCount = 1;

        for (int taskCount: taskCounts) {
            if (max == taskCount) {
                maxCount ++;
            } else if (taskCount > max) {
                max = taskCount;
                maxCount = 1;
            }
        }
        //either limited by idle or number of processes
        return Math.max(n * (max - 1) + max + maxCount - 1, tasks.length);
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 50));
    }
}
