import React from 'react'
import Landingpage from './Pages/Landingpage'
import GetStarted from './Pages/Get-Started'
import Header from './Components/Header'

import { BrowserRouter, Routes, Route } from "react-router-dom"

function App() {
  return (
    <div>
      <BrowserRouter>

        <Header />
        <Routes>
          <Route path="/" element={<Landingpage />} />
          <Route path="/get-started" element={<GetStarted />} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
