package com.mlischetti.cracking_the_coding_interview.chapter_2.Q2_01_Remove_Dups;

import com.mlischetti.cracking_the_coding_interview.commons.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {

    private static void deleteDups(LinkedListNode n ) {
        Set<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    private static void deleteDupsNonBuffer(LinkedListNode head ) {
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current;
            while(runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        LinkedListNode cloned = head.clone();
        deleteDups(head);
        System.out.println(head.printForward());
        System.out.println();
        System.out.println(cloned.printForward());
        deleteDupsNonBuffer(cloned);
        System.out.println(cloned.printForward());
    }
}
