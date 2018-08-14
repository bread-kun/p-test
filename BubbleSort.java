import java.util.Arrays;
public class BubbleSort {
    // 冒泡1
    private static void sort_bubble1(int[] array) {
        int tmp = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];

                    array[j + 1] = tmp;
                }
            }
        }
    }
    // 插入2
    private static void sort_insert1(int[] array) {
        int min = 0;
        int max = array.length;
        int len = array.length;
        int[] temp = {0,0};
        for (int i = 0; i < array.length/2; i++) {
            min = i;
            max = array.length - i - 1;
            for (int j = i; j < array.length - i; j++) {
                if (array[j] < array[min])
                    min = j;
                if (array[j] > array[max])
                    max = j;
            }
            // exchange
            temp[0] = array[min];
            temp[1] = array[max];
            array[min] = array[i];
            array[max] = array[array.length - i - 1];

            array[i] = temp[0];
            array[array.length - i - 1] = temp[1];
            
        }
    }
    // 冒泡2
    private static void sort_bubble2(int[] array) {
        int tmp = 0;

        //记录最后一次交换的位置
        int lastExchangeIndex = 0;

        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];

                    array[j] = array[j + 1];

                    array[j + 1] = tmp;

                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;

                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }

            sortBorder = lastExchangeIndex;

            if (isSorted) {
                break;
            }
        }
    }

    // 鸡尾酒
    private static void sort_cocketail(int[] array){
        int tmp = 0;
        // 双向式冒泡
        for (int i = 0; i < array.length/2; i++) {
            // 奇数向右
            for (int j = i; j < (array.length - i - 1); j++) {
                // 正向 
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            // 偶数向左
            for (int j = array.length - i - 2; j > i; j--) {
                // 反向 
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }

        }

    }

    private static void finish(int[] array) {
        for (int i=0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                System.out.println("fall");
                return ;
            }
        }
        System.out.println("finish");
    }

    public static void main(String[] args) {
        int size = 100000;
        int[] array = new int[size];
        int[] array_1 = new int[size];
        int[] array_2 = new int[size];
        int[] array_3 = new int[size];
        for (int i = 0; i < size ; i++ ) {
            array[i] = size - i;
            array_1[i] = size - i;
            array_2[i] = size - i;
            array_3[i] = size - i;
        }
        long time_1 = 0l;
        long time_2 = 0l;
        long time_3 = 0l;
        long time_4 = 0l;
        long start = 0l;
        long end = 0l;
        start = System.currentTimeMillis();
        sort_bubble1(array);
        end = System.currentTimeMillis();
        finish(array);
        time_1 = end - start;

        start = System.currentTimeMillis();
        sort_bubble2(array_1);
        end = System.currentTimeMillis();
        finish(array_1);
        time_2 = end - start;

        start = System.currentTimeMillis();
        sort_insert1(array_2);
        end = System.currentTimeMillis();
        finish(array_2);
        time_3 = end - start;

        start = System.currentTimeMillis();
        sort_cocketail(array_3);
        end = System.currentTimeMillis();
        finish(array_3);
        time_4 = end - start;

        System.out.println("冒泡排序 1: " + time_1 + "\n\r");
        // System.out.println("bubble sort: " + time_1 + "\n\r" + Arrays.toString(array));
        System.out.println("冒泡排序 2: " + time_2 + "\n\r");
        System.out.println("插入排序 2: " + time_3 + "\n\r");
        System.out.println("鸡尾酒排序 1: " + time_4 + "\n\r");
        // System.out.println("max sort: " + time_2 + "\n\r" + Arrays.toString(array_1));
    }
}