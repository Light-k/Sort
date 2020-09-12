package demo;


/**
 * 快速排序
 *
 * @Author : KangXu
 * @Date : 2020/9/11
 * @Package : com.light.layui.pojo
 */

public class Quick {

    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        int minIndex = 0;                       //设置最小索引
        int maxIndex = a.length - 1;            //设置最大索引
        sort(a, minIndex, maxIndex);
    }

    public static void sort(Comparable[] a, int minIndex, int maxIndex) {
        //安全检查
        if (maxIndex <= minIndex) {
            return;
        }
        //将数组分成两个，一个左子组，一个右子组
        int i = partition(a, minIndex, maxIndex);
        //对左子组排序
        sort(a, minIndex, i - 1);
        //对右子组排序
        sort(a, i + 1, maxIndex);
    }

    //分组并排序
    public static int partition(Comparable[] a, int minIndex, int maxIndex) {
        Comparable key = a[0];
        int left = minIndex;
        int right = maxIndex + 1;
        while (true) {
            //找到第一个右子组比基准值小的
            while (getMax(a[--right], key)) {
                if (right == minIndex) {
                    break;
                }
            }
            //找到第一个左子组比基准值大的
            while (getMax(key, a[++left])) {
                if (left == maxIndex) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(a, left, right);
            }
        }
        exchange(a, minIndex, right);
        return right;
    }

    //判断前一个是否比后一个大
    public static boolean getMax(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    //交换数组中索引处的值
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        a;
    }
}