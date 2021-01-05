package mapper;

import pojo.Grammar;
import pojo.Mean;
import java.util.*;

import org.apache.ibatis.annotations.*;

@Mapper
public interface GrammarMapper {

    @Select("select * from grammar where id = #{id}")
    Grammar findByID(Integer id);

    @Select("select * from means where title like '%${title}%'")
    List<Mean> findByKeyword(@Param("title") String title);
}