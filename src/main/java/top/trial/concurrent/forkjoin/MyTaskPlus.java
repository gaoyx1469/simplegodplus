package top.trial.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author gaoyx1469
 * @Date 2020/9/22
 * @Version 1.0
 */
public class MyTaskPlus extends RecursiveTask<Integer> {

    private int start;

    private int end;

    public MyTaskPlus(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (start == end)
            return end;
        if (start - end == 1)
            return start + end;

        int mid = start + (end - start) / 2;


        MyTaskPlus task1 = new MyTaskPlus(start, mid);
        MyTaskPlus task2 = new MyTaskPlus(mid + 1, end);
        task1.fork();
        task2.fork();
        return task1.join() + task2.join();
    }
}
