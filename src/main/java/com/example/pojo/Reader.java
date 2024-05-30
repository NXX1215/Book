package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String sex;
    private LocalDateTime birthday;
    private String address;
    private String tel;
    private String email;
    private LocalDateTime registerDate;
    private String readerNumber;
}
