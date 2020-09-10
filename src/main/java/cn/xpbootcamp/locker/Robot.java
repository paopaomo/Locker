package cn.xpbootcamp.locker;

import java.util.List;

public abstract class Robot implements Storable {
    protected final List<Locker> lockers;

    public Robot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    @Override
    public abstract Receipt saveBag(Bag bag);

    @Override
    public Bag takeBag(Receipt receipt) {
        for(Locker locker: lockers) {
            if(locker.existedReceipt(receipt)) {
                return locker.takeBag(receipt);
            }
        }
        throw new ReceiptIsInvalidException();
    }

    @Override
    public boolean hasAvailableCapacity() {
        for(Locker locker: lockers) {
            if(locker.hasAvailableCapacity()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedReceipt(Receipt receipt) {
        for(Locker locker: lockers) {
            if(locker.existedReceipt(receipt)) {
                return true;
            }
        }
        return false;
    }

    public int getAvailableCapacity() {
        int availableCapacity = 0;
        for(Locker locker: lockers) {
            availableCapacity += locker.getAvailableCapacity();
        }
        return availableCapacity;
    }

    public int getCapacity() {
        int capacity = 0;
        for(Locker locker: lockers) {
            capacity += locker.getCapacity();
        }
        return capacity;
    }

    public StringBuilder getReport() {
        StringBuilder info = new StringBuilder("R " + getAvailableCapacity() + " " + getCapacity());
        for(Locker locker: lockers) {
            info.append("\n").append("\t\t").append(locker.getReport());
        }
        return info;
    }
}
