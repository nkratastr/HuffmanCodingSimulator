package com.example.huffmanproject.service;

import com.example.huffmanproject.entity.HuffmanNode;
import com.example.huffmanproject.interfaces.HuffmanCode;
import com.example.huffmanproject.interfaces.HuffmanTree;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanCodeService implements HuffmanCode {


        private final HuffmanTree huffmanTree;

        public HuffmanCodeService(HuffmanTree huffmanTree) {
            this.huffmanTree = huffmanTree;
        }

        // Add this method to get access to the HuffmanTree
        public HuffmanTree getHuffmanTree() {
            return this.huffmanTree;
        }

    @Override //rewerite with functional strem
    public Map<Character, Integer> calculateFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

       frequencyMap = input.chars()
               .mapToObj(c -> (char) c)
               .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));

        return frequencyMap;
    }

    @Override
    public Map<Character, String> generateHuffmanCodes(Map<Character, Integer> frequencyMap) {
            HuffmanNode root = huffmanTree.buildTree(frequencyMap);
        Map<Character, String> huffmanCodes = new HashMap<>();
        huffmanTree.traverseTree(root, "", huffmanCodes);
        return huffmanCodes;
    }

    @Override
    public String encode(String input, Map<Character, String> huffmanCodes) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }

    public String getCompressionRate(String original, String encoded) {
        int originalSize = original.length() * 8; // Assuming 8 bits per character
        int encodedSize = encoded.length();

        double compressionRate = (1 - (double)encodedSize / originalSize) * 100;

        return String.format("%.2f%%", compressionRate);
    }

    @Override
    public String decode(String encodedInput, Map<Character, String> huffmanCodes) {
        Map<String, Character> reverseHuffmanCodes = new HashMap<>();
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            reverseHuffmanCodes.put(entry.getValue(), entry.getKey());
        }

        StringBuilder decodedString = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();

        for (char bit : encodedInput.toCharArray()) {
            currentCode.append(bit);
            if (reverseHuffmanCodes.containsKey(currentCode.toString())) {
                decodedString.append(reverseHuffmanCodes.get(currentCode.toString()));
                currentCode = new StringBuilder();
            }
        }

        return decodedString.toString();
    }
}