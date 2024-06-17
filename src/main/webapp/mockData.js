// mockData.js
export const mockDataImages = [
    {
        id: 1,
        userId: 101,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Head",
        diagnosis: "Migraine",
        description: "CT Scan of the head",
        is_private: 1,
        created_at: new Date("2024-03-04")
    },
    {
        id: 2,
        userId: 102,
        image_reference: "./assets/mri.png",
        device: "MRI",
        bodypart: "Spine",
        diagnosis: "Herniated Disc",
        description: "MRI of the spine",
        is_private: 1,
        created_at: new Date("2024-04-15")
    },
    {
        id: 3,
        userId: 103,
        image_reference: "./assets/xray.png",
        device: "Xray",
        bodypart: "Chest",
        diagnosis: "Pneumonia",
        description: "Xray of the chest",
        is_private: 1,
        created_at: new Date("2024-02-10")
    },
    {
        id: 4,
        userId: 104,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Abdomen",
        diagnosis: "Gallstones",
        description: "Ultrasound of the abdomen",
        is_private: 1,
        created_at: new Date("2024-01-22")
    },
    {
        id: 5,
        userId: 105,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Leg",
        diagnosis: "Fracture",
        description: "CT Scan of the leg",
        is_private: 1,
        created_at: new Date("2024-05-30")
    },
    {
        id: 6,
        userId: 106,
        image_reference: "./assets/mri.png",
        device: "MRI",
        bodypart: "Brain",
        diagnosis: "Tumor",
        description: "MRI of the brain",
        is_private: 1,
        created_at: new Date("2024-03-18")
    },
    {
        id: 7,
        userId: 107,
        image_reference: "./assets/xray.png",
        device: "Xray",
        bodypart: "Arm",
        diagnosis: "Sprain",
        description: "Xray of the arm",
        is_private: 1,
        created_at: new Date("2024-06-05")
    },
    {
        id: 8,
        userId: 108,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Pelvis",
        diagnosis: "Cyst",
        description: "Ultrasound of the pelvis",
        is_private: 1,
        created_at: new Date("2024-02-28")
    },
    {
        id: 9,
        userId: 109,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Chest",
        diagnosis: "Lung Cancer",
        description: "CT Scan of the chest",
        is_private: 1,
        created_at: new Date("2024-04-01")
    },
    {
        id: 10,
        userId: 110,
        image_reference: "./assets/mri.png",
        device: "MRI",
        bodypart: "Knee",
        diagnosis: "ACL Tear",
        description: "MRI of the knee",
        is_private: 1,
        created_at: new Date("2024-01-15")
    },
    {
        id: 11,
        userId: 111,
        image_reference: "./assets/xray.png",
        device: "Xray",
        bodypart: "Foot",
        diagnosis: "Fracture",
        description: "Xray of the foot",
        is_private: 1,
        created_at: new Date("2024-03-09")
    },
    {
        id: 12,
        userId: 112,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Neck",
        diagnosis: "Thyroid Nodule",
        description: "Ultrasound of the neck",
        is_private: 1,
        created_at: new Date("2024-02-20")
    },
    {
        id: 13,
        userId: 113,
        image_reference: "./assets/ct.png",
        device: "CT",
        bodypart: "Abdomen",
        diagnosis: "Appendicitis",
        description: "CT Scan of the abdomen",
        is_private: 1,
        created_at: new Date("2024-05-15")
    },
    {
        id: 14,
        userId: 114,
        image_reference: "./assets/mri.png",
        device: "MRI",
        bodypart: "Shoulder",
        diagnosis: "Rotator Cuff Tear",
        description: "MRI of the shoulder",
        is_private: 1,
        created_at: new Date("2024-01-05")
    },
    {
        id: 15,
        userId: 115,
        image_reference: "./assets/xray.png",
        device: "Xray",
        bodypart: "Hand",
        diagnosis: "Dislocation",
        description: "Xray of the hand",
        is_private: 1,
        created_at: new Date("2024-06-10")
    }
];

export const mockDataFeed = [
    {
        id: 1,
        userId: 101,
        image_reference: "assets/ct.png",
        device: "CT",
        description: "CT Scan of the brain",
        is_private: 0,
        created_at: new Date("2024-06-13")
    },
    {
        id: 2,
        userId: 102,
        image_reference: "assets/ct.png",
        device: "MRI",
        description: "MRI of the spine",
        is_private: 0,
        created_at: new Date("2024-06-12")
    },
    {
        id: 3,
        userId: 103,
        image_reference: "assets/ct.png",
        device: "Xray",
        description: "Xray of the chest",
        is_private: 0,
        created_at: new Date("2024-06-11")
    }
];

export const mockConnections = [
    {
        connection_id: 1,
        user1_id: 101,
        user2_id: 107,
        connected: true,
        created_at: new Date("2024-06-01")
    },
    {
        connection_id: 2,
        user1_id: 102,
        user2_id: 108,
        connected: false,
        created_at: new Date("2024-06-02")
    },
    {
        connection_id: 3,
        user1_id: 103,
        user2_id: 109,
        connected: true,
        created_at: new Date("2024-06-03")
    },
    {
        connection_id: 4,
        user1_id: 104,
        user2_id: 110,
        connected: false,
        created_at: new Date("2024-06-04")
    },
    {
        connection_id: 5,
        user1_id: 105,
        user2_id: 111,
        connected: true,
        created_at: new Date("2024-06-05")
    },
    {
        connection_id: 6,
        user1_id: 106,
        user2_id: 112,
        connected: false,
        created_at: new Date("2024-06-06")
    },
    {
        connection_id: 7,
        user1_id: 107,
        user2_id: 113,
        connected: true,
        created_at: new Date("2024-06-07")
    },
    {
        connection_id: 8,
        user1_id: 108,
        user2_id: 114,
        connected: false,
        created_at: new Date("2024-06-08")
    },
    {
        connection_id: 9,
        user1_id: 109,
        user2_id: 115,
        connected: true,
        created_at: new Date("2024-06-09")
    },
    {
        connection_id: 10,
        user1_id: 110,
        user2_id: 101,
        connected: false,
        created_at: new Date("2024-06-10")
    }
];
