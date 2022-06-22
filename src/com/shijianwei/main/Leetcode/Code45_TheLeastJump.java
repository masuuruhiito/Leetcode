package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/4/22 15:28
 *
 * 首先拿出最开始的能量，然后循环链表，比较出能走最远的那个节点，然后将
 */
public class Code45_TheLeastJump {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curJumpIndex = 0;
        int curPostIndex = 0;
        int res = 0;

        for (int i = 0; i < nums.length-1; i++) {
            curJumpIndex = Math.max(curJumpIndex, i + nums[i]);
            if (i == curPostIndex) {
                res++;
                curPostIndex = curJumpIndex;
            }
        }
        return res;
    }
}
