package com.library.mapper;

import com.library.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {




    @Select("select * from book")
    public List<Book> list();

    @Select("select * from book where id=#{id}")
    public Book selectByID(Integer id);

    @Delete("delete from book where id=#{id}")
    public int deleteBook(Integer ID);

    @Insert("insert into book(name, author, publish, isbn, introduction, language, price, publish_date, status) values (#{name}, #{author}, #{publish}, #{isbn}, #{introduction}, #{language}, #{price}, #{publish_date}, #{status})")
    public int insertbook(Book book);

    @Update( {"update book set",
            "name = #{book.name},",
            "author = #{book.author},",
            "publish = #{book.publish},",
            "isbn = #{book.isbn},",
            "introduction = #{book.introduction},",
            "language = #{book.language},",
            "price = #{book.price},",
            "publish_date = #{book.publish_date},",
            "status = #{book.status}",
            "where id = #{id}"
})
    public void UpdateBook(@Param("book") Book book, @Param("id") Integer id);


    @Select("SELECT * FROM book WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Book> selectByBookName(@Param("name") String name);


}
