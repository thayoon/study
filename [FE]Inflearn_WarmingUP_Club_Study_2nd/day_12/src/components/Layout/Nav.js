import { Link } from "react-router-dom";
import "./Nav.css";
const Nav = () => {
  return (
    <nav className="navbar">
      <h1 className="title">Quiz</h1>
      <div className="menu">
        <Link to="/" className="menu-item">
          Home
        </Link>
        <Link to="/question" className="menu-item">
          Question
        </Link>
        <Link to="/state" className="menu-item">
          State
        </Link>
        <Link to="/quiz" className="menu-item">
          Quiz
        </Link>
      </div>
    </nav>
  );
};

export default Nav;
