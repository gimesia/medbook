// mockData.js
export const mockDataImages = [
    {
        id: 1,
        date: "2024-03-04",
        type: "CT",
        medicalCenter: "General Hospital",
        bodyPart: "Head",
        diagnosis: "Migraine",
        comments: "Patient experiences frequent headaches.",
        imgRef: "./assets/ct.png",
        description: "CT Scan of the head"
    },
    {
        id: 2,
        date: "2024-04-15",
        type: "MRI",
        medicalCenter: "City Clinic",
        bodyPart: "Spine",
        diagnosis: "Herniated Disc",
        comments: "Patient complains of back pain.",
        imgRef: "./assets/mri.png",
        description: "MRI of the spine"
    },
    {
        id: 3,
        date: "2024-02-10",
        type: "Xray",
        medicalCenter: "Downtown Medical",
        bodyPart: "Chest",
        diagnosis: "Pneumonia",
        comments: "Patient has cough and fever.",
        imgRef: "./assets/xray.png",
        description: "Xray of the chest"
    },
    {
        id: 4,
        date: "2024-01-22",
        type: "CT",
        medicalCenter: "Health Center",
        bodyPart: "Abdomen",
        diagnosis: "Gallstones",
        comments: "Patient experiences abdominal pain.",
        imgRef: "./assets/ct.png",
        description: "Ultrasound of the abdomen"
    },
    {
        id: 5,
        date: "2024-05-30",
        type: "CT",
        medicalCenter: "Westside Hospital",
        bodyPart: "Leg",
        diagnosis: "Fracture",
        comments: "Patient injured in an accident.",
        imgRef: "./assets/ct.png",
        description: "CT Scan of the leg"
    },
    {
        id: 6,
        date: "2024-03-18",
        type: "MRI",
        medicalCenter: "Eastside Medical",
        bodyPart: "Brain",
        diagnosis: "Tumor",
        comments: "Patient has frequent dizziness.",
        imgRef: "./assets/mri.png",
        description: "MRI of the brain"
    },
    {
        id: 7,
        date: "2024-06-05",
        type: "Xray",
        medicalCenter: "North Clinic",
        bodyPart: "Arm",
        diagnosis: "Sprain",
        comments: "Patient fell while running.",
        imgRef: "./assets/xray.png",
        description: "Xray of the arm"
    },
    {
        id: 8,
        date: "2024-02-28",
        type: "CT",
        medicalCenter: "Central Hospital",
        bodyPart: "Pelvis",
        diagnosis: "Cyst",
        comments: "Patient reports pelvic pain.",
        imgRef: "./assets/ct.png",
        description: "Ultrasound of the pelvis"
    },
    {
        id: 9,
        date: "2024-04-01",
        type: "CT",
        medicalCenter: "Regional Medical",
        bodyPart: "Chest",
        diagnosis: "Lung Cancer",
        comments: "Patient is a smoker.",
        imgRef: "./assets/ct.png",
        description: "CT Scan of the chest"
    },
    {
        id: 10,
        date: "2024-01-15",
        type: "MRI",
        medicalCenter: "Community Health",
        bodyPart: "Knee",
        diagnosis: "ACL Tear",
        comments: "Patient injured during sports.",
        imgRef: "./assets/mri.png",
        description: "MRI of the knee"
    },
    {
        id: 11,
        date: "2024-03-09",
        type: "Xray",
        medicalCenter: "Metro Clinic",
        bodyPart: "Foot",
        diagnosis: "Fracture",
        comments: "Patient dropped a heavy object on foot.",
        imgRef: "./assets/xray.png",
        description: "Xray of the foot"
    },
    {
        id: 12,
        date: "2024-02-20",
        type: "CT",
        medicalCenter: "County Hospital",
        bodyPart: "Neck",
        diagnosis: "Thyroid Nodule",
        comments: "Patient has a lump in the neck.",
        imgRef: "./assets/ct.png",
        description: "Ultrasound of the neck"
    },
    {
        id: 13,
        date: "2024-05-15",
        type: "CT",
        medicalCenter: "State Medical Center",
        bodyPart: "Abdomen",
        diagnosis: "Appendicitis",
        comments: "Patient has severe abdominal pain.",
        imgRef: "./assets/ct.png",
        description: "CT Scan of the abdomen"
    },
    {
        id: 14,
        date: "2024-01-05",
        type: "MRI",
        medicalCenter: "National Health",
        bodyPart: "Shoulder",
        diagnosis: "Rotator Cuff Tear",
        comments: "Patient experiences shoulder pain.",
        imgRef: "./assets/mri.png",
        description: "MRI of the shoulder"
    },
    {
        id: 15,
        date: "2024-06-10",
        type: "Xray",
        medicalCenter: "City Hospital",
        bodyPart: "Hand",
        diagnosis: "Dislocation",
        comments: "Patient's hand got caught in a door.",
        imgRef: "./assets/xray.png",
        description: "Xray of the hand"
    }
];

export const mockDataFeed = [
    {
        id: 1,
        username: "JohnDoe",
        date: "2024-06-13",
        type: "CT",
        description: "CT Scan of the brain",
        imgRef: "assets/ct.png"
    },
    {
        id: 2,
        username: "JaneSmith",
        date: "2024-06-12",
        type: "MRI",
        description: "MRI of the spine",
        imgRef: "assets/ct.png"
    },
    {
        id: 3,
        username: "AlexJohnson",
        date: "2024-06-11",
        type: "Xray",
        description: "Xray of the chest",
        imgRef: "assets/ct.png"
    }
];


export const mockConnections = [
    {
        id: 1,
        username: "JohnDoe",
        role: "doctor",
        connected: true
    },
    {
        id: 2,
        username: "JaneSmith",
        role: "patient",
        connected: false
    },
    {
        id: 3,
        username: "AlexJohnson",
        role: "nurse",
        connected: true
    },
    {
        id: 4,
        username: "EmilyBrown",
        role: "patient",
        connected: false
    },
    {
        id: 5,
        username: "MichaelWhite",
        role: "nurse",
        connected: true
    },
    {
        id: 6,
        username: "LindaGreen",
        role: "patient",
        connected: false
    },
    {
        id: 7,
        username: "ChrisBlack",
        role: "doctor",
        connected: true
    },
    {
        id: 8,
        username: "SarahBlue",
        role: "patient",
        connected: false
    },
    {
        id: 9,
        username: "DavidYellow",
        role: "nurse",
        connected: true
    },
    {
        id: 10,
        username: "LauraRed",
        role: "doctor",
        connected: false
    }
];
