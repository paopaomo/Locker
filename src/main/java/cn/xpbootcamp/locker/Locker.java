package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Map<Receipt, Bag> locker = new HashMap<>();
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Receipt storageBag(Bag bag) {
        if(locker.keySet().size() == capacity) {
            throw new LockerIsFullException();
        }
        Receipt receipt = new Receipt();
        locker.put(receipt, bag);
        return receipt;
    }

    public Bag takeBag(Receipt receipt) {
        return locker.get(receipt);
    }
}
