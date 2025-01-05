package com.example.huffmanproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import com.example.huffmanproject.service.HuffmanCodeService;

import java.util.Map;

public class ApplicationUIController {
    @FXML
    private TextField inputField;
    @FXML
    private TextArea outputArea;
    @FXML
    private VBox treeContainer;

    private HuffmanCodeService huffmanCodeService;

    public void setHuffmanCodeService(HuffmanCodeService service) {
        this.huffmanCodeService = service;
    }

    @FXML
    protected void onEncodeButtonClick() {
        String input = inputField.getText();

        // Validation of inputtext
        String validationError = validateInput(input);
        if (validationError != null) {
            outputArea.setText(validationError);
            return;
        }

        Map<Character, Integer> frequencyMap = huffmanCodeService.calculateFrequency(input);
        Map<Character, String> huffmanCodes = huffmanCodeService.generateHuffmanCodes(frequencyMap);
        String encodedText = huffmanCodeService.encode(input, huffmanCodes);

        StringBuilder output = new StringBuilder();
        output.append("Frequency Map:\n").append(frequencyMap).append("\n\n");
        output.append("Huffman Codes:\n").append(huffmanCodes).append("\n\n");
        output.append("Encoded Text:\n").append(encodedText);

        // Calculate and append compression rate
        String compressionRate = huffmanCodeService.getCompressionRate(input, encodedText);
        output.append("\nCompression Rate: ").append(compressionRate);


        outputArea.setText(output.toString());


        // For now, we'll just print the tree structure
        output.append("\n\nHuffman Tree:\n");
        huffmanCodeService.getHuffmanTree().drawHuffmanTree(huffmanCodeService.getHuffmanTree().buildTree(frequencyMap));
        outputArea.setText(output.toString());
    }

    private String validateInput(String input) {
        if (input.isEmpty()) {
            return "Error: Input text cannot be empty.";
        }

        if (input.trim().isEmpty()) {
            return "Error: Input text cannot contain only whitespace.";
        }

        if (input.length() < 5) {
            return "Error: Input text must be at least 5 characters long.";
        }

        int MAX_INPUT_LENGTH = 10000;
        if (input.length() > MAX_INPUT_LENGTH) {
            return "Error: Input text is too long. Maximum allowed length is " + MAX_INPUT_LENGTH + " characters.";
        }

        if (input.chars().distinct().count() < 2) {
            return "Error: Input must contain at least two distinct characters for Huffman coding.";
        }

        if (!input.matches("\\A\\p{ASCII}*\\z")) {
            return "Error: Input contains non-ASCII characters. Please use only ASCII characters.";
        }

        return null; // Return null if input is valid
    }
}