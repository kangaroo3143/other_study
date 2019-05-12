/**
 * Copyright (c),2016-2018, iThinkDT
 * <br/>This program is protected by copyright laws;
 * <br/>Program Name: other_study<b>ithinkdt<b>
 * <br/>
 * Package: medium <br <br/>
 * FileName: RemoveNthNodeFromEndofList<br <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author ithinkdt
 * @version 1.0
 * @since JDK 1.8
 */
package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * * com.ithinkdt.dqa.admin.config
 *
 * @version 1.0
 * @descreption:
 * @date:2019/4/16 19:30
 * @author: liubo
 * @since JDK1.8
 */
public class RemoveNthNodeFromEndofList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        Integer i = 1;
        for (ListNode current = head; current != null; current = current.next) {
            map.put(i++, current);
        }
        ListNode removeNode = map.get(i - n);
        if (removeNode == head) {
            head = head.next;
            return head;
        }
        map.get(i - n - 1).next = map.get(i - n + 1);
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 10; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;

        }


        ListNode list = removeNthFromEnd(head, 1);
        System.out.println("fsaf");
    }

}
