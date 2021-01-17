package com.app.davenkin;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.app.mapper.GrammarMapper;
import com.app.pojo.Grammar;
import com.app.pojo.Mean;
import java.util.*;
import org.springframework.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(tags = "语法相关接口", description = "提供语法相关的Rest API")
public class GrammarController {

    @Autowired
    private GrammarMapper grammarMapper;

    @ApiOperation("通过关键字或语法等级查找语法")
    @GetMapping("/search")
    public List<Grammar> findById(@RequestParam(value="keyword",required=false) String keyword,
                                  @RequestParam(value="level",required=false) String level) {
        System.out.println(keyword);
        if(!StringUtils.isEmpty(keyword)){
            List<Grammar> grammars = grammarMapper.findGrammarByKeyword(keyword);
            return grammars;
        }
        if(!StringUtils.isEmpty(level)){
            List<Grammar> grammars = grammarMapper.findGrammarByLevel(level);
            return grammars;
        }
        return null;
    }

    @ApiOperation("通过id查找用户接口")
    @GetMapping("/grammar/{id}")
    public Grammar getGrammarById(@PathVariable("id") int id) {
        System.out.println(id);
        Grammar grammar = grammarMapper.findGrammarByID(id);
        return grammar;
    }
}
