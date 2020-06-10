package org.golao.com;

import java.util.Arrays;

/**
 * 排序
 * Created by golao on 2018/7/5.
 */
public class Sort {
    public static void bubbleSort(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[i] > ary[j]) {
                    int temp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortBetter(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = ary.length - 1; j >= i + 1; j--) {
                if (ary[j] < ary[j - 1]) {
                    int temp = ary[j];
                    ary[j] = ary[j - 1];
                    ary[j - 1] = temp;
                }
            }
        }
    }

    public static void simpleSelectSort(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            int min = i;
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[min] > ary[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = ary[min];
                ary[min] = ary[i];
                ary[i] = temp;
            }
        }
    }

    public static void straightInsertSort(int[] ary) {
        for (int i = 2; i < ary.length; i++) {
            if (ary[i] < ary[i - 1]) {
                ary[0] = ary[i];
                int j;
                for (j = i - 1; ary[j] > ary[0]; j--) {
                    ary[j + 1] = ary[j];
                }
                ary[j + 1] = ary[0];
            }
        }
    }


    public static void straightInsertSort2(int[] ary) {
        for (int i = 2; i < ary.length; i++) {
            if (ary[i] < ary[i - 1]) {
                ary[0] = ary[i];
                int j;
                for (j = i - 1; ary[j] > ary[0]; j--) {
                    ary[j + 1] = ary[j];
                }
                ary[j + 1] = ary[0];
            }
        }
    }


    public static void straightInsertSort3(int[] ary) {
        for (int i = 2; i < ary.length; i++) {
            if (ary[i] < ary[i - 1]) {
                ary[0] = ary[i];
                int j;
                for (j = i - 1; ary[j] > ary[0]; j--) {
                    ary[j + 1] = ary[j];
                }
                ary[j + 1] = ary[0];
            }
        }
    }


    public static void straightInsertSort4(int[] ary) {
        for (int i = 2; i < ary.length; i++) {
            if (ary[i] < ary[i - 1]) {
                ary[0] = ary[i];
                int j;
                for (j = i - 1; ary[j] > ary[0]; j--) {
                    ary[j + 1] = ary[j];
                }
                ary[j + 1] = ary[0];
            }
        }
    }

    public void testNew() {
        outer:
        {
        }
        splice:
        {
        }
        abc:
        {
        }
    }


    public static void main(String[] args) {
        int[] bubble = {0, 8, 2, 4, 9, 199, 8, 19};
//        bubbleSort(bubble);
//        bubbleSortBetter(bubble);
//        simpleSelectSort(bubble);
        straightInsertSort(bubble);
        System.out.println(Arrays.toString(bubble));
    }

}
