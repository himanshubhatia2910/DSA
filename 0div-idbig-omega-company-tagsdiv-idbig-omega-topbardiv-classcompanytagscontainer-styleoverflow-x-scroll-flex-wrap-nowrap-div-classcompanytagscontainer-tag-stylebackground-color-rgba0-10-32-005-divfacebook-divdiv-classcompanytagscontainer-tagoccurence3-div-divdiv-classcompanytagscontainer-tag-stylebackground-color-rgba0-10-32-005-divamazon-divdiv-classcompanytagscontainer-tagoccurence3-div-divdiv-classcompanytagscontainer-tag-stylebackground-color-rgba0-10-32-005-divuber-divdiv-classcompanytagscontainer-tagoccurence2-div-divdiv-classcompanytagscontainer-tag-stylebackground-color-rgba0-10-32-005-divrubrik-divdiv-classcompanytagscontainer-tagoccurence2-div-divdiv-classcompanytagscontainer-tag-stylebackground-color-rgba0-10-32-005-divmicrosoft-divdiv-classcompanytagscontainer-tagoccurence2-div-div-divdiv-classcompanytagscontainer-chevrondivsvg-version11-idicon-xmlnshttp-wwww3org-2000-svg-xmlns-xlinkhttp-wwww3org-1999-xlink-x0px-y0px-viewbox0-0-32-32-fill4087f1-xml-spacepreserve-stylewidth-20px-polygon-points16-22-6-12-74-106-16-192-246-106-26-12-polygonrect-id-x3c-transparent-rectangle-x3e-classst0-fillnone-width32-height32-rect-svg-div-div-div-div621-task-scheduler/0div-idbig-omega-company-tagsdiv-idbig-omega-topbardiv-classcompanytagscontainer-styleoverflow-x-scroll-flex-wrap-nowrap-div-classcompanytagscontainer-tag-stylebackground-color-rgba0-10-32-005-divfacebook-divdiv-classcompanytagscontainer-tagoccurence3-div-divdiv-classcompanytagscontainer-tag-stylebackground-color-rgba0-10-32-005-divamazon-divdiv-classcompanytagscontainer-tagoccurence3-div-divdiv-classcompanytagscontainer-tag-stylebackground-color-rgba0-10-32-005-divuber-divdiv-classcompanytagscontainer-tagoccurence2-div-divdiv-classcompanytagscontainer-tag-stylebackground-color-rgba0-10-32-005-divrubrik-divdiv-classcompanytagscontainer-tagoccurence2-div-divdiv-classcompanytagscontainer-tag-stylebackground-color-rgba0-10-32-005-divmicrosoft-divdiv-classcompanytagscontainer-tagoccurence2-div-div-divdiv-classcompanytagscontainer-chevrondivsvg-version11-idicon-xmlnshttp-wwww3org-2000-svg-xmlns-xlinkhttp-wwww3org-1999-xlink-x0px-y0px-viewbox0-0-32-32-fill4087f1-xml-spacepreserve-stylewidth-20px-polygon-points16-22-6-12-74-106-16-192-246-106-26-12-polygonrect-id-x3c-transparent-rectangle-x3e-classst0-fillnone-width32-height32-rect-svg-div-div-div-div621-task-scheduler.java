class Solution {
     public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 1) {
            return 1;
        }

        int minIntervals = 0;
        int maxCount = 0;
        Map<Character, Integer> taskCount = new HashMap<>();

        for (char task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
            maxCount = Math.max(taskCount.get(task), maxCount);
        }

        int maxCountTaskCount = 0;

        for (char task : taskCount.keySet()) {
            if (taskCount.get(task) == maxCount) {
                maxCountTaskCount++;
            }
        }

        minIntervals = (maxCount - 1) * (n + 1) + maxCountTaskCount;
        return Math.max(minIntervals, tasks.length);
    }
}