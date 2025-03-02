package com.library.service.impl;

import com.library.mapper.BookMapper;
import com.library.pojo.Book;
import com.library.pojo.PageBean;
import com.library.pojo.Result;
import com.library.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookServiceimpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询
        List<Book> bookList=bookMapper.list();
        //   System.out.println(peotList);

        // 获取分页结果
        // Page<Peot> p = (Page<Peot>) empList;
        PageInfo<Book> p = new PageInfo<>(bookList);
        //封装PageBean
        // PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        PageBean pageBean = new PageBean(p.getTotal(), p.getList());
        return pageBean;
    }

    @Override
    public Book selectByID(Integer id){
        return bookMapper.selectByID(id);
    }

    @Override
    public void delete(Integer id){bookMapper.deleteBook(id);}

    @Override
    public void insertbook(Book book){
        bookMapper.insertbook(book);
    }

    @Override
    public Result UpdateBook(Book book, Integer id){
        bookMapper.UpdateBook(book, id);
        return Result.success();
    }

    @Override
    public List<Book> selectByBookname(String bookname) {
        return bookMapper.selectByBookName(bookname);
    }




}
