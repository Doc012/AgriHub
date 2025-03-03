
import React, { useState } from "react";


import StatCard from "../../../components/StatCard";
import Province from "../../../components/cards/ThreeCardPic";
import District from "../../../components/cards/ThreeCardPic"; 
import Categories from "../../../components/cards/ThreeCardPic";
import CropCategory from "../../../components/cards/ThreeCardPic";
import LivestockCategory from "../../../components/cards/ThreeCardPic";

import { fetchProvinces, fetchDistricts, fetchCropCategories, fetchLivestockCategories} from "../../../services/agriLearnAPI";
import { stats } from "../../../components/constants/LearnStats";

const AgriLearn = () => {
    const [view, setView] = useState("home"); // "home" | "provinces" | "districts"

    const [provinces, setProvinces] = useState([]);
    const [districts, setDistricts] = useState([]);
    const [cropCategories, setCropCategories] = useState([]);
    const [livestockCategories, setLivestockCategories] = useState([]);

    const [selectedProvince, setSelectedProvince] = useState(null);
    const [selectedDistrict, setSelectedDistrict] = useState(null);
    const [selectedCategory, setSelectedCategory] = useState(null);


    // Fetch and show provinces
    const handleExploreClick = async () => {
        setView("provinces");
        const data = await fetchProvinces();
        setProvinces(data);
    };

    // Fetch and show districts for selected province
    const handleProvinceClick = async (province) => {
        setSelectedProvince(province);
        setView("districts");
        const data = await fetchDistricts(province.provinceID);
        setDistricts(data);
    };

    // Fetch and show crop categories for crops selected in categories
    const handleCategoryClick = async (categoryTitle) => {
        setSelectedCategory(categoryTitle);
    
        // Ensure a district is selected before proceeding
        if (!selectedDistrict) {
            console.error("No district selected. Cannot fetch crop categories.");
            return;
        }
    
        // If "Crops" is selected, fetch crop categories
        if (categoryTitle === "Crops") {
            setView("cropCategories");
            try {
                const data = await fetchCropCategories(selectedDistrict.districtID);
                setCropCategories(data);
            } catch (error) {
                console.error("Error fetching crop categories:", error);
            }
        } else {
            // Handle Livestock or other cases if needed
            setView("livestockCategories");
            try {
                const data = await fetchLivestockCategories(selectedDistrict.districtID);
                setLivestockCategories(data);
            } catch (error) {
                console.error("Error fetching livestock categories:", error);
            }
        }
    };
    


    // Show selected categories
    const handleDistrictClick = (category, district) => {
        setSelectedDistrict(district);  // ✅ Store selected district
        setSelectedCategory(category);
        setView("categories");
    };
    

    const formatProvince = (province) => {
        return province
            .toLowerCase()
            .replace(/_/g, " ")
            .replace(/\b\w/g, (char) => char.toUpperCase());
    };

    // Go back to provinces view
    const handleBackToProvinces = () => {
        setView("provinces");
    };

    // Go back to home (initial) view
    const handleBackToHome = () => {
        setView("home");
    };

    // Go back to districts view
    const handleBackToDistricts = () => {
        setView("districts");
    };

    // Go back to categories view
    const handleBackToCategories = () => {
        setView("categories");
    }


    return (
        <div className="flex flex-col gap-y-4">
            {/* <h1 className="title">Agri-Learn</h1> */}


            {/* Home View: Stats and Categories */}
            {view === "home" && (
                <div className="grid grid-cols-1 gap-4 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
                    {stats.map((stat, index) => (
                        <StatCard key={index} {...stat} onClick={stat.value === "Explore" ? handleExploreClick : null} />
                    ))}
                </div>
            )}

            {/* Provinces View */}
            {view === "provinces" && (
                <div className="m-6">
                    <div className="mb-10">
                        <h2 className="title">Provinces</h2>
                        <button onClick={handleBackToHome} className="-mt-5 px-4 py-2 bg-blue-600 text-white rounded-lg float-right">
                            ⬅ Back
                        </button>
                    </div>
                    <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
                        {provinces.map((prov) => (
                            <Province
                                key={prov.provinceID}
                                title={formatProvince(prov.province)}
                                description={prov.description}
                                picture={prov.provincePicUrl}
                                onClick={() => handleProvinceClick(prov)}
                            />
                        ))}
                    </div>
                </div>
            )}

            {/* Districts View */}
            {view === "districts" && selectedProvince && (
                <div className="m-6">
                    <div className="mb-10">
                    <h2 className="title">{formatProvince(selectedProvince.province)} Districts</h2>
                        <button onClick={handleBackToProvinces} className="-mt-5 px-4 py-2 bg-blue-600 text-white rounded-lg float-right">
                            ⬅ Back
                        </button>
                    </div>
                    <div className="grid grid-cols-1 lg:grid-cols-4 gap-8">
                        {districts.map((district) => (
                            <District 
                                key={district.districtID} 
                                title={district.name} 
                                description={district.description} 
                                picture={district.districtPicUrl} 
                                onClick={() => handleDistrictClick("categories", district)}
                            />
                        ))}
                    </div>
                </div>
            )}


            {/* Categories view */}
            {view === "categories" && selectedCategory && (
                <div className="m-6">
                    <div className="mb-10">
                        <h2 className="title">Categories</h2>
                        <button onClick={handleBackToDistricts} className="-mt-5 px-4 py-2 bg-blue-600 text-white rounded-lg float-right">
                            ⬅ Back 
                        </button>
                    </div>
                    <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
                    <Categories 
                        key="crops" 
                        title="Crops"
                        description="Learn about different crops"
                        picture="https://georgiagrown.com/wp-content/uploads/2019/10/featured_fruits-veg.jpg"
                        onClick={() => handleCategoryClick("Crops")}  // Pass "Crops" as category
                    />

                    <Categories 
                        key="livestock" 
                        title="Livestock"
                        description="Learn about different livestock"
                        picture="https://st2.depositphotos.com/1594920/5329/i/950/depositphotos_53297569-stock-photo-group-of-farm-animals.jpg"
                        onClick={() => handleCategoryClick("Livestock")}  // Pass "Livestock" as category
                    />

                    </div>
                </div>
            )}


            {/* Crop categories View */}
            {view === "cropCategories" && selectedDistrict && (
                <div className="m-6">
                    <div className="mb-10">
                        <h2 className="title">{selectedDistrict.name} Crops</h2>
                        <button onClick={handleBackToCategories} className="-mt-5 px-4 py-2 bg-blue-600 text-white rounded-lg float-right">
                            ⬅ Back
                        </button>
                    </div>
                    <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
                        {cropCategories.map((category) => (
                            <CropCategory 
                                key={category.cropCategoryID} 
                                title={category.name} 
                                description={category.description} 
                                picture={category.picUrl} 
                            />
                        ))}
                    </div>
                </div>
            )}

            {/* Livestock categories View */}
            {view === "livestockCategories" && selectedDistrict && (
                <div className="m-6">
                    <div className="mb-10">
                        <h2 className="title">{selectedDistrict.name} Livestock</h2>
                        <button onClick={handleBackToCategories} className="-mt-5 px-4 py-2 bg-blue-600 text-white rounded-lg float-right">
                            ⬅ Back
                        </button>
                    </div>
                    <div className="grid grid-cols-1 lg:grid-cols-4 gap-8">
                        {livestockCategories.map((category) => (
                            <LivestockCategory 
                                key={category.livestockCategoryID} 
                                title={category.name} 
                                description={category.description} 
                                picture={category.picUrl} 
                            />
                        ))}
                    </div>
                </div>
            )}

            








        </div>
    );
};

export default AgriLearn;