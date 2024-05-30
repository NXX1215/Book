package com.example.mapper;

import com.example.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReaderMapper {
    @Select("select * from readerinformation")
    public List<Reader> list();
}
