package com.example.services;

import com.example.dao.MedicalImageDao;
import com.example.dao.MedicalImageDaoImpl;
import com.example.models.MedicalImage;

import java.util.List;

public class MedicalImageService {
    private MedicalImageDao dao = new MedicalImageDaoImpl();

    public List<MedicalImage> getAllImages() {
        return dao.findAll();
    }

    public MedicalImage getImageById(int id) {
        return dao.findById(id);
    }

    public void saveImage(MedicalImage image) {
        dao.save(image);
    }

    public void updateImage(MedicalImage image) {
        dao.update(image);
    }

    public void deleteImage(int id) {
        dao.delete(id);
    }
}
