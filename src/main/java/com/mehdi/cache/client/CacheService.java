package com.mehdi.cache.client;


import com.mehdi.cache.server.Cacheable;
import net.sf.ehcache.Cache;


/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 11:59 AM
 */
public abstract class CacheService {
    protected CacheProvider provider;
    protected CacheConfig config;
    protected Cache cache;

    public abstract void configure(Cacheable cacheable, CacheConfig config);

    public void configure(CacheConfig config){
        if (config == null)
            throw new NullPointerException("CacheConfig is null.");
        this.config = config;
        this.cache = CacheProvider.getInstance(config).getCache();
    }
}
