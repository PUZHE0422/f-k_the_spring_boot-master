package com.example.demo.controller;


import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.*;
import java.util.List;



@Controller
@RequestMapping("/jdbc")
public class testJdbc {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/itemlist")
    public 
    String getItemList(ModelMap map) {
        String sql = "SELECT * FROM item";
        List<Item> itemList = jdbcTemplate.query(sql, new RowMapper<Item>() {
            Item item = null;
            @Override
            public Item mapRow (ResultSet rs, int rowNum) throws SQLException {
                item = new Item();
                item.setItem_id(rs.getInt("item_id"));
                item.setItem_name(rs.getString("item_name"));
                item.setUnit(rs.getString("unit"));
                item.setNum(rs.getInt("num"));
                item.setPrice(rs.getInt("price"));
                return item;
           }
        });
        for (Item item : itemList) {
            System.out.println(item.getItem_name());
        }
        map.addAttribute("items", itemList);
        return "/item";
    }

}
