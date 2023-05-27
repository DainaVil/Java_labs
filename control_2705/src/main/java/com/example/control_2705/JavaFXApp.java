package com.example.control_2705;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFXApp extends Application {

        private ConfigurableApplicationContext applicationContext;
    
        @Override
        public void init() {
            String[] args = getParameters().getRaw().toArray(new String[0]);
    
            this.applicationContext = new SpringApplicationBuilder()
                    .sources(SpringApp.class)
                    .run(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Film Application");
            primaryStage.setWidth(600);
            primaryStage.setHeight(400);

            Label helloWorldLabel = new Label("Список фильмов");
            helloWorldLabel.setAlignment(Pos.CENTER);
            Scene primaryScene = new Scene(helloWorldLabel);

            primaryStage.setScene(primaryScene);
            primaryStage.show();
        }

        @Override
        public void stop() {
            this.applicationContext.close();
            Platform.exit();
}
    
}
