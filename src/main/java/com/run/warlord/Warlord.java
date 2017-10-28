package com.run.warlord;

import java.util.Arrays;
import java.util.List;

import com.run.warlord.data.GameData;
import com.run.warlord.fx.GameStage;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warlord extends Application {

    private Stage menuStage;
    private Scene scene = new Scene(new VBox(20));
    private Scene newScene = new Scene(new GridPane());
    private Scene loadScene = new Scene(new VBox(20));

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void init() throws Exception {

        GameData.builder()
                .build()
                .load();

        log.info("Successfully load game data from previously saved game.");
    }

    @Override
    public void start(Stage menuStage) throws Exception {

        try {
            this.menuStage = menuStage;
            initScene();
            initNewScene();
            initLoadScene();
            menuStage.setScene(scene);
            menuStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initScene() {

        scene.getStylesheets().add("com/run/warlord/fx/menuStyle.css");
        VBox layout = (VBox) scene.getRoot();
        layout.setAlignment(Pos.CENTER);

        Text title = new Text("Warlord");
        title.setFont(new Font("SansSerif", 22));

        Button newButton = new Button("New Game");
        newButton.getStyleClass().add("button2");
        newButton.setPrefSize(150, 50);
        newButton.setOnAction(event -> menuStage.setScene(newScene));

        Button loadButton = new Button("Continue");
        loadButton.getStyleClass().add("button1");
        loadButton.setPrefSize(150, 50);
        loadButton.setOnAction(event -> menuStage.setScene(loadScene));

        Button exitButton = new Button("Exit");
        exitButton.getStyleClass().add("button1");
        exitButton.setPrefSize(150, 50);
        exitButton.setOnAction(event -> System.exit(0));

        layout.getChildren().addAll(title, newButton, loadButton, exitButton);
        menuStage.setTitle(GameData.APP_NAME + " " + GameData.APP_VERSION);
        menuStage.setWidth(800);
        menuStage.setHeight(600);
    }

    private void initNewScene() {

        newScene.getStylesheets().add("com/run/warlord/fx/menuStyle.css");
        GridPane layout = (GridPane) newScene.getRoot();
        layout.setAlignment(Pos.CENTER);

        Text title = new Text("New Game");
        title.setFont(new Font("SansSerif", 22));
        layout.add(title, 0, 0);
        GridPane.setHalignment(title, HPos.CENTER);

        Pane spring = new Pane();
        spring.setPrefHeight(100);
        layout.add(spring, 0, 1);

        List<String> images = Arrays.asList(
                "file:src/main/resources/image/warrior.png",
                "file:src/main/resources/image/archer.png",
                "file:src/main/resources/image/rogue.png",
                "file:src/main/resources/image/mage.png",
                "file:src/main/resources/image/cleric.png");

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10));
        images.stream().forEach(s -> {
            Image image = new Image(s, 100, 100, true, true);
            ImageView view = new ImageView(image);
            Button button = new Button();
            button.setGraphic(view);
            button.setOnAction(event -> {
                GameStage stage = new GameStage();
                stage.show();
                menuStage.hide();
            });
            hBox.getChildren().add(button);
        });

        layout.add(hBox, 0, 2);

        Pane spring2 = new Pane();
        spring2.setPrefHeight(100);
        layout.add(spring2, 0, 3);

        Button backButton = new Button("Back");
        backButton.getStyleClass().add("button1");
        backButton.setPrefSize(150, 50);
        backButton.setOnAction(e -> menuStage.setScene(scene));
        layout.add(backButton, 0, 4);
        GridPane.setHalignment(backButton, HPos.CENTER);
    }

    private void initLoadScene() {

        loadScene.getStylesheets().add("com/run/warlord/fx/menuStyle.css");
        VBox layout = (VBox) loadScene.getRoot();
        layout.setAlignment(Pos.CENTER);

        Text title = new Text("Load Game");
        title.setFont(new Font("SansSerif", 22));

        Button backButton = new Button("Back");
        backButton.getStyleClass().add("button1");
        backButton.setPrefSize(150, 50);
        backButton.setOnAction(e -> menuStage.setScene(scene));

        layout.getChildren().addAll(title, new Button("Entry 1"), new Button("Entry 2"), new Button("Entry 3"), backButton);
    }
}
