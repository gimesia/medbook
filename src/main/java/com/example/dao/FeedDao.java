package com.example.dao;

import java.util.ArrayList;

import com.example.models.FeedItem;

public interface FeedDao {
      ArrayList<FeedItem> getFeedById(int id);
}
