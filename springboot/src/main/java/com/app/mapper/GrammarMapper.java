package com.app.mapper;

import com.app.pojo.Grammar;
import com.app.pojo.Mean;
import java.util.*;
import com.app.pojo.Example;

import org.apache.ibatis.annotations.*;

@Mapper
public interface GrammarMapper {

    //搜索语法
    @Select("select * from `grammar`.`grammar` where id=#{id}")
    @Results({
        //必须再写一次才会付值给Grammar的id属性否则属性为空
        @Result(property = "id", column = "id"),
        @Result(property = "means", column = "id",
            many = @Many(select = "findMeanByGrammarID")
        )
    })
    Grammar findGrammarByID(Integer id);

    //根据语法id 搜索语法的意思
    @Select("select * from `grammar`.`means` where grammar_id=#{grammarID}")
    @Results({
        //必须再写一次才会付值给Grammar的id属性否则属性为空
        @Result(property = "id", column = "id"),
        @Result(property = "examples",column = "id",
            many = @Many(select = "findExampleByMeanID")
        )
    })
    List<Mean> findMeanByGrammarID(Integer grammarID);

    //根据意思id 搜索语法的例句
    @Select("select * from `grammar`.`examples` where mean_id=#{meanID}")
    List<Example> findExampleByMeanID(Integer meanID);

    //根据例句id查找例句
    @Select("select * from grammar.examples where id = ${id}")
    List<Example> findExampleByIds(Integer id);

    /******************************    搜索功能 *******************************/
    //根据关键字查找语法
    @Select("select id,title,level from `grammar`.`grammar` where title like '%${title}%'")
    @Results({
        //必须再写一次才会付值给Grammar的id属性否则属性为空
        @Result(property = "id", column = "id"),
        @Result(property = "means", column = "id",
            many = @Many(select = "searchMeanByGrammarID")
        )
    })
    List<Grammar> findGrammarByKeyword(@Param("title") String title);

    //根据语法等级搜索语法
    @Select("select id,title,level from `grammar`.`grammar` where level='${level}'")
    @Results({
        //必须再写一次才会付值给Grammar的id属性否则属性为空
        @Result(property = "id", column = "id"),
        @Result(property = "means", column = "id",
            many = @Many(select = "searchMeanByGrammarID")
        )
    })
    List<Grammar> findGrammarByLevel(@Param("level") String level);


    //根据关键字搜索语法的意思
    @Select("select `id`,`mean` from `grammar`.`means` where grammar_id=#{grammarID}")
    List<Mean> searchMeanByGrammarID(Integer grammarID);


}