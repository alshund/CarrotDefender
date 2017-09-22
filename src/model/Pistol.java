package model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Pistol implements Weapon {
    private final int BULLETS_COUNT = 7;
    private Stack<BulletModel> store;

    public Pistol() {
        store = new Stack<BulletModel>();
        charge();
    }

    @Override
    public BulletModel fire() {
        if (store.isEmpty()) charge();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        return store.pop();
    }

    public void charge() {
        for (int bulletIndex = 0; bulletIndex < BULLETS_COUNT; bulletIndex++) {
            store.push(new BulletModel());
        }
    }
}
