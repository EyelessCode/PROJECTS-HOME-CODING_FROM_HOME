import { StrictMode } from 'react'
import "@/index.css"
import { createRoot } from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom'
import {App, AuthProvider} from "@/index"

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <AuthProvider>
      <BrowserRouter>
        <App/>
      </BrowserRouter>
    </AuthProvider>
  </StrictMode>,
)
