package com.interview.mapper;

import com.interview.model.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from t_user")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("select * from t_user where id = #{id}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("insert into t_user(username,password,nick_name) values(#{userName}, #{passWord}, #{nickName})")
    void insert(UserEntity user);

    @Update("update t_user set username=#{userName},nick_name=#{nickName} where id =#{id}")
    void update(UserEntity user);

    @Update({"<script> ",
            "update t_user ",
            "<set>",
            " <if test='userName != null'>userName=#{userName},</if>",
            " <if test='nickName != null'>nick_name=#{nickName},</if>",
            " </set> ",
            "where id=#{id} ",
            "</script>"})
    void updateUserEntity(UserEntity user);

    @Delete("delete from t_user where id =#{id}")
    void delete(Long id);

}
