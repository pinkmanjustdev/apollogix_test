package com.apollogix.exam.modules.common.controller;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.IBaseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IGetDetailByIdController interface
 *
 * @param <I> id of model
 * @param <U> detail model
 */
@RequestMapping("/")
public interface IGetDetailByIdController<I, U extends IBaseData<I>> {

    /**
     * getDetail method
     *
     * @param id of model
     * @return detail model
     */
    @GetMapping("{id}/detail")
    ResponseEntity<BaseResponse<U>> getDetailById(@PathVariable I id) throws InvalidException;
}
