package com.example.huffmanproject.entity;

public class HuffmanNode {
   public char character; // The character in the node
    public int frequency;  // The frequency of the character
    public HuffmanNode left; // Left child node
    public HuffmanNode right; // Right child node

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }



}
