package org.zero.algorithm;

import java.util.ArrayList;
import java.util.List;

public class TreeOrder {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
        root.left.left = new TreeNode();
        root.left.left.val = 4;
        root.left.right = new TreeNode();
        root.left.right.val = 5;
        root.right = new TreeNode();
        root.right.val = 3;
        root.right.left = new TreeNode();
        root.right.left.val = 6;
        root.right.right = new TreeNode();
        root.right.right.val = 7;


        int[][] res = threeOrders(root);
        System.out.println("orders: " + res);

        painOrder(root);
    }
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static int[][] threeOrders (TreeNode root) {
        // write code here
        if(root == null) {
            return new int[3][0];
        }
        List<Integer> list = new ArrayList();
        // 先序
        firstOrder(list, root);

        Integer[] first = new Integer[list.size()];
        first = list.toArray(first);
        System.out.println(list);
        // 中序
        list = new ArrayList<>();
        middleOrder(list, root);
        Integer[] middle = new Integer[list.size()];
        middle = list.toArray(middle);
        System.out.println(list);
        // 后序
        list = new ArrayList<>();
        backOrder(list, root);
        Integer[] back = new Integer[list.size()];
        back = list.toArray(back);
        System.out.println(list);
        int[][] res = new int[3][list.size()];
        res[0] = unbox(first);
        res[1] = unbox(middle);
        res[2] = unbox(back);
        return res;
    }

    public static int[] unbox(Integer[] boxed) {
        if(boxed == null) {
            return new int[0];
        }
        int[] unbox = new int[boxed.length];
        for(int i=0; i<boxed.length; i++) {
            unbox[i] = boxed[i];
        }
        return unbox;
    }

    public static void firstOrder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        firstOrder(list, root.left);
        firstOrder(list, root.right);
    }

    public static void middleOrder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        middleOrder(list, root.left);
        list.add(root.val);
        middleOrder(list, root.right);
    }


    public static void backOrder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        backOrder(list, root.left);
        backOrder(list, root.right);
        list.add(root.val);
    }

    public static void painOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if(root == null) {
            return;
        }
        int count = 0;
        List<Integer> res = new ArrayList<>();
        TreeNode curr;
        list.add(root);
        count++;
        for(int idx = 0; idx < count; idx++) {
            curr = list.get(idx);
            if(curr != null) {
                if(curr.left != null) {
                    list.add(curr.left);
                    count++;
                }
                if(curr.right != null) {
                    list.add(curr.right);
                    count++;
                }
            }
        }
        for(int i=0; i<list.size(); i++) {
            res.add(list.get(i).val);
        }
        System.out.println("pain order: " + res);
    }
}
