package com.trs.restfulcrud.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.season.orm.dao.annotation.TableInfo;
import com.season.orm.dao.annotation.Transient;
import com.trs.restfulcrud.pojo.base.BasePojo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * Description: TODO
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/3 09:33
 */
@TableInfo(tableName = Criminal.TABLE_NAME,pkName = "id")
public class Criminal extends BasePojo {
    @Transient
    public static final String TABLE_NAME="criminal";

    private Long id;

    @NotBlank(message = "名称不能为空")
    private String name;

    @Min(value = 0,message = "年龄最小为0")
    @Max(value = 200,message = "年龄最大为200")
    private Integer age;

    @Pattern(regexp = "[男女无]",message = "性别只能为男女无中的一个")
    private String gender;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDate jailTime;

    @Length(min = 0,max = 250,message = "备注的长度为0-250")
    private String comment;

    public Criminal(Long id, String name, Integer age, String gender, LocalDate jailTime, String comment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.jailTime = jailTime;
        this.comment = comment;
    }

    public Criminal() {
    }

    public Criminal(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getJailTime() {
        return jailTime;
    }

    public void setJailTime(LocalDate jailTime) {
        this.jailTime = jailTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
