package com.keyin.binarytree.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


@Service
public class TreeService {
    private List<Integer> nums;

    public TreeService.Node buildBinaryTree(List<Integer> nums) {
        this.nums = nums;
        return null;
    }

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    public Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public Node buildBST(List<Integer> nums) {
        Node root = null;
        for (int n : nums) root = insert(root, n);
        return root;
    }

    public Map<String, Object> toMap(Node node) {
        if (node == null) return null;
        Map<String, Object> map = new HashMap<>();
        map.put("val", node.val);
        map.put("left", toMap(node.left));
        map.put("right", toMap(node.right));
        return map;
    }
}