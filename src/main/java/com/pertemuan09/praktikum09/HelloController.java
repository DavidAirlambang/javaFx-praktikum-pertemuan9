package com.pertemuan09.praktikum09;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class HelloController {
    public TextArea text;
    public Button open;
    public Button saveAs;
    public Button save;
    private Path locked = null;

    public void open(ActionEvent actionEvent) {

        text.clear();
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(text.getScene().getWindow());
        locked = Paths.get(f.toURI());
        try {
            String t = String.valueOf(Files.readString(locked));
            text.appendText(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveAs() {

        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(save.getScene().getWindow());
        locked = Paths.get(f.toURI());
        try {
            Files.write(locked, Collections.singleton(text.getText()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void save(ActionEvent actionEvent) {

        if (locked == null){
            saveAs();
        } else {
            try {
                Files.write(locked, Collections.singleton(text.getText()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}