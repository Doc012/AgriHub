import { Route, Routes } from 'react-router-dom';

import OverviewPage from "./pages/OverviewPage";
import ProductsPage from "./pages/AgriLearn";

import Sidebar from './components/Sidebar';
import AgriLearn from './pages/AgriLearn';
import AgriTasker from './pages/AgriTasker';
import MyFarm from './pages/MyFarm';
import Marketplace from './pages/Marketplace';
import Funding from './pages/Funding';
import Finance from './pages/Finance';
import Settings from './pages/Settings';


function App() {

  return (
    <div className='flex h-screen bg-gray-900 text-gray-100 overflow-hidden'>

    {/* BG */}
    <div className='fixed inset-0 z-0'>
      <div className='absolute inset-0 bg-gradient-to-br from-gray-900 via-gray-700 to-gray-900 opacity-80' />
      <div className='absolute inset-0 backdrop-blur-sm'/>
    </div>

    <Sidebar />

    <Routes>
      <Route path='/' element={<OverviewPage />} />
			<Route path='/agri-learn' element={<AgriLearn />} />

      <Route path='/agri-tasker' element={<AgriTasker />} />
      <Route path='/my-farm' element={<MyFarm />} />
      <Route path='/marketplace' element={<Marketplace />} />
      <Route path='/funding' element={<Funding />} />
      <Route path='/finance' element={<Finance />} />
      <Route path='/settings' element={<Settings />} />
    </Routes>

    </div>
  )
}

export default App;
