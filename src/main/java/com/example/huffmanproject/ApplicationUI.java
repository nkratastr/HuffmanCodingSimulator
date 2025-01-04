package com.example.huffmanproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.huffmanproject.service.HuffmanTreeService;
import com.example.huffmanproject.service.HuffmanCodeService;

import java.io.IOException;

public class ApplicationUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationUI.class.getResource("hello-view.fxml"));

        // Create instances of HuffmanTreeService and HuffmanCodeService
        HuffmanTreeService treeService = new HuffmanTreeService();
        HuffmanCodeService codeService = new HuffmanCodeService(treeService);

        // Load the FXML and get the controller
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        ApplicationUIController controller = fxmlLoader.getController();

        // Set the HuffmanCodeService in the controller
        controller.setHuffmanCodeService(codeService);

        stage.setTitle("Huffman Coding");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}