package com.example.control_2705;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.control_2705.service.FilmService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("main_page.fxml")
public class MainController {
    @FXML
    private Label weatherLabel;
    private FilmService filmService;

    @Autowired
    public void Controller(FilmService filmService) {
        this.filmService = filmService;
    }

    //метод должен выводить список фильмовб но пока даже строку не выводит
    // public void loadFilms(ActionEvent actionEvent) {
    //     this.weatherLabel.setTextFill(filmService.getAllFilms());
    // }
}
