package com.mehdi.cache.client;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.*;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 11:58 AM
 */
public class CacheProvider {
    private static CacheProvider instance;
    private final CacheManager manager;
    private Cache cache;

    private CacheProvider(CacheConfig config) {
        this.manager = createCacheManager();
        addCache(config);
        this.cache = manager.getCache(config.getName());
    }

    public static CacheProvider getInstance(CacheConfig cacheConfig) {
        if (instance == null)
            instance = new CacheProvider(cacheConfig);
        return instance;
    }

    private CacheManager createCacheManager() {
        Configuration configuration = new Configuration().diskStore(
                new DiskStoreConfiguration()
//                        .path("/tmp/ehcache")
        );
        return CacheManager.newInstance(configuration);
    }

    public void addCache(CacheConfig config) {
        CacheConfiguration cacheConfiguration = new CacheConfiguration()
                .name(config.getName())
                .maxBytesLocalDisk(config.getMaxMegaBytesLocalDisk(), MemoryUnit.MEGABYTES)
                .maxBytesLocalHeap(config.getMaxMegaBytesLocalDisk(), MemoryUnit.MEGABYTES)
                .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO)
                .eternal(false)
                .timeToLiveSeconds(config.getCacheValidTime())
                .persistence(new PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP));

        manager.addCache(new Cache(cacheConfiguration));
    }

    public CacheManager getManager() {
        return manager;
    }

    public Cache getCache() {
        return cache;
    }
}
