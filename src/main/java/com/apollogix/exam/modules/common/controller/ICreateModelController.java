package com.apollogix.exam.modules.common.controller;

import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.IBaseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @param <I> id of model
 * @param <U> detail model extends {@link IBaseData}
 */
@RequestMapping("/")
public interface ICreateModelController<I, U extends IBaseData<I>> {
    /**
     * Post method create model
     *
     * @param request Detail Model
     * @return {@link ResponseEntity} have detail model
     */
    @PostMapping("")
    ResponseEntity<BaseResponse<U>> createModel(@RequestBody @Valid U request);
}
