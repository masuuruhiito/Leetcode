package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/5/4 11:45
 */
public class Code42_MaxRain {


    /**
     * 超时了，以前是可以oc的，不止可以按照按照行来找，也可以按照列来找
     * @param height
     * @return
     */
    public int trap(int[] height) {
        //按照每一层来遍历，先找到数组的最大值，确定遍历层次
        int res = 0 ;
        int max = height[0];
        for(int i :height){
            max = Math.max(i,max);
        }
        for (int i = 1; i <= max; i++) {
            boolean flag = false;
            int tmp =0;
            for (int i1 : height) {
                if (i1 >= i) {
                    flag = true;
                    res += tmp;
                    tmp = 0;
                }
                if (flag && i1 < i) {
                    tmp++;
                }
            }
        }
        return res;
    }


    /**
     * 按照每列来找对应的存水量，可以分别对每列找到各自的左边的最高和右边的最高
     *      然后就可以使用两边中最短的减去当前列的长度，得到最终答案
     * @param height
     * @return
     */
    public int trap1(int[] height) {

        return 1;
    }
}
