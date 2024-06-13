package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedAction extends ActionSupport implements ModelDriven<List<Map<String, Object>>> {

    private List<Map<String, Object>> feedItems;

    public FeedAction() {
        feedItems = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", 1);
        item1.put("user_ID", 101);
        item1.put("date", "2024-04-04");
        item1.put("type", "CT");
        item1.put("description", "Lung");
        item1.put("imgRef", "./assets/lung_ct.png");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 2);
        item2.put("user_ID", 101);
        item2.put("date", "2024-04-03");
        item2.put("type", "CT");
        item2.put("description", "Lung");
        item2.put("imgRef", "./assets/lung_ct.png");

        // Add more items as needed
        feedItems.add(item1);
        feedItems.add(item2);
    }

    @Override
    public List<Map<String, Object>> getModel() {
        return feedItems;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
