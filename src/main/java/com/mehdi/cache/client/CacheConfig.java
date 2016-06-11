package com.mehdi.cache.client;

/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 1:09 PM
 */
public class CacheConfig {
    private String name;
    private long maxMegaBytesLocalDisk;
    private long maxMegaBytesLocalHeap;
    private long cacheValidTime;
    private long cacheReCheckingTime;

    public CacheConfig(String name) {
        this.name = name;
    }

    public CacheConfig maxMegaBytesLocalDisk(long maxMegaBytesLocalDisk) {
        this.maxMegaBytesLocalDisk = maxMegaBytesLocalDisk;
        return this;
    }

    public CacheConfig maxMegaBytesLocalHeap(long maxMegaBytesLocalHeap) {
        this.maxMegaBytesLocalHeap = maxMegaBytesLocalHeap;
        return this;
    }

    public CacheConfig cacheValidTime(long cacheValidTime) {
        this.cacheValidTime = cacheValidTime;
        return this;
    }

    public CacheConfig cacheReCheckingTime(long cacheReCheckingTime) {
        this.cacheReCheckingTime = cacheReCheckingTime;
        return this;
    }

    public String getName() {
        return name;
    }

    public long getMaxMegaBytesLocalDisk() {
        return maxMegaBytesLocalDisk;
    }

    public long getMaxMegaBytesLocalHeap() {
        return maxMegaBytesLocalHeap;
    }

    public long getCacheValidTime() {
        return cacheValidTime;
    }

    public long getCacheReCheckingTime() {
        return cacheReCheckingTime;
    }
}
