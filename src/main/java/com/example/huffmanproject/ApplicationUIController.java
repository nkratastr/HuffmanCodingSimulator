package com.example.huffmanproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import com.example.huffmanproject.service.HuffmanCodeService;

import java.util.Map;

public class HelloController {
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
        Map<Character, Integer> frequencyMap = huffmanCodeService.calculateFrequency(input);
        Map<Character, String> huffmanCodes = huffmanCodeService.generateHuffmanCodes(frequencyMap);
        String encodedText = huffmanCodeService.encode(input, huffmanCodes);

        StringBuilder output = new StringBuilder();
        output.append("Frequency Map:\n").append(frequencyMap).append("\n\n");
        output.append("Huffman Codes:\n").append(huffmanCodes).append("\n\n");
        output.append("Encoded Text:\n").append(encodedText);

        outputArea.setText(output.toString());


        // For now, we'll just print the tree structure
        output.append("\n\nHuffman Tree:\n");
        huffmanCodeService.getHuffmanTree().drawHuffmanTree(huffmanCodeService.getHuffmanTree().buildTree(frequencyMap));
        outputArea.setText(output.toString());
    }
}