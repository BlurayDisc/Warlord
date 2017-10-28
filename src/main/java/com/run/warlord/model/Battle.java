package com.run.warlord.model;

import java.util.List;

import com.run.warlord.entity.unit.Unit;

import javafx.concurrent.Task;
import javafx.geometry.Point2D;

public class Battle {

    private List<Unit> playerUnits;

    private List<Unit> enemyUnits;

    public Battle(List<Unit> playerUnits, List<Unit> enemyUnits) {
        this.playerUnits = playerUnits;
        this.enemyUnits = enemyUnits;
    }

    public void start() {

        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                while (true) {

                    playerUnits.forEach(playerUnit -> {

                        performAttack(playerUnit, nextAlive(enemyUnits));
                    });

                    if (!enemyUnits.stream().anyMatch(Unit::isAlive)) {
                        break;
                    }

                    enemyUnits.forEach(enemyUnit -> {

                        performAttack(enemyUnit, nextAlive(playerUnits));
                    });

                    if (!playerUnits.stream().anyMatch(Unit::isAlive)) {
                        break;
                    }
                }

                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public void debug() {

        Point2D originalLocation = playerUnits.get(0).moveTo(enemyUnits.get(0));
        playerUnits.get(0).moveTo(originalLocation);
    }

    private void performAttack(Unit self, Unit target) {

        Point2D originalLocation = self.moveTo(target);
        Damage damage = self.attack(target);
        target.receiveDamage(self, damage);
        self.moveTo(originalLocation);
    }

    private Unit nextAlive(List<Unit> units) {

        return units.stream()
                .filter(Unit::isAlive)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("All units are dead"));
    }
}
