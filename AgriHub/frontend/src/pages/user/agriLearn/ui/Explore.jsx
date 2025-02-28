import { useState, useEffect } from "react";
import ThreeCardPic from "../../../../components/cards/ThreeCardPic"; 
import { fetchProvinces, fetchDistricts, fetchCropCategories, fetchLivestockCategories } from "../../../../services/agriLearnAPI";

const useExplore = () => {
    const [view, setView] = useState("home");
    const [provinces, setProvinces] = useState([]);
    const [districts, setDistricts] = useState([]);
    const [cropCategories, setCropCategories] = useState([]);
    const [livestockCategories, setLivestockCategories] = useState([]);
    const [selectedProvince, setSelectedProvince] = useState(null);
    const [selectedDistrict, setSelectedDistrict] = useState(null);
    const [selectedCategory, setSelectedCategory] = useState(null);

    useEffect(() => {
        const getProvinces = async () => {
            try {
                const data = await fetchProvinces();
                setProvinces(data);
            } catch (error) {
                console.error("Error fetching provinces:", error);
            }
        };
        getProvinces();
    }, []);

    const handleExploreClick = async () => {
        setView("provinces");
        try {
            const data = await fetchProvinces();
            setProvinces(data);
        } catch (error) {
            console.error("Error fetching provinces:", error);
        }
    };

    const handleProvinceClick = async (province) => {
        console.log("Selected province:", province);
        if (!province || !province.provinceID) {
            console.error("Invalid province data");
            return;
        }
        setSelectedProvince(province);
        setView("districts");
        try {
            const data = await fetchDistricts(province.provinceID);
            setDistricts(data);
        } catch (error) {
            console.error("Error fetching districts:", error);
        }
    };

    const handleCategoryClick = async (categoryTitle) => {
        if (!selectedDistrict) {
            console.error("No district selected. Cannot fetch categories.");
            return;
        }

        setSelectedCategory(categoryTitle);

        try {
            if (categoryTitle === "Crops") {
                setView("cropCategories");
                const data = await fetchCropCategories(selectedDistrict.districtID);
                setCropCategories(data);
            } else {
                setView("livestockCategories");
                const data = await fetchLivestockCategories(selectedDistrict.districtID);
                setLivestockCategories(data);
            }
        } catch (error) {
            console.error("Error fetching categories:", error);
        }
    };

    const handleDistrictClick = (category, district) => {
        if (!district || !district.districtID) {
            console.error("Invalid district data");
            return;
        }
        setSelectedDistrict(district);
        setSelectedCategory(category);
        setView("categories");
    };

    const handleBackToProvinces = () => setView("provinces");
    const handleBackToHome = () => setView("home");
    const handleBackToDistricts = () => setView("districts");
    const handleBackToCategories = () => setView("categories");

    return {
        view, provinces, districts, cropCategories, livestockCategories, selectedProvince,
        selectedDistrict, selectedCategory, handleExploreClick, handleProvinceClick, 
        handleCategoryClick, handleDistrictClick, handleBackToProvinces, handleBackToHome, 
        handleBackToDistricts, handleBackToCategories
    };
};

export default useExplore;
