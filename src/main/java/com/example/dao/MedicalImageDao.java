package com.example.dao;

import com.example.models.MedicalImage;
import java.util.List;

public interface MedicalImageDao {
    List<MedicalImage> findAll();
    MedicalImage findById(int id);
    void save(MedicalImage image);
    void update(MedicalImage image);
    void delete(int id);
}
