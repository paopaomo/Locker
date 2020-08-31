package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private List<Bag> locker = new ArrayList<>();
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Receipt storageBag(Bag bag) {
        locker.add(bag);
        return new Receipt();
    }
}
