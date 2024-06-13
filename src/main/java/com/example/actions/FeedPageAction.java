package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedPageAction extends ActionSupport {

    private List<Map<String, Object>> feedItems;

    public FeedPageAction() {
        feedItems = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("username", "other-User1");
        item1.put("date", "04/04/2024");
        item1.put("type", "MRI");
        item1.put("description", "Brain");
        item1.put("imgRef", "./assets/brain_mr.png");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("username", "other-User2");
        item2.put("date", "04/04/2024");
        item2.put("type", "CT");
        item2.put("description", "Lung");
        item2.put("imgRef", "./assets/lung_ct.png");

        // Add more items as needed
        feedItems.add(item1);
        feedItems.add(item2);
    }

    public List<Map<String, Object>> getFeedItems() {
        return feedItems;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
