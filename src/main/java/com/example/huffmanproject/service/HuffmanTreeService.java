package com.example.huffmanproject.service;

import com.example.huffmanproject.entity.HuffmanNode;
import com.example.huffmanproject.interfaces.HuffmanTree;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTreeService implements HuffmanTree {

    @Override
    public HuffmanNode buildTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));

                frequencyMap
                .entrySet()
                .stream()
                .map(entry -> new HuffmanNode(entry.getKey(), entry.getValue()))
                .forEach(pq::offer);


        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        return pq.poll();
    }

    @Override
    public void drawHuffmanTree(HuffmanNode root) {
        drawNode(root, "", "");
    }

    private void drawNode(HuffmanNode node, String prefix, String childrenPrefix) {
        if (node == null) return;

        System.out.println(prefix + (node.character == '\0' ? "Internal" : node.character) +
                " (" + node.frequency + ")");

        if (node.left != null)
            drawNode(node.left, childrenPrefix + "├── ", childrenPrefix + "│.   ");

        if (node.right != null)
            drawNode(node.right, childrenPrefix + "└── ", childrenPrefix + "    ");
    }

    @Override
    public void traverseTree(HuffmanNode root, String prefix, Map<Character, String> huffmanCodes) {
        if (root == null) return;

        if (root.character != '\0') {
            huffmanCodes.put(root.character, prefix);
        }

        traverseTree(root.left, prefix + "0", huffmanCodes);
        traverseTree(root.right, prefix + "1", huffmanCodes);
    }


}