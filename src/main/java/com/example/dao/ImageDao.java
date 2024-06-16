package com.example.dao;

import java.util.ArrayList;

import com.example.models.Image;

public interface ImageDao {
   Image getImageById(int id);
   ArrayList<Image> getImagesForIdList(ArrayList<Integer> idList);
   Image toggleImagePublicById(int id);
   void editImage(Image image);
}
