package com.apollogix.exam.modules.common.controller;

import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.IBaseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * Update model
 *
 * @param <I> id type
 * @param <U> model type
 */
public interface IUpdateIdModelController<I, U extends IBaseData<I>> {

    /**
     * Update model
     *
     * @param id      id
     * @param request model type
     * @return {@link ResponseEntity}
     */
    @PutMapping("{id}/update")
    ResponseEntity<BaseResponse<U>> updateIdModel(@PathVariable I id, @RequestBody @Valid U request);

}
