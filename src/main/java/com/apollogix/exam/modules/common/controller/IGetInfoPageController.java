package com.apollogix.exam.modules.common.controller;

import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.IBaseData;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * IGetInfoPageController interface
 *
 * @param <I> id of model
 * @param <T> info model
 * @param <F> extends {@link IFilter}
 */
@RequestMapping("/")
public interface IGetInfoPageController<I, T extends IBaseData<I>, F extends IFilter> {

    /**
     * getPaging method
     *
     * @param filter extends {@link IFilter}
     * @param number page number
     * @param size   page size
     * @return {@link BasePagingResponse}
     */
    @GetMapping("page")
    ResponseEntity<BaseResponse<BasePagingResponse<T>>> getInfoPageWithFilter(
            @ParameterObject @Valid F filter,
            @RequestParam(defaultValue = "0") Integer number,
            @RequestParam(defaultValue = "20") Integer size
    );
}
