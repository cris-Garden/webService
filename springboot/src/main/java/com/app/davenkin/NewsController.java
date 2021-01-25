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

    @ApiOperation("分页查询查找下一页NHK新聞、传递最后一条新闻id")
    @GetMapping("/news/nhk/page/{id}")
    public SearchData getNHKNextPage(@PathVariable("id") int id) {
        System.out.println(id);
        List<News> newsList = newMapper.selectNextPageByIDAndType(id,"nhk_easy");
        int max = newMapper.selectCountByType("nhk_easy");
        SearchData data = new SearchData<News>();
        data.setItems(newsList);
        data.setItemCount(newsList.size());
        data.setMaxCount(max);
        return data;
    }

    @ApiOperation("更新新闻nhk新闻")
    @GetMapping("/news/nhk/update")
    public List<News> getNHKFirstPage() {
        List<News> newsList = newMapper.selectFirstPageByType("nhk_easy");
        return newsList;
    }

    @ApiOperation("分页查询查找下一页NHK新聞、传递最后一条新闻id")
    @GetMapping("/news/day/page/{id}")
    public SearchData getDayNextPage(@PathVariable("id") int id) {
        System.out.println(id);
        List<News> newsList = newMapper.selectNextPageByIDAndType(id,"day_easy");
        int max = newMapper.selectCountByType("day_easy");
        SearchData data = new SearchData<News>();
        data.setItems(newsList);
        data.setItemCount(newsList.size());
        data.setMaxCount(max);
        return data;
    }

    @ApiOperation("更新新闻每日新闻")
    @GetMapping("/news/day/update")
    public List<News> getDayFirstPage() {
        List<News> newsList = newMapper.selectFirstPageByType("day_easy");
        return newsList;
    }

}