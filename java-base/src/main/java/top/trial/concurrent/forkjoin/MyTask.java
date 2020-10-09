package top.trial.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author gaoyx1469
 * @Date 2020/9/22
 * @Version 1.0
 */
public class MyTask extends RecursiveTask<Integer> {

    private int num;

    public MyTask(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num == 1)
            return 1;
        MyTask task = new MyTask(num - 1);
        task.fork();
        return task.join() + num;
    }
}
