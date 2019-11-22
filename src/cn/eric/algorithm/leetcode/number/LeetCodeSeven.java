package cn.eric.algorithm.leetcode.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCodeSeven
 * @Description:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists

 * @Author YCKJ2725
 * @Date 2019/11/13
 * @Version V1.0
 **/
public class LeetCodeSeven {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public ListNode setNext(int val){
            this.next = new ListNode(val);
            return this.next;
        }
    }

    /***  分治法  */
    public ListNode mergeKLists(ListNode[] lists) {
        lists = removeEmpty(lists);
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int length = lists.length;
        while(true){
            // 去掉空的
            lists = removeEmpty(lists);
            for (int i = 0; i < lists.length-1; i=i+2) {
                lists[i] = combine(lists[i], lists[i + 1]);
                lists[i+1] = null;
            }
            // 去掉空的
            lists = removeEmpty(lists);
            if(lists.length == 1){
                break;
            }
        }

        return lists[0];
    }

    private ListNode[] removeEmpty(ListNode[] lists) {
        List<ListNode> temp = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null){
                continue;
            }else{
                temp.add(lists[i]);
            }
        }
        return temp.toArray(new ListNode[temp.size()]);
    }

    private ListNode combine(ListNode one, ListNode two) {
        ListNode result = null;
        ListNode temp = null;
        boolean out = false;
        if(one == null){
            return two;
        }
        if(two == null){
            return one;
        }
        while (true){
            if(result == null){
                if(one.val <= two.val){
                    result = new ListNode(one.val);
                    one = one.next;
                }else{
                    result = new ListNode(two.val);
                    two = two.next;
                }
                temp = result;
            }

            // 如果 list1 空了 就把list2接上来
            while(one == null){
                temp.next = two;
                out = true;
                break;
            }
            while(two == null){
                temp.next = one;
                out = true;
                break;
            }
            if(out){
                break;
            }
            while(one != null && one.val <= two.val){
                temp.next = one;
                one = one.next;
                temp = temp.next;
            }


            while(one == null){
                temp.next = two;
                out = true;
                break;
            }
            if(out){
                break;
            }
            while(two != null && two.val <= one.val){
                temp.next = two;
                two = two.next;
                temp = temp.next;
            }
        }
        return result;
    }

    /***  先入到一个数组中 再排序 再 */
    public ListNode mergeKLists2(ListNode[] lists) {



        return null;
    }

    public static void main(String[] args) {

   // [[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
        ListNode[] list = new ListNode[7];
        ListNode A = new ListNode(-10);
        ListNode F = new ListNode(-9);
        ListNode H = new ListNode(-3);

        ListNode B = new ListNode(-5);
        ListNode C = new ListNode(4);
        ListNode D = new ListNode(-8);
        ListNode E = null;
        list[0] = A;
        list[1] = B;
        list[2] = C;
        list[3] = D;
        list[4] = E;
        list[5] = F;
        list[6] = H;

        A.setNext(-9).setNext(-9)
                .setNext(-3).setNext(-1).setNext(-1).setNext(0);
        F.setNext(-6).setNext(-5).setNext(-4).setNext(-2)
                .setNext(2).setNext(3);
        H.setNext(-3).setNext(-2).setNext(-1).setNext(0);


//        list[2] = H;
        LeetCodeSeven seven = new LeetCodeSeven();
        ListNode listNode = seven.mergeKLists(list);

        while(listNode !=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

