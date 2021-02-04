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
        @Result(property="newid",column="newid"),
        @Result(
            property="contents",
            column="newid",
            many=@Many(select = "findContentByNewID"))
    })
    News findNewsByID(Integer id);

    @Select("select * from news.contents where newid = #{id}")
    List<Content> findContentByNewID(String id);

    @Select("select * from news.news where type ='${type}' and id < #{id} and needshow = 1 and imgurl != 'https://cdn.mainichi.jp/vol1/images/icon/mainichi/ogp.png' order by time desc, id desc limit 20")
    // @Results({
    //     @Result(
    //         property="contents",
    //         column="newid",
    //         many=@Many(select = "findContentByNewID"))
    // })
    List<News> selectNextPageByIDAndType(int id,@Param("type") String type);


    @Select("select * from news.news where type ='${type}' and needshow = 1 and imgurl != 'https://cdn.mainichi.jp/vol1/images/icon/mainichi/ogp.png' order by time desc, id desc limit 20")
    // @Results({
    //     @Result(
    //         property="contents",
    //         column="newid",
    //         many=@Many(select = "findContentByNewID"))
    // })
    List<News> selectFirstPageByType(@Param("type") String type);

    @Select("select count(*) from news.news where type ='${type}' and needshow = 1 and imgurl != 'https://cdn.mainichi.jp/vol1/images/icon/mainichi/ogp.png' order by time desc, id desc")
    int selectCountByType(@Param("type") String type);


}