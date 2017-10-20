package present.objectDesigns;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import present.ImageViewPane;

public class Protagonist {
    private ImageViewPane imageViewPane;
    private Sprite flightSprite;
    private Sprite attackSprite;

    public Protagonist() {
        Image image = new Image(Protagonist.class.getResourceAsStream("/design/protagonist/Plane/plane.png"));
        ImageView imageView = new ImageView(image);
        flightSprite = new FlightSprite(imageView);
        attackSprite = new AttackSprite(imageView);
        imageViewPane = new ImageViewPane(imageView);
    }

    public void playFlightSprite() {
        flightSprite.play();
    }

    public void playAttackSprite() {
        attackSprite.play();
    }

    public ImageViewPane getImageViewPane() {
        return imageViewPane;
    }

    public void setImageViewPane(ImageViewPane imageViewPane) {
        this.imageViewPane = imageViewPane;
    }
}
