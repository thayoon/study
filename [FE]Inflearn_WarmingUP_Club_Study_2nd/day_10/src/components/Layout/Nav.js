import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useGoogleLogin } from "@react-oauth/google";
import "./Nav.css";
const Nav = ({ isAuthenticated, setIsAuthenticated, handleLogout }) => {
  const [show, setShow] = useState(false);
  const [searchValue, setSearchValue] = useState("");
  const [profile, setProfile] = useState("");
  const navigate = useNavigate();
  useEffect(() => {
    window.addEventListener("scroll", () => {
      if (window.scrollY > 50) {
        setShow(true);
      } else {
        setShow(false);
      }
    });

    return () => {
      window.removeEventListener("scroll", () => {});
    };
  }, []);

  useEffect(() => {
    fetchUserInfo();
  }, [isAuthenticated]);

  const fetchUserInfo = async () => {
    const accessToken = localStorage.getItem("access_token");
    if (accessToken) {
      try {
        const res = await axios.get(
          "https://www.googleapis.com/oauth2/v3/userinfo",
          {
            headers: {
              Authorization: `Bearer ${accessToken}`,
            },
          }
        );
        setProfile(res.data.picture);
      } catch (error) {
        console.error("Failed to fetch user info:", error);
      }
    }
  };

  const handleLogin = useGoogleLogin({
    onSuccess: (res) => {
      localStorage.setItem("access_token", res.access_token);
      setIsAuthenticated(true);
    },
    onError: (error) => {
      console.log("Login failed:", error);
    },
  });

  if (!isAuthenticated) {
    return (
      <nav className={`nav ${show && "nav__black"}`}>
        <button onClick={() => handleLogin()} className="nav__login__btn">
          로그인
        </button>
      </nav>
    );
  }

  const handleChange = (e) => {
    setSearchValue(e.target.value);
    navigate(`/search?q=${e.target.value}`);
  };

  return (
    <nav className={`nav ${show && "nav__black"}`}>
      <img
        alt="Disney logo"
        src="https://static-assets.bamgrid.com/product/disneyplus/images/disney-plus-logo-white.3b4910ec3c8417655f6f0511d5d9244d.svg"
        className="nav__logo"
        onClick={() => (window.location.href = "/")}
      />

      <input
        value={searchValue}
        onChange={handleChange}
        className="nav__input"
        type="text"
        placeholder="영화를 검색해주세요."
      />
      <img alt="User logged" src={profile} className="nav__avatar" />
      <button onClick={handleLogout} className="nav__login__btn">
        로그아웃
      </button>
    </nav>
  );
};

export default Nav;
