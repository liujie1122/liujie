package com.liujie.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Entity：表明这是实体类

 @Table：和数据库对应的表名

 @Id：标明这是主键（用于get方法或者属性）

 @Column：该属性在数据库表中对应的字段名，如果两者名字相同，可以不写（用于get方法或者属性）

 @GeneratedValue(strategy=GenerationType.AUTO)表示主键自增长（用于get方法或者属性）
 *
 */
@Table(name="USER")
@Entity
public class User {

    private Integer id;
    private String name;
    private String email;

    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
