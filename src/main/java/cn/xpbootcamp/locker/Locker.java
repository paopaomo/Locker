package cn.xpbootcamp.locker;

import java.util.*;

public class Locker {
    private Map<Receipt, Bag> locker = new HashMap<>();
    private int capacity;
    private List<Receipt>hasBeenTakenReceipts = new ArrayList<>();

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
        for (Receipt hasBeenTakenReceipt : hasBeenTakenReceipts) {
            if (hasBeenTakenReceipt == receipt) {
                throw new BagHasBeenPickedUpException();
            }
        }
        if(locker.get(receipt) == null) {
            throw new ReceiptIsInvalidException();
        }
        hasBeenTakenReceipts.add(receipt);
        return locker.remove(receipt);
    }
}
