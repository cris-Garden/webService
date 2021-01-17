package com.app.davenkin;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.app.mapper.*;
import com.app.pojo.*;
import java.util.*;
import org.springframework.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(tags = "新闻相关接口", description = "提供新闻相关的Rest API")
public class NewsController {
    @Autowired
    private NewMapper newMapper;

    @ApiOperation("通过id查找content")
    @GetMapping("/content/{id}")
    public Content findContentByID(@PathVariable("id") int id) {
        System.out.println(id);
        Content content = newMapper.findContentByID(id);
        return content;
    }


    @ApiOperation("通过id查找news")
    @GetMapping("/news/{id}")
    public News findNewsByID(@PathVariable("id") int id) {
        System.out.println(id);
        News news = newMapper.findNewsByID(id);
        return news;
    }

}