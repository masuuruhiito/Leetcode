package com.shijianwei.main.jianzhiOffer.Code05_Find;

/**
 * @author SHI
 * @date 2022/1/24 11:35
 *
 * 找到局部最小值
 */
public class Code11 {
    public static void main(String[] args) {
        int []a = {1,2,3};
        System.out.println(minArray(a));
//        Integer.MIN_VALUE;
//        Integer.MAX_VALUE;

    }
    public static int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
//        因为为旋转数组，在进行旋转后，在目标数前面的数都比最后一个数大，后面的都比最后一个数小
        while (i <= j) {
            int mid = i+((j-i)>>1);
            if (numbers[mid]>numbers[j]) {//一定出现在mid的右边
                i = mid +1 ;
            } else if (numbers[mid]<numbers[j]) {//一定出现在左边（因为原本数组有序）
                j = mid ;
            }else{//找到i-j区域的最小值
                int min = i ;
                for (int k = i+1; k <=j ; k++) {
                    if(numbers[k]<numbers[min]){
                        min = k ;
                    }
                }
            }
        }
        return numbers[i];
    }
}
