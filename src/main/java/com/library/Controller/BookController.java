package com.library.Controller;

import com.library.pojo.Book;
import com.library.pojo.PageBean;
import com.library.pojo.Result;
import com.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/book/{page}/{pageSize}")
        public Result Page(@PathVariable("page") Integer page,
                            @PathVariable ("pageSize") Integer pageSize){
            log.info("分页查询, 参数: {},{}\",page,pageSize");
            PageBean pageBean = bookService.page(page,pageSize);
            return Result.seccess(pageBean);

        }

    @GetMapping("/book/{id}")
    public Result page(@PathVariable("id") Integer id){
        log.info("id查询{}",id);
        return Result.seccess(bookService.selectByID(id));
    }

    @DeleteMapping("/book/{id}")
    public Result delete(@PathVariable("id") Integer id){
        log.info("根据id删除图书:{}",id);
        bookService.delete(id);
        return Result.success();
    }

    @PostMapping("/book")
    public Result InsertBook(@RequestBody Book book){
        bookService.insertbook(book);
        return Result.success();
    }

    @PutMapping("/bookput/{id}")
    public Result UpdateBook(@RequestBody Book book,@PathVariable("id") Integer id){
        log.info("更新的图书信息:{}",id);

            bookService.UpdateBook(book,id);
            return Result.success();
    }

    @GetMapping("/book1/{bookname}")
    public Result SelectByname(@PathVariable String bookname){
        log.info("根据书名:{}",bookname);
        return Result.seccess(bookService.selectByBookname(bookname));
    }
}
