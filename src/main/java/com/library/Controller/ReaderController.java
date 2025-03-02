package com.library.Controller;

import com.library.pojo.PageBean;
import com.library.pojo.Reader;
import com.library.pojo.Result;
import com.library.service.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
    @GetMapping("/readers/{id}")
    public Result page(@PathVariable("id")   Integer id){
        log.info("id查询{}",id);
        //调用service分页查询
        return Result.seccess(readerService.selectByID(id));
    }
    //删除的操作
    @DeleteMapping("/reader/{id}")
    public Result delete(@PathVariable("id") Integer id){
        log.info("根据id删除部门:{}",id);//一个大括号就是一个参数占位符，id会替换这个参数占位符
        //调用service删除部门
        readerService.delete(id);
        return Result.success();

    }
    @GetMapping("/reader/{startDate}/{endDate}/{page}/{pageSize}")
    public Result selectReaderByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @PathVariable("startDate") LocalDateTime startDate,
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @PathVariable("endDate") LocalDateTime endDate,
                                     @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        log.info("按时间查询读者, 参数: {},{}", startDate, endDate);
        PageBean pageBean = readerService.pageByTime( startDate, endDate,page, pageSize);
        return Result.seccess(pageBean);
    }
    @PutMapping("/readersPut/{id}")
    public Result UpdateBook(@RequestBody Reader reader,@PathVariable("id") Integer id){
        log.info("更新的信息:{}",id);

        readerService.UpDateBook(reader, id);
        return Result.success();

    }
    @PostMapping("/readers")
    public Result InsertBook(@RequestBody Reader reader){
        readerService.insertbook(reader);
        return Result.success();
    }
    @GetMapping("/readers1/{realName}")
    public Result SelectByname(@PathVariable String realName){

        log.info("根据姓名:{}",realName);
        return Result.seccess(readerService.selectByRealname(realName));
    }

}
