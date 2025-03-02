package com.library.service;

import com.library.pojo.Reader;
import com.library.pojo.PageBean;
import com.library.pojo.Result;

import java.time.LocalDateTime;
import java.util.List;

public interface ReaderService {
    //public List<Reader> list();
    public PageBean page(Integer page, Integer pageSize);
    public void delete (Integer id);
    public PageBean pageByTime( LocalDateTime startDate, LocalDateTime endDate,Integer page, Integer pageSize);
    public void insertbook(Reader reader);
    public Result UpDateBook(Reader reader, Integer id);

//    Reader login(Reader reader);

    Reader selectByID(Integer id);


    List<Reader> selectByRealname(String realName);
}
