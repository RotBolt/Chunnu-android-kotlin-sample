package io.rotlabs.multithreaded;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Store {

    private List<Items> items = Arrays.asList(
            new Items("Chair", 20),
            new Items("Table", 80),
            new Items("Lamp", 40)
    );

    private ExecutorService executor = Executors.newFixedThreadPool(2);
    private Callback callback;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Store(Callback callback) {
        this.callback = callback;
    }

    public void syncPrices() {
        Lock writeLock = lock.writeLock();
        executor.execute(() -> {
            try {
                writeLock.lock();
                System.out.println("syncing...");
                Thread.sleep(500);
                items.get(0).setValue(49);
                items.get(1).setValue(50);
                items.get(2).setValue(45);
                System.out.println("Latest total " + getTotal());
                callback.onSync();
                writeLock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void preparePrice() {
        Lock readLock = lock.readLock();
        executor.execute(() -> {
            readLock.lock();
            int total = getTotal();
            System.out.println("Invoice price total " + total);
            callback.onPrepare(total);
            readLock.unlock();
        });
    }

    private int getTotal() {
        int total = 0;
        for (Items item : items) {
            total += item.getValue();
        }
        return total;
    }

    interface Callback {
        void onSync();

        void onPrepare(int total);
    }
}
