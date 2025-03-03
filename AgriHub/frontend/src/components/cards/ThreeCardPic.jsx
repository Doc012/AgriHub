const ThreeCardPic = ({ title, description, picture, onClick }) => {
    return (
      <div 
        className="card transition-transform transform hover:scale-105 cursor-pointer"
        onClick={onClick}
      >
        <div className="card-header">
          <img className="w-full h-40 object-cover rounded-lg" src={picture} alt={title} />
        </div>
        <div className="card-body bg-slate-100 transition-colors dark:bg-slate-950 p-4 rounded-lg">
          <h2 className="text-xl font-semibold text-slate-900 transition-colors dark:text-slate-50">
            {title}
          </h2>
          <p className="text-gray-600 dark:text-gray-400">{description}</p>
        </div>
      </div>
    );
  };
  
  export default ThreeCardPic;
  