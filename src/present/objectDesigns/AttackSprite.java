package present.objectDesigns;


import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AttackSprite implements Sprite {

    private SpriteAnimation spriteAnimation;

    private final int COUNT = 5;
    private final int COLUMNS = 5;
    private final int OFFSET_X = 0;
    private final int OFFSET_Y = 282;
    private final int WIDTH = 442;
    private final int HEIGHT = 281;

    public AttackSprite(ImageView imageView) {
        spriteAnimation = new SpriteAnimation(
                imageView,
                Duration.millis(150),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
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
