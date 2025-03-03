const FiveCardPic = ({ province, crops, livestock, climate, image, onClick }) => {
  return (
    <div 
      className="card transition-transform transform hover:scale-105 cursor-pointer overflow-hidden rounded-lg shadow-md bg-white dark:bg-gray-800"
      onClick={onClick}  
    >
      
      {/* Image Section */}
      <div className="relative w-full h-40">
        <img 
          src={image} 
          alt={province} 
          className="w-full h-full object-cover rounded-t-lg" 
          loading="lazy" 
        />
      </div>

      {/* Content Section */}
      <div className="p-4 bg-slate-100 dark:bg-slate-950 transition-colors rounded-b-lg">
        <h2 className="text-lg font-semibold text-gray-900 dark:text-white">{province}</h2>
        <p className="text-sm text-gray-600 dark:text-gray-300">
          <strong>Climate:</strong> {climate}
        </p>
        <p className="text-sm text-gray-600 dark:text-gray-300">
          <strong>Best Crops:</strong> {Array.isArray(crops) ? crops.join(", ") : "N/A"}
        </p>
        <p className="text-sm text-gray-600 dark:text-gray-300">
          <strong>Best Livestock:</strong> {Array.isArray(livestock) ? livestock.join(", ") : "N/A"}
        </p>
      </div>
    </div>
  );
};

export default FiveCardPic;
