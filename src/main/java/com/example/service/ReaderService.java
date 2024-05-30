package com.example.service;

import com.example.pojo.Reader;
import com.example.pojo.PageBean;

import java.util.List;

public interface ReaderService {
    //public List<Reader> list();
    public PageBean page(Integer page, Integer pageSize);
}
