package com.shijianwei.main.jianzhiOffer.Code16_Sort;

/**
 * @author SHI
 * @date 2022/2/9 10:14
 */
public class QuicklySort {
    public static void main(String[] args) {
        int []a = {1,5,3,2,1,5,67,8,2,1};
        quicklySort(a,0,a.length-1);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }

    public static void quicklySort(int []nums ,int l ,int r ){
        if(l>=r) return ;
        swap(nums,l+(int)(Math.random()*(r-l)),r);
        int []p = partition(nums,l,r) ;
        quicklySort(nums,l,p[0]);
        quicklySort(nums,p[1],r);
    }
    public static int[] partition(int[] arr, int l, int r) {
        int less =l-1 , more = r ;
        int target = arr[r] ;
        while (l<more){
            if(arr[l]<target){
                swap(arr,++less,l++);
            }
            else if(arr[l]>target){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        return new int []{less,more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
