package io.rotlabs.multithreaded;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
//        Resources resources = new Resources();
//        Thread t1 = new Thread(()->{
//            try {
//                resources.process();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(resources::setDisallow);
//
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Terminated");

        AtomicBoolean prep = new AtomicBoolean(true);
        AtomicBoolean sync = new AtomicBoolean(true);
        Store store = new Store(new Store.Callback() {
            @Override
            public void onSync() {
                sync.set(false);
            }

            @Override
            public void onPrepare(int total) {
                prep.set(false);
            }
        });

        store.syncPrices();
        store.preparePrice();

        while (prep.get() || sync.get()) {

        }


        System.out.println("Terminated! kaboom");

    }
}
