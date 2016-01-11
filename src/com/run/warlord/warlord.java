package com.run.warlord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Warlord extends Application {
	
	private Stage primaryStage;
	private Scene scene = new Scene(new VBox(20));
	private Scene newScene = new Scene(new GridPane());
	private Scene loadScene = new Scene(new VBox(20));
	
	private static final List<String> IMAGE_PATHS = Arrays.asList(
			"file:resources/warrior.png",
			"file:resources/archer.png",
			"file:resources/rogue.png",
			"file:resources/mage.png",
			"file:resources/cleric.png");
	
	private static final List<Button> HERO_IMAGES = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		for (String path: IMAGE_PATHS) {
			//String name = path.split("/")[1];
			Node node = new ImageView(new Image(path, 100, 100, true, true));
			HERO_IMAGES.add(new Button("", node));
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			this.primaryStage = primaryStage;
			initScene();
			initNewScene();
			initLoadScene();
			initGameScene();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initScene() {
		scene.getStylesheets().add("com/run/warlord/fx/menuStyle.css");
		VBox layout = (VBox) scene.getRoot();
		layout.setPrefSize(500, 500);
		layout.setAlignment(Pos.CENTER);
		
        Text title = new Text("Warlord");
        title.setFont(new Font("SansSerif", 22));
        
		Button newButton = new Button("New Game");
		newButton.getStyleClass().add("button2");
		newButton.setOnAction(event -> primaryStage.setScene(newScene));
		
		Button loadButton = new Button("Continue");
		loadButton.getStyleClass().add("button1");
		loadButton.setOnAction(event -> primaryStage.setScene(loadScene));
		
		Button exitButton = new Button("Exit");
		exitButton.getStyleClass().add("button1");
		exitButton.setOnAction(event -> System.exit(0));
		
		layout.getChildren().addAll(title, newButton, loadButton, exitButton);
	}
	
	private void initNewScene() {
		newScene.getStylesheets().add("com/run/warlord/fx/menuStyle.css");
		GridPane layout = (GridPane) newScene.getRoot();
		layout.setPrefSize(500, 500);
		
        Text title = new Text("New Game");
        title.setFont(new Font("SansSerif", 22));
        layout.add(title, 2, 0);
		layout.getRowConstraints().add(new RowConstraints(150));
		
		Pane spring = new Pane();
		spring.setPrefHeight(100);
		layout.add(spring, 2, 3);
		
		Button backButton = new Button("Back");
		backButton.getStyleClass().add("button1");
		backButton.setOnAction(e -> primaryStage.setScene(scene));
		layout.add(backButton, 2, 4);
		
		for (int i = 0; i < HERO_IMAGES.size(); i++) {
			if (i < HERO_IMAGES.size() - 1) {
				layout.getColumnConstraints().add(new ColumnConstraints(150));
			}
			layout.add(HERO_IMAGES.get(i), i, 2);
		}
	}
	
	private void initLoadScene() {
		loadScene.getStylesheets().add("com/run/warlord/fx/menuStyle.css");
		VBox layout = (VBox) loadScene.getRoot();
		layout.setPrefSize(500, 500);
		layout.setAlignment(Pos.CENTER);
		
        Text title = new Text("Load Game");
        title.setFont(new Font("SansSerif", 22));
        
		Button backButton = new Button("Back");
		backButton.getStyleClass().add("button1");
		backButton.setOnAction(e -> primaryStage.setScene(scene));
        
        layout.getChildren().addAll(title, new Button("Entry 1"), new Button("Entry 2"), new Button("Entry 3"), backButton);
	}
	
	private void initGameScene() {
		
	}
}
