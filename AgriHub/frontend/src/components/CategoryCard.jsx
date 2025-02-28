import React from "react";

const CategoryCard = ({ title, description, image, label }) => {
  return (
    <div className="card transition-transform transform hover:scale-105 cursor-pointer overflow-hidden rounded-lg shadow-md">
      
      {/* Image Section */}
      <div className="relative w-full h-48">
        <img
          src={image}
          alt={title}
          className="w-full h-full object-cover rounded-t-lg transition-opacity duration-300"
        />
        <span className="absolute top-2 left-2 bg-green-100 text-green-700 dark:bg-green-900 dark:text-green-300 text-xs font-bold px-3 py-1 rounded-full shadow-sm">
          {label}
        </span>
      </div>

      {/* Content Section */}
      <div className="p-4 bg-slate-100 dark:bg-slate-950 transition-colors rounded-b-lg">
        <h3 className="text-lg font-semibold text-gray-900 dark:text-white">
          {title}
        </h3>
        <p className="text-gray-600 dark:text-gray-300 text-sm mt-1">
          {description}
        </p>
      </div>
    </div>
  );
};

export default CategoryCard;
