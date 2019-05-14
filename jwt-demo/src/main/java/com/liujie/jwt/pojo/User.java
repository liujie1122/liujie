package com.liujie.jwt.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = -7839165682411118398L;

    /**
     * @Id：标明这是主键（用于get方法或者属性）
     * @Column：该属性在数据库表中对应的字段名，如果两者名字相同，可以不写（用于get方法或者属性）
     * @GeneratedValue(strategy=GenerationType.AUTO)表示主键自增长（用于get方法或者属性）
     */
//    @Null(message = "非法的用户id")
    @Id  // javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    @Length(min=5, max=20, message="用户名长度必须在5-20之间")
    @Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")
    private String username;

    @NotBlank(message = "密码不能为空")
//    @Length(min = 6, max = 18, message = "密码长度范围为6-18位")
    private String password;
    //密码加盐
    private String salt;

//    @NotBlank(message = "手机号不能为空")
//    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号不合法")
//    private String phone;

//    @Email(message = "邮箱格式不正确")
//    private String email;
//
//    @NotNull(message = "简介编号不能为空")
//    @NotEmpty(message = "简介编号不能为空")
//    private List<Integer> introList;
//
//    @Range(min=0, max=4,message = "基础规格")
//    private int scale;
//
//    @NotNull(message = "比例不能为空")
//    @DecimalMax(value = "100", message = "最大比率是100%啦~")
//    @DecimalMin(value = "0.01", message = "最小比率是0.01%啦~")
//    private Double cashbackRatio;


    public User(Integer id,String username) {
        this.id = id;
        this.username = username;
    }
}