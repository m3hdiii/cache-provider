package com.mehdi.cache.client.pb;

import java.io.Serializable;

/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 3:00 PM
 */
public class PersonBiometricCompoundKey implements Serializable {
    private Long id;
    private IdType idType;

    public PersonBiometricCompoundKey(Long id, IdType idType) {
        this.id = id;
        this.idType = idType;
    }

    public enum IdType {
        INQUIRY_ID, RECORD_NO
    }

    public Long getId() {
        return id;
    }

    public IdType getIdType() {
        return idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonBiometricCompoundKey)) return false;

        PersonBiometricCompoundKey that = (PersonBiometricCompoundKey) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return idType == that.idType;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        return result;
    }
}
