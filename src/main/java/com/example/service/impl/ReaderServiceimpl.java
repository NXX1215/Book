package com.example.service.impl;


import com.example.mapper.ReaderMapper;
import com.example.pojo.Reader;
import com.example.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pojo.PageBean;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ReaderServiceimpl implements ReaderService {
@Autowired
    private ReaderMapper readerMapper;
    /**public List<Reader> list(){
      List<Reader> readerList= readerMapper.list();
        readerList.stream().forEach(emp -> {
            //处理gender 1：男 2： 女
            String sex=emp.getSex();
            if("1".equals(sex)){
                emp.setSex("男");
            }else if ("2".equals(sex)){
                emp.setSex("女");
            }
        });

        return readerList;
    }**/
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
}
