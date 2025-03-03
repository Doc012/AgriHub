CREATE TABLE Roles (
    RoleID INT AUTO_INCREMENT PRIMARY KEY,
    RoleType ENUM('ADMIN', 'USER', 'FARMER') NOT NULL,
    Description TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Surname VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100) UNIQUE NOT NULL,
    pic_url VARCHAR(255),
    RoleID INT NOT NULL,
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);

CREATE TABLE Provinces (
    ProvinceID INT AUTO_INCREMENT PRIMARY KEY,
    Province ENUM('EASTERN_CAPE', 'FREE_STATE', 'GAUTENG', 'KWAZULU_NATAL', 'LIMPOPO',
                  'MPUMALANGA', 'NORTH_WEST', 'NORTHERN_CAPE', 'WESTERN_CAPE') NOT NULL,
    Description TEXT,
    provincePic_url VARCHAR(255)
);

CREATE TABLE Districts (
    DistrictID INT AUTO_INCREMENT PRIMARY KEY,
    ProvinceID INT,
    District VARCHAR(100) NOT NULL,
    Description TEXT,
    districtPic_url VARCHAR(255),
    FOREIGN KEY (ProvinceID) REFERENCES Provinces(ProvinceID) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE CropCategories (
    CropCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    DistrictID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    HasSubCategories BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (DistrictID) REFERENCES Districts(DistrictID)
);

CREATE TABLE CropGroups (
    CropGroupID INT AUTO_INCREMENT PRIMARY KEY,
    CropCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (CropCategoryID) REFERENCES CropCategories(CropCategoryID)
);

CREATE TABLE CropSubCategories (
    CropSubCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CropCategoryID INT NOT NULL,
    CropGroupID INT,
    Title VARCHAR(100) NOT NULL,
    Purpose TEXT NOT NULL,
    CommonVarieties TEXT NOT NULL,
    Market TEXT NOT NULL,
    Pic_url VARCHAR(255),
    FOREIGN KEY (CropCategoryID) REFERENCES CropCategories(CropCategoryID),
    FOREIGN KEY (CropGroupID) REFERENCES CropGroups(CropGroupID)
);

CREATE TABLE CropCategoryObjectives (
    CropCategoryObjectiveID INT AUTO_INCREMENT PRIMARY KEY,
    CropCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (CropCategoryID) REFERENCES CropCategories(CropCategoryID)
);

CREATE TABLE CropSubCategoryObjectives (
    CropSubCategoryObjectiveID INT AUTO_INCREMENT PRIMARY KEY,
    CropSubCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (CropSubCategoryID) REFERENCES CropSubCategories(CropSubCategoryID)
);

CREATE TABLE CropCategoryObjectiveContents (
    CropCategoryObjectiveContentID INT AUTO_INCREMENT PRIMARY KEY,
    CropCategoryObjectiveID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Content TEXT,
    Pic_url VARCHAR(255),
    Vid_url VARCHAR(255),
    FOREIGN KEY (CropCategoryObjectiveID) REFERENCES CropCategoryObjectives(CropCategoryObjectiveID)
);

CREATE TABLE CropSubCategoryObjectiveContents (
    CropSubCategoryObjectiveContentID INT AUTO_INCREMENT PRIMARY KEY,
    CropSubCategoryObjectiveID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Content TEXT,
    Pic_url VARCHAR(255),
    Vid_url VARCHAR(255),
    FOREIGN KEY (CropSubCategoryObjectiveID) REFERENCES CropSubCategoryObjectives(CropSubCategoryObjectiveID)
);

CREATE TABLE LivestockCategories (
    LivestockCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    DistrictID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    HasSubCategories BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (DistrictID) REFERENCES Districts(DistrictID)
);

CREATE TABLE LivestockGroups (
    LivestockGroupID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,  -- e.g., "Beef Cattle"
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (LivestockCategoryID) REFERENCES LivestockCategories(LivestockCategoryID)
);

CREATE TABLE LivestockSubCategories (
    LivestockSubCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockCategoryID INT NOT NULL,
    LivestockGroupID INT,
    Title VARCHAR(100) NOT NULL,
    Purpose TEXT NOT NULL,
    CommonVarieties TEXT NOT NULL,
    Market TEXT NOT NULL,
    Pic_url VARCHAR(255),
    FOREIGN KEY (LivestockCategoryID) REFERENCES LivestockCategories(LivestockCategoryID),
    FOREIGN KEY (LivestockGroupID) REFERENCES LivestockGroups(LivestockGroupID)
);

CREATE TABLE LivestockCategoryObjectives (
    LivestockCategoryObjectiveID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (LivestockCategoryID) REFERENCES LivestockCategories(LivestockCategoryID)
);

CREATE TABLE LivestockSubCategoryObjectives (
    LivestockSubCategoryObjectiveID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockSubCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (LivestockSubCategoryID) REFERENCES LivestockSubCategories(LivestockSubCategoryID)
);

CREATE TABLE LivestockCategoryObjectiveContents (
    LivestockCategoryObjectiveContentID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockCategoryObjectiveID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Content TEXT,
    Pic_url VARCHAR(255),
    Vid_url VARCHAR(255),
    FOREIGN KEY (LivestockCategoryObjectiveID) REFERENCES LivestockCategoryObjectives(LivestockCategoryObjectiveID)
);

CREATE TABLE LivestockSubCategoryObjectiveContents (
    LivestockSubCategoryObjectiveContentID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockSubCategoryObjectiveID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Content TEXT,
    Pic_url VARCHAR(255),
    Vid_url VARCHAR(255),
    FOREIGN KEY (LivestockSubCategoryObjectiveID) REFERENCES LivestockSubCategoryObjectives(LivestockSubCategoryObjectiveID)
);

CREATE TABLE SavedCropCategories (
    SavedCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    CropCategoryID INT NOT NULL,
    SavedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Pic_url VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (CropCategoryID) REFERENCES CropCategories(CropCategoryID) ON DELETE CASCADE
);

CREATE TABLE SavedCropSubCategories (
    SavedCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    CropSubCategoryID INT NOT NULL,
    SavedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Pic_url VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (CropSubCategoryID) REFERENCES CropSubCategories(CropSubCategoryID) ON DELETE CASCADE
);


CREATE TABLE SavedLivestockCategories (
    SavedCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    LivestockCategoryID INT NOT NULL,
    SavedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Pic_url VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (LivestockCategoryID) REFERENCES LivestockCategories(LivestockCategoryID) ON DELETE CASCADE
);

CREATE TABLE SavedLivestockSubCategories (
    SavedCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    LivestockSubCategoryID INT NOT NULL,
    SavedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Pic_url VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (LivestockSubCategoryID) REFERENCES LivestockSubCategories(LivestockSubCategoryID) ON DELETE CASCADE
);
