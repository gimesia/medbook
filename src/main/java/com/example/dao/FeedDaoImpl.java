package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.models.FeedItem;
import com.example.models.Image;

public class FeedDaoImpl implements FeedDao {
   private static final Logger logger = LoggerFactory.getLogger(FeedDaoImpl.class);

  @Override
    public ArrayList<FeedItem> getFeedById(int userId) {
        ConnectionDao connectionDao = new ConnectionDaoImpl();
        ImageDao imageDao = new ImageDaoImpl();
        UserDao userDao = new UserDaoImpl();  // Assuming you have a UserDao to get usernames

        try {
            Set<Integer> connectionIds = connectionDao.getConnectedUserIdsByUserId(userId);

            ArrayList<Image> images = imageDao.getImagesForUserIdList(new ArrayList<>(connectionIds));

            List<FeedItem> feedItems = images.stream()
                                             .filter(item -> !item.isPrivate())
                                             .map(image -> new FeedItem(
                                                 userDao.getUserById(image.getUserId()).getUsername(),
                                                 image.getImageId(),
                                                 image.getUserId(),
                                                 image.getImageReference(),
                                                 image.getDevice(),
                                                 image.getBodypart(),
                                                 image.getDiagnosis(),
                                                 image.getDescription(),
                                                 image.isPrivate(),
                                                 image.getCreatedAt()
                                             ))
                                             .collect(Collectors.toList());

            return new ArrayList<>(feedItems);
        } catch (Exception e) {
            // Log the exception
            logger.error("Error fetching connections by user ID", e);
            // Return an empty list to ensure method robustness
            return new ArrayList<>();
        }
    }
}
