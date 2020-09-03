package cn.xpbootcamp.locker;

import java.util.*;

public class Locker {
    private Map<Receipt, Bag> receiptBagRelation = new HashMap<>();
    private int capacity;
    private List<Receipt> hasBeenTakenReceipts = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Receipt saveBag(Bag bag) {
        if(hasAvailableCapacity()) {
            Receipt receipt = new Receipt();
            receiptBagRelation.put(receipt, bag);
            return receipt;
        }
        throw new LockerIsFullException();
    }

    public Bag takeBag(Receipt receipt) {
        if(hasBeenTakenReceipts.contains(receipt)) {
            throw new BagHasBeenPickedUpException();
        }
        if(receiptBagRelation.containsKey(receipt)) {
            hasBeenTakenReceipts.add(receipt);
            return receiptBagRelation.remove(receipt);
        }
        throw new ReceiptIsInvalidException();
    }

    public boolean hasAvailableCapacity() {
        return receiptBagRelation.size() < capacity;
    }

    public boolean existedReceipt(Receipt receipt) {
        return receiptBagRelation.containsKey(receipt);
    }

    public int getAvailableCapacity() {
        return capacity - receiptBagRelation.size();
    }
}
