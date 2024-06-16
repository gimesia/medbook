package com.example.dao;

import java.util.ArrayList;

import com.example.models.Feed;

public interface FeedDao {
      ArrayList<Feed> getFeedById(int id);
}
