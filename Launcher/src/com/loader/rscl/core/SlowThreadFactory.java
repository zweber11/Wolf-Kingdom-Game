package com.loader.rscl.core;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

public class SlowThreadFactory implements ThreadFactory
{
    private static final AtomicInteger poolNumber;
    private final ThreadGroup group;
    private final AtomicInteger threadNumber;
    private final String namePrefix;
    
    static {
        poolNumber = new AtomicInteger(1);
    }
    
    public SlowThreadFactory() {
        this.threadNumber = new AtomicInteger(1);
        final SecurityManager s = System.getSecurityManager();
        this.group = ((s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup());
        this.namePrefix = "Slow Pool-" + SlowThreadFactory.poolNumber.getAndIncrement() + "-thread-";
    }
    
    @Override
    public Thread newThread(final Runnable r) {
        final Thread t = new Thread(this.group, r, String.valueOf(this.namePrefix) + this.threadNumber.getAndIncrement(), 0L);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != 1) {
            t.setPriority(1);
        }
        return t;
    }
}
