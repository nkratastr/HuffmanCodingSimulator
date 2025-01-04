package com.example.huffmanproject.interfaces;

import java.util.Map;

public interface HuffmanCode {

    /**
     * Calculates the frequency of characters in the input text.
     * @param input The input text.
     * @return A Map containing the characters and their frequencies.
     */
    Map<Character, Integer> calculateFrequency(String input);

    /**
     * Generates Huffman codes for each character based on their frequencies.
     * @param frequencyMap A Map containing characters and their frequencies.
     * @return A Map containing characters and their corresponding Huffman codes.
     */
    Map<Character, String> generateHuffmanCodes(Map<Character, Integer> frequencyMap);

    /**
     * Encodes the input text using the Huffman codes.
     * @param input The text to be encoded.
     * @param huffmanCodes The Map of characters and their Huffman codes.
     * @return The encoded string.
     */
    String encode(String input, Map<Character, String> huffmanCodes);

    /**
     * Decodes the encoded string back to the original text using the Huffman codes.
     * @param encodedInput The encoded string.
     * @param huffmanCodes The Map of characters and their Huffman codes.
     * @return The original decoded text.
     */
    String decode(String encodedInput, Map<Character, String> huffmanCodes);


}
