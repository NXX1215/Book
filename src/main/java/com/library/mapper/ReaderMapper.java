package com.library.mapper;

import com.library.pojo.Reader;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ReaderMapper {
    //@Delete("delete from readerinformation where id=#{id}")
    void deleteById(Integer id) ;

    //@Select("select * from readerinformation")
    public List<Reader> list();
    public void Insertbook(Reader reader);
    @Update({
            "UPDATE readerinformation SET",
            "username = #{reader.username},",
            "password = #{reader.password},",
            "realName = #{reader.realName},",
            "sex = #{reader.sex},",
            "birthday = #{reader.birthday},",
            "address = #{reader.address},",
            "tel = #{reader.tel},",
            "email = #{reader.email},",
            "readerNumber = #{reader.readerNumber}",
            "WHERE id = #{id}"
    })
    public void UpdateBook(@Param("reader") Reader reader, @Param("id") Integer id);
    public List<Reader> listByTime(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

//    Reader getByusernameAndPassword(Reader reader);

    Reader selectByID(Integer id);

    List<Reader> selectByRealNmae(String realName);
}
