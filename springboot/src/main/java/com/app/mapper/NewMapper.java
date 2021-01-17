package com.app.mapper;
import org.apache.ibatis.annotations.*;
import com.app.pojo.*;
import java.util.*;

@Mapper
public interface NewMapper{
    @Select("select * from news.contents where id = #{id}")
    Content findContentByID(Integer id);


    @Select("select * from news.news where id = #{id}")
    @Results({
        @Result(
            property="contents",
            column="newid",
            many=@Many(select = "findContentByNewID"))
    })
    News findNewsByID(Integer id);

    @Select("select * from news.contents where newid = #{id}")
    List<Content> findContentByNewID(String id);
}