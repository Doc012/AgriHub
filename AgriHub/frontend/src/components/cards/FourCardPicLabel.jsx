const FourCardPicLabel = ({ title, description, image, label }) => {
    return (
      <div className="card transition-transform transform hover:scale-105 cursor-pointer overflow-hidden rounded-lg shadow-md bg-white dark:bg-gray-800">
        
        {/* Image Section */}
        <div className="relative w-full h-40">
          <img src={image} alt={title} className="w-full h-full object-cover rounded-t-lg" />
        </div>
  
        {/* Content Section */}
        <div className="p-4 bg-slate-100 dark:bg-slate-950 transition-colors rounded-b-lg">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">{title}</h2>
          <p className="text-sm text-gray-600 dark:text-gray-300">{description}</p>
          
          {/* Label/Button */}
          <div className="mt-4">
            <button className="px-4 py-2 text-sm font-medium text-white bg-blue-600 rounded-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500">
              {label}
            </button>
          </div>
        </div>
      </div>
    );
  };
  
  export default FourCardPicLabel;
  