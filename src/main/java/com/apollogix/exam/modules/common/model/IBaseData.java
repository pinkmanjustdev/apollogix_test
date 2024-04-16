package com.apollogix.exam.modules.common.model;

import java.io.Serializable;

/**
 * Base data model
 *
 * @param <T> id type
 */
public interface IBaseData<T> extends Serializable {
    /**
     * Get id
     *
     * @return id
     */
    T getId();
}