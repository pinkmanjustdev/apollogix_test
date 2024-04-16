package com.apollogix.exam.modules.common.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IBaseData;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;

import java.util.List;

public interface IDataService<I, T extends IBaseData<I>, U extends T> {

    U createModel(U detail) throws InvalidException;

    U updateModel(I id, U detail) throws InvalidException;

    boolean deleteModel(I id) throws InvalidException;

    List<T> getInfoList() throws InvalidException;

    U getDetailModel(I id) throws InvalidException;

    boolean existByDetail(U detail) throws InvalidException;

    <F extends IFilter> U getDetailModel(I id, F filter) throws InvalidException;

    <F extends IFilter> BasePagingResponse<T> getInfoPage(F filter, Integer number, Integer size) throws InvalidException;

}
