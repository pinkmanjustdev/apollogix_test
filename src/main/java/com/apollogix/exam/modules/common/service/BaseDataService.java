package com.apollogix.exam.modules.common.service;

import com.apollogix.exam.modules.common.exception.ErrorCode;
import com.apollogix.exam.modules.common.exception.IErrorCode;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IBaseData;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class BaseDataService<I, T extends IBaseData<I>, U extends T, E> implements IDataService<I, T, U>, IPersistDataFactory<T, U, E> {
    protected final PagingAndSortingRepository<E, I> repository;

    protected BaseDataService(PagingAndSortingRepository<E, I> repository) {
        this.repository = repository;
    }

    @Override
    public U createModel(U detail) throws InvalidException {
        E entity = repository.save(createConvertToEntity(detail));
        postCreate(entity, detail);
        return convertToDetail(entity);
    }

    @Override
    public U updateModel(I id, U detail) throws InvalidException {
        E entity = getEntity(id, null).orElseThrow(() -> new InvalidException(notFound()));
        updateConvertToEntity(entity, detail);
        entity = repository.save(entity);
        return convertToDetail(entity);
    }

    @Override
    public boolean deleteModel(I id) throws InvalidException {
        repository.deleteById(id);
        return false;
    }

    @Override
    public List<T> getInfoList() throws InvalidException {
        return convertList(repository.findAll());
    }

    @Override
    public boolean existByDetail(U detail) throws InvalidException {
        if (detail.getId() != null) {
            return repository.existsById(detail.getId());
        }
        return false;
    }

    @Override
    public U getDetailModel(I id) throws InvalidException {
        E entity = getEntity(id, null).orElseThrow(() -> new InvalidException(notFound()));
        U detail = convertToDetail(entity);
        postGetDetail(entity, detail);
        return detail;
    }

    protected Optional<E> getEntity(I id, U detail) throws InvalidException {
        return repository.findById(id);
    }

    @Override
    public <F extends IFilter> U getDetailModel(I id, F filter) throws InvalidException {
        U detail = aroundGetDetail(id, filter);
        if (detail == null) {
            throw new InvalidException(notFound());
        }
        return null;
    }

    protected abstract <F extends IFilter> U aroundGetDetail(I id, F filter) throws InvalidException;

    protected List<T> convertList(Iterable<E> entities) throws InvalidException {
        List<T> response = new ArrayList<>();
        for (E entity : entities) {
            response.add(convertToInfo(entity));
        }
        return response;
    }

    @Override
    public <F extends IFilter> BasePagingResponse<T> getInfoPage(F filter, Integer number, Integer size) throws InvalidException {
        BasePagingResponse<T> response = postGetPage(filter, number, size);
        return response;
    }

    protected abstract <F extends IFilter> BasePagingResponse<T> postGetPage(F filter, Integer number, Integer size) throws InvalidException;

    protected void postCreate(E entity, U detail) throws InvalidException {
    }

    protected void postGetDetail(E entity, U detail) throws InvalidException {
    }

    protected IErrorCode notFound() {
        return ErrorCode.NOT_FOUND;
    }
}
