package com.example.actions;

import com.example.models.MedicalImage;
import com.example.services.MedicalImageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class MedicalImageAction extends ActionSupport implements ModelDriven<MedicalImage> {
    private MedicalImageService service = new MedicalImageService();
    private List<MedicalImage> images;
    private MedicalImage image = new MedicalImage(); // Ensure this is initialized

    public String list() {
        images = service.getAllImages();
        return SUCCESS;
    }

    public String add() {
        service.saveImage(image);
        return SUCCESS;
    }

    public String update() {
        service.updateImage(image);
        return SUCCESS;
    }

    public String delete() {
        service.deleteImage(image.getId());
        return SUCCESS;
    }

    // Getters and setters
    public List<MedicalImage> getImages() { return images; }
    public void setImages(List<MedicalImage> images) { this.images = images; }

    public MedicalImage getImage() { return image; }
    public void setImage(MedicalImage image) { this.image = image; }

    @Override
    public MedicalImage getModel() {
        return image;
    }
}
