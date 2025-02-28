import { picture } from "framer-motion/client";

export const fetchProvinces = async () => {
  try {
      const response = await fetch("http://localhost:8080/api/v1/provinces");
      if (!response.ok) throw new Error("Failed to fetch provinces");
      const data = await response.json();

      // Remove duplicate provinces based on provinceID
      const uniqueProvinces = [];
      const seen = new Set();
      data.forEach((prov) => {
          if (!seen.has(prov.provinceID)) {
              seen.add(prov.provinceID);
              uniqueProvinces.push(prov);
          }
      });

      return uniqueProvinces;
  } catch (error) {
      console.error("Error fetching provinces:", error);
      return [];
  }
};

export const fetchDistricts = async (provinceID) => {
  try {
      const response = await fetch(`http://localhost:8080/api/v1/districts/province/${provinceID}`);
      
      if (!response.ok) throw new Error("Failed to fetch districts");

      const data = await response.json();
      // console.log("Districts API Response:", data);

      // Ensure the response is always an array
      const districtsArray = Array.isArray(data) ? data : [data];

      return districtsArray.map((district) => ({
          districtID: district.districtID,
          name: district.district,
          description: district.description,
          districtPicUrl: district.districtPicUrl,
      }));
  } catch (error) {
      console.error("Error fetching districts:", error);
      return [];
  }
};

export const fetchCropCategories = async (districtID) => {
  try {
      const response = await fetch(`http://localhost:8080/api/v1/crop-categories/district/${districtID}`);
      
      if (!response.ok) throw new Error("Failed to fetch crop categories");

      const data = await response.json();
      console.log("Districts API Response:", data);


      // Ensure the response is always an array
      const cropCategoriesArray = Array.isArray(data) ? data : [data];

      return cropCategoriesArray.map((cropCategory) => ({
        cropCategoryID: cropCategory.cropCategoryID,
          name: cropCategory.title,
          description: cropCategory.description,
          picUrl: cropCategory.picUrl,
      }));
  } catch (error) {
      console.error("Error fetching districts:", error);
      return [];
  }
};


export const fetchLivestockCategories = async (districtID) => {
  try {
      const response = await fetch(`http://localhost:8080/api/v1/livestock-categories/${districtID}`);
      
      if (!response.ok) throw new Error("Failed to fetch livestock categories");

      const data = await response.json();
      // console.log("Districts API Response:", data);


      // Ensure the response is always an array
      const livestockCategoriesArray = Array.isArray(data) ? data : [data];

      return livestockCategoriesArray.map((livestockCategory) => ({
        livestockCategoryID: livestockCategory.livestockCategoryID,
          name: livestockCategory.title,
          description: livestockCategory.description,
          picUrl: livestockCategory.picUrl,
      }));
  } catch (error) {
      console.error("Error fetching districts:", error);
      return [];
  }
};
