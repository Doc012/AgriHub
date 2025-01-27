CREATE TABLE Roles (
    RoleID INT AUTO_INCREMENT PRIMARY KEY,
    RoleName VARCHAR(50) NOT NULL,
    Description TEXT
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

CREATE TABLE Locations (
    LocationID INT AUTO_INCREMENT PRIMARY KEY,
    Province VARCHAR(100) NOT NULL,
    District VARCHAR(100) NOT NULL,
    Pic_url VARCHAR(255)
);

CREATE TABLE CropCategories (
    CropCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    LocationID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    HasSubCategories BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (LocationID) REFERENCES Locations(LocationID)
);

CREATE TABLE CropSubCategories (
    CropSubCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CropCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (CropCategoryID) REFERENCES CropCategories(CropCategoryID)
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
    LocationID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    HasSubCategories BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (LocationID) REFERENCES Locations(LocationID)
);

CREATE TABLE LivestockSubCategories (
    LivestockSubCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    LivestockCategoryID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    Pic_url VARCHAR(255),
    FOREIGN KEY (LivestockCategoryID) REFERENCES LivestockCategories(LivestockCategoryID)
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

CREATE TABLE SavedCategories (
    SavedCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    CategoryID INT NOT NULL,
    SavedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    Pic_url VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE SavedSubCategories (
    SavedSubCategoryID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    SubCategoryID INT NOT NULL,
    SavedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    Pic_url VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);
