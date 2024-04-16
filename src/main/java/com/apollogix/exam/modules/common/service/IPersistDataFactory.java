package com.apollogix.exam.modules.common.service;


import com.apollogix.exam.modules.common.exception.InvalidException;

/**
 * IPersistDataFactory
 *
 * @param <I> info tupe
 * @param <D> detail type
 * @param <E> entity type
 */
public interface IPersistDataFactory<I, D extends I, E> {
    E createConvertToEntity(D detail) throws InvalidException;

    void updateConvertToEntity(E entity, D detail) throws InvalidException;

    D convertToDetail(E entity) throws InvalidException;

    I convertToInfo(E entity) throws InvalidException;
}
