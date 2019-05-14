package com.liujie.beansdemo.pojo;


import lombok.Data;
import org.hibernate.validator.constraints.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -7839165682411118398L;


    @NotEmpty(message = "用户名不能为空")
    @Length(min=5, max=20, message="用户名长度必须在5-20之间")
    @Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 24, max = 44, message = "密码长度范围为6-18位")
    private String password;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号不合法")
    private String phone;

    @Email(message = "邮箱格式不正确")
    private String email;

    @NotNull(message = "简介编号不能为空")
    @NotEmpty(message = "简介编号不能为空")
    private List<Integer> introList;

    @Range(min=0, max=4,message = "基础规格")
    private int scale;

    @NotNull(message = "比例不能为空")
    @DecimalMax(value = "100", message = "最大比率是100%啦~")
    @DecimalMin(value = "0.01", message = "最小比率是0.01%啦~")
    private Double cashbackRatio;
}