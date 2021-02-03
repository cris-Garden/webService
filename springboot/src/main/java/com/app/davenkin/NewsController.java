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
        return createData(newsList,"nhk_easy");
    }

    @ApiOperation("更新新闻nhk新闻")
    @GetMapping("/news/nhk/update")
    public SearchData getNHKFirstPage() {
        List<News> newsList = newMapper.selectFirstPageByType("nhk_easy");
        SearchData data = createData(newsList,"nhk_easy");
        return data;
    }

    @ApiOperation("分页查询查找下一页NHK新聞、传递最后一条新闻id")
    @GetMapping("/news/day/page/{id}")
    public SearchData getDayNextPage(@PathVariable("id") int id) {
        System.out.println(id);
        List<News> newsList = newMapper.selectNextPageByIDAndType(id,"day_easy");
        SearchData data = createData(newsList,"day_easy");
        return data;
    }

    @ApiOperation("更新新闻每日新闻")
    @GetMapping("/news/day/update")
    public SearchData getDayFirstPage() {
        List<News> newsList = newMapper.selectFirstPageByType("day_easy");
        SearchData data = createData(newsList,"day_easy");
        return data;
    }

    private SearchData createData(List<News> newList,String type){
        int max = newMapper.selectCountByType(type);
        SearchData data = new SearchData<News>();
        data.setItems(newList);
        data.setItemCount(newList.size());
        data.setMaxCount(max);
        return data;
    }

}