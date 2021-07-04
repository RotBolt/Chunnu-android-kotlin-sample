package io.rotlabs.multithreaded;

import java.util.concurrent.atomic.AtomicBoolean;

public class Resources {

    private final AtomicBoolean disallow = new AtomicBoolean(false);

    public synchronized void setDisallow() {
        disallow.set(true);
        System.out.println("Disallow is set to true");
    }

    public synchronized void process() throws InterruptedException {
        if (!disallow.get()) {
            Thread.sleep(2000);
            System.out.println("Processed. Diallowed status " + disallow.get());
        } else {
            System.out.println("Not processed. Disallowed Status " + disallow.get());
        }
    }
}
