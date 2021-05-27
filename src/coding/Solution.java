package coding;

/**
 * @author dingweiqiang
 * @description analysis problems
 * @date 2021/5/18 16:52
 */
public class Solution {

    /**
     * @author dingweiqiang
     * @description 704th 二分查找
     * @date 2021/5/18 19:16
     */
    public int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1,mid;
        while (left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

    /**
     * @author dingweiqiang
     * @description 27th 移除元素
     * @date 2021/5/18 20:50
     */
    public int removeElement(int[] nums,int val){
        int n = 0;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] == val){
                nums[i] = nums[nums.length-n-1];
                n++;
            }
        }
        return nums.length - n;
    }

    /**
     * @author dingweiqiang
     * @description 209th 长度最小的子数组
     * @date 2021/5/18 21:19
     */
    public int minSubArrayLen01(int target, int[] nums) {
        //暴力解法
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<nums.length-1;i++){
            int sum = nums[i];
            if (sum>=target){
                return 1;
            }
            for (int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if (sum>=target){
                    min=Math.min(min,j-i+1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }

    public int minSubArrayLen02(int target, int[] nums) {
        /*
        滑动窗口：先滑动最右边满足条件再滑动最左边，左边不能动了再滑动右边直到移到最后，中间不断计算最小长度
        */
        int min = Integer.MAX_VALUE;
        int start = 0,end = 0;
        int sum = 0;
        while(end<nums.length){
            sum+=nums[end];
            while (sum >= target){
                min = Math.min(min,end-start+1);
                sum-=nums[start++];
            }
            end++;
        }
        return min == Integer.MAX_VALUE?0:min;
    }

    /**
     * @author dingweiqiang
     * @description 59. 螺旋矩阵 II
     * @date 2021/5/20 21:18
     */
    public int[][] generateMatrix(int n) {
        if(n==1){
            return new int[][]{{1}};
        }
        int [][] matrix = new int [n][n];
        boolean right = true,down = false,left=false,up = false;
        int p=0,q=0;
        for (int i = 1;i<n*n+1;i++){
            if (right){
                if (q<n&&matrix[p][q]==0){
                    matrix[p][q++] = i;
                }else{
                    q--;
                    right = false;
                    down = true;
                    p++;
                }
            }
            if (down){
                if (p<n&&matrix[p][q]==0){
                    matrix[p++][q] = i;
                }else{
                    p--;
                    left = true;
                    down = false;
                    q--;
                }
            }
            if (left){
                if (q>=0&&matrix[p][q]==0){
                    matrix[p][q--] = i;
                }else{
                    q++;
                    up = true;
                    left = false;
                    p--;
                }
            }
            if (up){
                if (p>=0&&matrix[p][q]==0){
                    matrix[p--][q] = i;
                }else{
                    p++;
                    up = false;
                    right = true;
                    q++;
                    i--;
                }
            }
        }

        return matrix;

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     * @author dingweiqiang
     * @description 203. 移除链表元素
     * @date 2021/5/24 17:37
     */
    public ListNode removeElements(ListNode head, int val) {
        /**不设置虚节点*/
        ListNode pre = null;
        ListNode newHead = null;
        boolean firstNode = true;
        while (head !=null){
            if (firstNode && head.val != val){
                pre = new ListNode(head.val);
                newHead = pre;
                firstNode = false;
            }else if (!firstNode && head.val != val){
                pre.next = new ListNode(head.val);
                pre = pre.next;
            }
            head = head.next;
        }
        return newHead;
    }

    public ListNode removeElements2(ListNode head, int val) {
        /**设置虚节点*/
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode newHead = pre;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return newHead.next;
    }
    public ListNode removeElements3(ListNode head, int val) {
        /**递归*/
        if (head == null){
            return null;
        }
        head.next = removeElements3(head.next,val);
        return head.val == val? head.next : head;
    }
}
