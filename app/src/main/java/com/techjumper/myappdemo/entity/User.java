package com.techjumper.myappdemo.entity;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 16/2/17
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
@Table("user")
public class User {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    @Column("id")
    private int id;

    @NotNull
    @Column("name")
    private String name;

    @Column("age")
    private int age;

//    @Default("true")
//    @Column("login")
//    private Boolean isLogin;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
