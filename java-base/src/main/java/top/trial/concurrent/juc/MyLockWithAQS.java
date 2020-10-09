package top.trial.concurrent.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义不可重入锁，实现Lock接口，同时自定义内部类继承AbstractQueuedSynchronizer，借助AQS实现Lock接口内的部分方法
 *
 * @Author gaoyx1469
 * @Date 2020/9/23
 * @Version 1.0
 */
public class MyLockWithAQS implements Lock {

    class MySync extends AbstractQueuedSynchronizer {

        //获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //释放锁
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //共享锁获取，独占锁不需要重写此方法
        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        //共享锁释放，独占锁不需要重写此方法
        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        //是否持有独占锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //自定义一个获取Condition的方法
        public Condition getCondition() {
            return new ConditionObject();
        }
    }

    private MySync mySync = new MySync();

    //加锁，不成功会进入等待队列
    @Override
    public void lock() {
        mySync.acquire(1);
    }

    //加锁，可打断
    @Override
    public void lockInterruptibly() throws InterruptedException {
        mySync.acquireInterruptibly(1);
    }

    //加锁，仅尝试一次
    @Override
    public boolean tryLock() {
        return mySync.tryAcquire(1);
    }

    //加锁，带超时机制
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1, unit.toNanos(time));
    }

    //解锁，使用release方法是因为除了调用了tryRelease之外，还增加了唤醒等待线程的操作
    @Override
    public void unlock() {
        mySync.release(1);
    }

    //获取条件变量
    @Override
    public Condition newCondition() {
        return mySync.getCondition();
    }
}
