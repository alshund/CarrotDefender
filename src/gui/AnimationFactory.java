package gui;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shund on 29.09.2017.
 */
public class AnimationFactory {
    private Map<String, AnimationObject> animationObjects;

    public AnimationFactory() {
        animationObjects = new HashMap<>();
    }

    public AnimationObject getAnimationObject(String animationObjectName) {
        AnimationObject animationObject = animationObjects.get(animationObjectName);
        if (animationObject == null) {
            switch (animationObjectName) {
                case "Bullet":
                    animationObject = new Bullet();
            }
            animationObjects.put(animationObjectName, animationObject);
        }
        return animationObject;
    }
}
