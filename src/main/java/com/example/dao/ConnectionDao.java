package com.example.dao;

import java.util.ArrayList;
import java.util.Set;

import com.example.models.ConnectionMdl;

public interface ConnectionDao {
   ArrayList<ConnectionMdl> getConnectionsByUserId(int id);
   void addConnection(int user1_id, int user2_id);
   void deleteConnection(int user1Id, int user2Id);
   Set<Integer> getConnectedUserIdsByUserId(int userId); 
}
