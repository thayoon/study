import { Routes, Route, Outlet, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import MainPage from "./pages/MainPage";
import DetailPage from "./pages/DetailPage";
import SearchPage from "./pages/SearchPage";
import Footer from "./components/Layout/Footer";
import Nav from "./components/Layout/Nav";
import LoginPage from "./pages/LoginPage";
import { GoogleOAuthProvider, googleLogout } from "@react-oauth/google";

function Layout() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem("access_token");
    setIsAuthenticated(!!token);
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("access_token");
    googleLogout();
    setIsAuthenticated(false);
    navigate("/");
  };

  return (
    <div>
      <Nav
        isAuthenticated={isAuthenticated}
        setIsAuthenticated={setIsAuthenticated}
        handleLogout={handleLogout}
      />

      {!isAuthenticated ? <LoginPage /> : <Outlet />}

      <Footer />
    </div>
  );
}

function App() {
  return (
    <GoogleOAuthProvider clientId={process.env.REACT_APP_GOOGLE_CLIENT_ID_KEY}>
      <div className="app">
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<MainPage />} />
            <Route path=":movieId" element={<DetailPage />} />
            <Route path="search" element={<SearchPage />} />
          </Route>
        </Routes>
      </div>
    </GoogleOAuthProvider>
  );
}

export default App;
