package cn.xpbootcamp.locker;

public interface Storable {
    Receipt saveBag(Bag bag);

    Bag takeBag(Receipt receipt);

    boolean hasAvailableCapacity();

    boolean existedReceipt(Receipt receipt);

    int getAvailableCapacity();

    int getCapacity();

    StringBuilder getReport();
}
