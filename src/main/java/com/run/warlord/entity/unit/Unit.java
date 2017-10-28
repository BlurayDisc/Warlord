package com.run.warlord.entity.unit;

import com.run.warlord.entity.item.loadout.BodySlot;
import com.run.warlord.entity.item.loadout.FootSlot;
import com.run.warlord.entity.item.loadout.HeadSlot;
import com.run.warlord.entity.item.loadout.LeftHandSlot;
import com.run.warlord.entity.item.loadout.LegSlot;
import com.run.warlord.entity.item.loadout.NecklaceSlot;
import com.run.warlord.entity.item.loadout.RightHandSlot;
import com.run.warlord.entity.item.loadout.RingSlot;
import com.run.warlord.entity.item.loadout.WriestSlot;
import com.run.warlord.model.Damage;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Unit extends VBox {

    protected IntegerProperty maxHp;
    protected IntegerProperty currentHp;

    protected int strength;
    protected int agility;
    protected int intelligence;

    private HeadSlot headSlot;
    private BodySlot bodySlot;
    private LeftHandSlot leftHandSlot;
    private RightHandSlot rightHandSlot;
    private WriestSlot wriestSlot;
    private LegSlot legSlot;
    private FootSlot footSlot;
    private NecklaceSlot necklaceSlot;
    private RingSlot ringSlot;

    private ProgressBar hpBar;
    private Text name;
    private ImageView model;

    public Unit(String unitName) {

        this.name = new Text(unitName);
        this.name.setFill(unitName.equals("Player") ? Color.RED : Color.BLUE);

        this.maxHp = new SimpleIntegerProperty(1);
        this.currentHp = new SimpleIntegerProperty(1);

        this.hpBar = new ProgressBar();
        this.hpBar.getStyleClass().add("green-bar");
        this.hpBar.progressProperty().bind(Bindings.createDoubleBinding(() -> (double) currentHp.get(), currentHp).divide(maxHp));
        this.hpBar.setPrefWidth(100);

        this.model = new ImageView(new Image("file:src/main/resources/image/warrior.png", 100, 100, true, true));

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(name, hpBar, model);
    }

    public boolean isAlive() {

        return currentHp.get() > 0;
    }

    public Point2D moveTo(Unit target) {

        log.info("{} moving to target {}", this.getName(), target.getName());

        Point2D targetLocation = getUnitLocation(target);

        return moveTo(targetLocation);
    }

    public Point2D moveTo(Point2D targetLocation) {

        Point2D currentLocation = new Point2D(this.getTranslateX(), this.getTranslateY());

        log.info("{} {} moving to {}", this.getName(), currentLocation, targetLocation);

        playMoveAnimation(targetLocation);

        return currentLocation;
    }

    public Damage attack(Unit target) {

        Damage damage = new Damage(this.strength);

        log.info("{} [{}/{}] attacked {} [{}/{}] with {}",
                this.getName(),
                this.getCurrentHp(),
                this.getMaxHp(),
                target.getName(),
                target.getCurrentHp(),
                target.getMaxHp(),
                damage);

        playAttackAnimation(target);

        return damage;
    }

    public void receiveDamage(Unit target, Damage damage) {

        this.currentHp.set(this.currentHp.get() - damage.getAmount());

        log.info("{} [{}/{}] received {}",
                this.getName(),
                this.getCurrentHp(),
                this.getMaxHp(),
                damage);

        playDamagedAnimation(target);
    }

    private void playMoveAnimation(Point2D target) {

        log.info("{} {} {}", this.getTranslateX(), this.getTranslateY(), target);

        TranslateTransition animation = new TranslateTransition(Duration.seconds(1), this);
        animation.setFromX(this.getTranslateX());
        animation.setFromY(this.getTranslateY());
        animation.setToX(target.getX());
        animation.setToY(target.getY());
        animation.setCycleCount(1);
        animation.setAutoReverse(false);
        animation.setInterpolator(Interpolator.EASE_OUT);
        animation.play();

        awaitComplete(animation);
    }

    private void playAttackAnimation(Unit target) {

        RotateTransition animation = new RotateTransition(Duration.millis(300), this.model);
        animation.setByAngle(this.getTranslateX() < target.getTranslateX() ? 45 : -45);
        animation.setCycleCount(2);
        animation.setAutoReverse(true);
        animation.play();

        await(100);
    }

    private void playDamagedAnimation(Unit target) {

        RotateTransition animation = new RotateTransition(Duration.millis(300), this.model);
        animation.setByAngle(this.getTranslateX() < target.getTranslateX() ? -10 : 10);
        animation.setCycleCount(2);
        animation.setAutoReverse(true);
        animation.play();

        awaitComplete(animation);
    }

    private Point2D getUnitLocation(Unit target) {

        double x;
        if (this.getTranslateX() < target.getTranslateX()) {
            x = target.getTranslateX() - target.model.getImage().getWidth();
        } else {
            x = target.getTranslateX() + target.model.getImage().getWidth();
        }

        double y = target.getTranslateY();

        return new Point2D(x, y);
    }

    /**
     * <p>
     * Awaits for this animation to complete, assume the battle loop is being executed in a different thread.
     * 
     * @param animation The animation to await for completion.
     */
    private void awaitComplete(Animation animation) {

        while (animation.getStatus() == Status.RUNNING) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error("I was interrupted during sleep", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void await(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("I was interrupted during sleep", e);
            Thread.currentThread().interrupt();
        }
    }

    public int getMaxHp() {

        return maxHp.get();
    }

    public void setMaxHp(int maxHp) {

        this.maxHp.set(maxHp);
        this.currentHp.set(maxHp);
    }

    public int getStrength() {

        return strength;
    }

    public void setStrength(int strength) {

        this.strength = strength;
    }

    public int getAgility() {

        return agility;
    }

    public void setAgility(int agility) {

        this.agility = agility;
    }

    public int getIntelligence() {

        return intelligence;
    }

    public void setIntelligence(int intelligence) {

        this.intelligence = intelligence;
    }

    public HeadSlot getHeadSlot() {

        return headSlot;
    }

    public void setHeadSlot(HeadSlot headSlot) {

        this.headSlot = headSlot;
    }

    public BodySlot getBodySlot() {

        return bodySlot;
    }

    public void setBodySlot(BodySlot bodySlot) {

        this.bodySlot = bodySlot;
    }

    public LeftHandSlot getLeftHandSlot() {

        return leftHandSlot;
    }

    public void setLeftHandSlot(LeftHandSlot leftHandSlot) {

        this.leftHandSlot = leftHandSlot;
    }

    public RightHandSlot getRightHandSlot() {

        return rightHandSlot;
    }

    public void setRightHandSlot(RightHandSlot rightHandSlot) {

        this.rightHandSlot = rightHandSlot;
    }

    public WriestSlot getWriestSlot() {

        return wriestSlot;
    }

    public void setWriestSlot(WriestSlot wriestSlot) {

        this.wriestSlot = wriestSlot;
    }

    public LegSlot getLegSlot() {

        return legSlot;
    }

    public void setLegSlot(LegSlot legSlot) {

        this.legSlot = legSlot;
    }

    public FootSlot getFootSlot() {

        return footSlot;
    }

    public void setFootSlot(FootSlot footSlot) {

        this.footSlot = footSlot;
    }

    public NecklaceSlot getNecklaceSlot() {

        return necklaceSlot;
    }

    public void setNecklaceSlot(NecklaceSlot necklaceSlot) {

        this.necklaceSlot = necklaceSlot;
    }

    public RingSlot getRingSlot() {

        return ringSlot;
    }

    public void setRingSlot(RingSlot ringSlot) {

        this.ringSlot = ringSlot;
    }

    public String getName() {

        return name.getText();
    }

    public ImageView getModel() {

        return model;
    }

    public int getCurrentHp() {

        return currentHp.get();
    }
}
