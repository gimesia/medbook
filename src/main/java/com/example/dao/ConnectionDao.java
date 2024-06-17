package com.example.dao;

import java.util.ArrayList;

import com.example.models.ConnectionMdl;

public interface ConnectionDao {
   ArrayList<ConnectionMdl> getConnectionsByUserId(int id);
   void addConnection(int user1_id, int user2_id);
}
