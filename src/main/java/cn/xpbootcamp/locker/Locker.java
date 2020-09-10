package cn.xpbootcamp.locker;

import java.util.*;

public class Locker implements Storable {
    private Map<Receipt, Bag> receiptBagRelation = new HashMap<>();
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Receipt saveBag(Bag bag) {
        if(hasAvailableCapacity()) {
            Receipt receipt = new Receipt();
            receiptBagRelation.put(receipt, bag);
            return receipt;
        }
        throw new LockerIsFullException();
    }

    @Override
    public Bag takeBag(Receipt receipt) {
        if(receiptBagRelation.containsKey(receipt)) {
            return receiptBagRelation.remove(receipt);
        }
        throw new ReceiptIsInvalidException();
    }

    @Override
    public boolean hasAvailableCapacity() {
        return receiptBagRelation.size() < capacity;
    }

    @Override
    public boolean existedReceipt(Receipt receipt) {
        return receiptBagRelation.containsKey(receipt);
    }

    public int getAvailableCapacity() {
        return capacity - receiptBagRelation.size();
    }

    public int getCapacity() { return capacity; }

    public StringBuilder getReport() {
        return new StringBuilder("L " + getAvailableCapacity() + " " + getCapacity());
    }
}
