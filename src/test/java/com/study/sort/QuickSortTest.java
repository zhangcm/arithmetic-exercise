package com.study.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 快速排序测试类
 */
public class QuickSortTest extends SortBaseTest {

    @Test
    public void testSort() {
        Integer[] arr = unsortArray();
        new QuickSort<Integer>().sort(arr);
        Assert.assertArrayEquals(sortedArray(), arr);
    }
}
