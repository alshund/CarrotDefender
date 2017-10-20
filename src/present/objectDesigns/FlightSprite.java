package present.objectDesigns;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FlightSprite implements Sprite {

    private SpriteAnimation spriteAnimation;

    private final int COUNT = 2;
    private final int COLUMNS = 2;
    private final int OFFSET_X = 0;
    private final int OFFSET_Y = 0;
    private final int WIDTH = 442;
    private final int HEIGHT = 281;

    public FlightSprite(ImageView imageView) {
        spriteAnimation = new SpriteAnimation(
                imageView,
                Duration.millis(150),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        spriteAnimation.setCycleCount(Animation.INDEFINITE);
    }


    @Override
    public void play() {
        spriteAnimation.play();
    }

    @Override
    public void pause() {
        spriteAnimation.pause();
    }
}
