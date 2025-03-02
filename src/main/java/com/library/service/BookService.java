package com.library.service;

import com.library.pojo.Book;
import com.library.pojo.PageBean;
import com.library.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {



     PageBean page(Integer page, Integer pageSize);

     Book selectByID(Integer id);

     void delete(Integer id);

     void insertbook(Book book);

     Result UpdateBook(Book book, Integer id);


     List<Book> selectByBookname(String bookname);
}
