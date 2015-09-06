package com.run.warlord;

import com.run.warlord.data.GameData;

import javafx.application.Application;
import javafx.stage.Stage;

public class warlord extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GameData data = new GameData();
		data.load();
		System.out.println(data);
		
	}
}
