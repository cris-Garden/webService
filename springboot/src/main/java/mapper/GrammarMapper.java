package mapper;

import pojo.Grammar;

import org.apache.ibatis.annotations.*;

@Mapper
public interface GrammarMapper {

    @Select("select * from grammar where id = #{id}")
    Grammar findByID(Integer id);
}