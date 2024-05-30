package com.example.Controller;

import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @GetMapping("/reader/{page}/{pageSize}")
    public Result page(@PathVariable("page")   Integer page,
                       @PathVariable("pageSize")  Integer pageSize){
        log.info("分页查询, 参数: {},{}",page,pageSize);
        //调用service分页查询
        PageBean pageBean = readerService.page(page,pageSize);
        return Result.seccess(pageBean);
    }

    }
