package com.apollogix.exam.modules.common.controller;

import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.IBaseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
public interface IGetInfoListController<I, T extends IBaseData<I>> {

    /**
     * getList method
     *
     * @return list info model
     */
    @GetMapping("list")
    ResponseEntity<BaseResponse<List<T>>> getInfoList();

}
