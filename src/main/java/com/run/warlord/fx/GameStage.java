package com.run.warlord.fx;

import java.util.Collections;

import com.run.warlord.data.GameData;
import com.run.warlord.entity.unit.Unit;
import com.run.warlord.model.Battle;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStage extends Stage {

    private Unit player;

    private Unit enemy;

    public GameStage() {

        Pane field = new Pane();

        player = new Unit("Player");
        player.setMaxHp(100);
        player.setStrength(10);
        player.setTranslateX(150);
        player.setTranslateY(350);

        enemy = new Unit("Enemy");
        enemy.setMaxHp(100);
        enemy.setStrength(10);
        enemy.setTranslateX(600);
        enemy.setTranslateY(350);
        field.getChildren().addAll(player, enemy);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(field);

        Scene gameScene = new Scene(layout);
        gameScene.getStylesheets().add("com/run/warlord/fx/gameStyle.css");
        gameScene.getStylesheets().add("com/run/warlord/fx/progress.css");

        setScene(gameScene);
        setTitle(GameData.APP_NAME + " " + GameData.APP_VERSION);
        setWidth(800);
        setHeight(600);

        init();
    }

    public void init() {

        Battle battle = new Battle(Collections.singletonList(player), Collections.singletonList(enemy));
        battle.start();
    }

}
