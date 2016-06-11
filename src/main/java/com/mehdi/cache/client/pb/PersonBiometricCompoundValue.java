package com.mehdi.cache.client.pb;

import com.mehdi.cache.model.PersonBioMetric;

import java.io.Serializable;

/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 3:00 PM
 */
public class PersonBiometricCompoundValue implements Serializable {
    private PersonBioMetric bioMetric;
    private long modifiedTimestamp;

    public PersonBiometricCompoundValue(PersonBioMetric bioMetric, long modifiedTimestamp) {
        this.bioMetric = bioMetric;
        this.modifiedTimestamp = modifiedTimestamp;
    }

    public long getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public PersonBioMetric getBioMetric() {
        return bioMetric;
    }
}
