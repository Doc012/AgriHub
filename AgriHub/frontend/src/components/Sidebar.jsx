import React, { useState } from 'react';
import {BarChart2, BookOpenText, DollarSign, FileInput, GraduationCap, Settings, ShoppingCart, Store, Tractor, TrendingUp} from "lucide-react";
import { Menu } from "lucide-react";
import { motion } from "framer-motion";
import { Link } from 'react-router-dom';
import { AnimatePresence } from "framer-motion";


const SIDEBAR_ITEMS = [
    {name: "Overview", icon: BarChart2, color:"#6366f1", href:"/"},
    {name: "Agri-Learn", icon: GraduationCap, color:"#8B5CF6", href:"/agri-learn"},
    {name: "Agri-Tasker", icon: BookOpenText, color:"#6EE7B7", href:"/agri-tasker"},
    {name: "My Farm", icon: Tractor, color:"#EC4899", href:"/my-farm"},
    {name: "Marketplace", icon: Store, color:"#10B981", href:"/marketplace"},
    {name: "Funding", icon: FileInput, color:"#F59E0B", href:"/funding"},
    {name: "Finance", icon: DollarSign, color:"#3B82F6", href:"/finance"},
    {name: "Settings", icon: Settings, color:"#6EE7B7", href:"/settings"}

];
const Sidebar = () => {

    const [isSidebarOpen, setIsSidebarOpen] = useState(false);

    return (
      <motion.div
        className={`relative z-10 transition-all duration-300 ease-in-out flex-shrink-0 ${isSidebarOpen ? 'w-64' : 'w-20'}`}
        animate={{width: isSidebarOpen ? 256 : 80}}      
      >
        <div className='h-full bg-gray-800 bg-opacity-50 backdrop-blur-md p-4 flex-col border-r border-gray-700'>
            <motion.button
                whileHover={{ scale: 1.1 }}
                whileTap={{ scale: 0.9 }}
                onClick={() => setIsSidebarOpen(!isSidebarOpen)}
					className='p-2 rounded-full hover:bg-gray-700 transition-colors max-w-fit'
            >
                <Menu size={24} />

            </motion.button>

            <nav className="mt-8nflex-grow">
                {SIDEBAR_ITEMS.map((item) => (
                    <Link key={item.href} to={item.href}>
                        <motion.div
                            className='flex items-center p-4 text-sm font-medium rounded-lg hover:bg-gray-700 transition-colors mb-2'
                        >
                            <item.icon size={20} style={{color: item.color, minWidth: "20px"}} />
                            <AnimatePresence>
                                {isSidebarOpen && (
                                    <motion.span
                                        className='ml-4 whitespace-nowrap'
                                        initial={{opacity:  0, width: 0}}
                                        animate={{opacity:  1, width: "auto"}}
                                        exit={{opacity:  0, width: 0}}
                                        transition={{duration: 0, delay: 0.3}}
                                    >
                                        {item.name}

                                    </motion.span>
                                )}
                            </AnimatePresence>

                        </motion.div>

                    </Link>
                ))}
            </nav>
        </div>
      </motion.div>
  )
}

export default Sidebar
