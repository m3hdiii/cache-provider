package com.mehdi.cache;

import com.mehdi.cache.client.CacheConfig;
import com.mehdi.cache.client.pb.PersonBiometricCacheService;
import com.mehdi.cache.client.sc.SearchCandidateCacheService;
import com.mehdi.cache.model.PersonBioMetric;
import com.mehdi.cache.server.PersonBiometricCache;
import org.junit.Test;

import java.util.Date;

/**
 * @author Mehdi Afsari kashi
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Creation Date : 2016/06/11
 */
public class Launcher {

    /**
     * NOT TESTED
     */
    @Test
    public void launch() {
        CacheConfig cacheConfig = new CacheConfig("INQUIRY")
                .maxMegaBytesLocalDisk(1000)
                .maxMegaBytesLocalHeap(1024)
                .cacheValidTime(1001001001)
                .cacheReCheckingTime(1212121212);

        PersonBiometricCacheService.getInstance().configure(new PersonBiometricCache() {
            public PersonBioMetric getRequestPersonBioMetric(long inquiryId) {
                return null;
            }

            public PersonBioMetric getCvPersonBioMetric(long recordNo) {
                return null;
            }

            public PersonBioMetric getCrPersonBioMetric(long recordNo) {
                return null;
            }

            public long getRequestPersonNistModifiedTimestamp(long inquiryId) {
                return 0;
            }

            public long getCvPersonNistModifiedTimestamp(long recordNo) {
                return 0;
            }

            public long getCrPersonNistModifiedTimestamp(long recordNo) {
                return 0;
            }
        }, cacheConfig);



        SearchCandidateCacheService.getInstance().configure(new PersonBiometricCache() {
            public PersonBioMetric getRequestPersonBioMetric(long inquiryId) {
                return null;
            }

            public PersonBioMetric getCvPersonBioMetric(long recordNo) {
                return null;
            }

            public PersonBioMetric getCrPersonBioMetric(long recordNo) {
                return null;
            }

            public long getRequestPersonNistModifiedTimestamp(long inquiryId) {
                return 0;
            }

            public long getCvPersonNistModifiedTimestamp(long recordNo) {
                return 0;
            }

            public long getCrPersonNistModifiedTimestamp(long recordNo) {
                return 0;
            }
        }, cacheConfig);
        System.out.println(new Date().toString() + ": Cache configured successfully.");

    }
}
