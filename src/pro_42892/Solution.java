package pro_42892;

import java.util.*;
import java.io.*;

public class Solution {

    static class Tree {
        Node root;

        public void insert(Node node) {
            if (this.root == null) {
                this.root = node;
                return;
            }

            setChild(root, node);
        }

        public void setChild(Node parent, Node child) {
            if (child.x < parent.x) {
                if (parent.left == null) {
                    parent.left = child;
                    return;
                }
                setChild(parent.left, child);
            } else {
                if (parent.right == null) {
                    parent.right = child;
                    return;
                }
                setChild(parent.right, child);
            }
        }

        public void preOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }

            result.add(node.n);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }

        public void postOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }

            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.n);
        }
    }
    static class Node implements Comparable<Node> {
        int n, y, x;
        Node left, right;

        public Node(int n, int y, int x) {
            this.n = n;
            this.y = y;
            this.x = x;
        }

        public int compareTo(Node o) {
            if (y == o.y) {
                return x - o.x;
            }
            return o.y - y;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            pq.add(new Node(i + 1, nodeinfo[i][1], nodeinfo[i][0]));
        }

        Tree tree = new Tree();

        while (!pq.isEmpty()) {
            tree.insert(pq.poll());
        }


        List<Integer> preResult = new ArrayList<>();
        List<Integer> postResult = new ArrayList<>();
        tree.preOrder(tree.root, preResult);
        tree.postOrder(tree.root, postResult);
        return new int[][]{lta(preResult), lta(postResult)};
    }

    public static int[] lta(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        new Solution().solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }
}
