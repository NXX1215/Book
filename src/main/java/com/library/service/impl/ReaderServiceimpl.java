package com.library.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.mapper.ReaderMapper;
import com.library.pojo.PageBean;
import com.library.pojo.Reader;
import com.library.pojo.Result;
import com.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReaderServiceimpl implements ReaderService {
@Autowired
    private ReaderMapper readerMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询
        List<Reader> readerList = readerMapper.list();
        //   System.out.println(peotList);

        // 获取分页结果
        // Page<Peot> p = (Page<Peot>) empList;
        PageInfo<Reader> p = new PageInfo<>(readerList);
        //封装PageBean
        // PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        PageBean pageBean = new PageBean(p.getTotal(), p.getList());
        return pageBean;
    }
    @Override
    public void delete(Integer id){
        readerMapper.deleteById(id);
    }
    @Override
    public PageBean pageByTime(LocalDateTime startDate, LocalDateTime endDate,Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行按时间查询
        List<Reader> readerList = readerMapper.listByTime(startDate, endDate);

        // 获取分页结果
        PageInfo<Reader> pageInfo = new PageInfo<>(readerList);
        // 封装PageBean
        PageBean pageBean = new PageBean(pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }

    @Override
    public void insertbook(Reader reader) {
        reader.setRegisterDate(LocalDateTime.now());
        readerMapper.Insertbook(reader);
    }

    @Override
    public Result UpDateBook(Reader reader, Integer id) {
        readerMapper.UpdateBook(reader,id);
        return Result.success();
    }

//    @Override
//    public Reader login(Reader reader) {
//        return readerMapper.getByusernameAndPassword(reader);
//    }

    @Override
    public Reader selectByID(Integer id) {
        return readerMapper.selectByID(id);
    }

    @Override
    public List<Reader> selectByRealname(String realName) {
        return readerMapper.selectByRealNmae(realName);
    }
}
