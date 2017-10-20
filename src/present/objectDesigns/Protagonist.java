package present.objectDesigns;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import present.ImageViewPane;

public class Protagonist {
    private ImageViewPane imageViewPane;

    public Protagonist() {
        Image image = new Image(Protagonist.class.getResourceAsStream("/design/protagonist/Plane/Fly (1).png"));
        imageViewPane = new ImageViewPane(new ImageView(image));
    }

    public ImageViewPane getImageViewPane() {
        return imageViewPane;
    }

    public void setImageViewPane(ImageViewPane imageViewPane) {
        this.imageViewPane = imageViewPane;
    }
}
