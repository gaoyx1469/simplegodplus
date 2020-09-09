package top.algorithm.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

import top.algorithm.util.sort.*;

/**
 * 排序测试类
 *
 * @author gaoyx
 */
public class SortTest {

    public static void main(String[] args) {
        int[] nums = {5, 8, 6, 3, 9, 2, 1, 7, 6};

        int[] testNums = new int[100_000];
        for (int i = 0; i < testNums.length; ++i) {
            testNums[i] = (int) (Math.random() * 1000_000);
        }
        //System.out.println(Arrays.toString(testNums));
        LocalDateTime beforeTime = LocalDateTime.now();
        // BubbleSort.sortE4(testNums);//11s
        // SelectionSort.sortE2(testNums);//6s
        // InsertionSort.sortE2(testNums);//1s
        // ShellSort.sortE1(testNums);//19ms
        // QuickSort.sortE1(testNums);//36ms
        // MergeSort.sortE1(testNums);//39ms
        // HeapSort.sortE1(testNums);
        // CountSort.sortE3(testNums);
        LocalDateTime afterTime = LocalDateTime.now();
        Long duration = Duration.between(beforeTime, afterTime).toMillis();
        System.out.println(duration);
        double[] numsDouble = {5.1, 8.1, 6.1, 3.1, 9.1, 2.1, 1.1, 7.1, 6.1};
        BucketSort.sortE1(numsDouble);

        String[] stringArray = {"acdc", "efgy", "ejhf", "savfdbr", "df"};
        RadixSort.sortE1(stringArray);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(numsDouble));
        System.out.println(Arrays.toString(stringArray));
    }
}
