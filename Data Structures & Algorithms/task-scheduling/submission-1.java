public class Task {
    public int frequency;
    public char taskName;
    public int wakeUpTime;

    public Task(char taskName, int frequency) {
        this.taskName = taskName;
        this.frequency = frequency;
        this.wakeUpTime = 0;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b.frequency, a.frequency));
        Deque<Task> coolDownQueue = new ArrayDeque<>();
        Arrays.sort(tasks);
        char prev = tasks[0];
        int counter = 1;
        for (int i = 1; i < tasks.length; i++) {
            if (prev == tasks[i]) {
                counter++;
            } else {
                Task obj = new Task(prev, counter);
                maxHeap.offer(obj);
                prev = tasks[i];
                counter = 1;
            }
        }

        Task obj = new Task(prev, counter);
        maxHeap.offer(obj);

        int t = 0;

        // while(maxHeap.size()>0){
        //         Task item = maxHeap.poll();
        //         System.out.println( " maxHeap " + item.taskName + " " + item.frequency);

        // }

        while (maxHeap.size() > 0 | (coolDownQueue.size() > 0)) {
            t++;
            // System.out.println("At t = "+ t);
            // System.out.println(" coolDownQueue.size() > 0 : "+  (coolDownQueue.peek()));
            if (coolDownQueue.size() > 0 && coolDownQueue.peek().wakeUpTime == t) {
                Task item = coolDownQueue.poll();
                // System.out.println( " coolDownQueue " + item.taskName + " " + item.frequency);
                maxHeap.offer(item);
            }

            if (maxHeap.size() > 0) {
                Task item = maxHeap.poll();
                // System.out.println(item.taskName + " freq: " + item.frequency + " processing at:" + t);

                if (item.frequency > 1) {
                    item.wakeUpTime = t + (n + 1);
                    item.frequency = item.frequency - 1;
                    coolDownQueue.offer(item);
                    // System.out.println("peek is: "+ coolDownQueue.peek().wakeUpTime);
                }
            }
        }

        return t;
    }
}
