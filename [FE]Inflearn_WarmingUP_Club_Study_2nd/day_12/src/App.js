import { Routes, Route, Outlet } from "react-router-dom";

import Footer from "./components/Layout/Footer";
import Nav from "./components/Layout/Nav";
import HomePage from "./pages/HomePage";
import QuestionPage from "./pages/QuestionPage";
import StatePage from "./pages/StatePage";
import QuizPage from "./pages/QuizPage";

function Layout() {
  return (
    <div>
      <Nav />

      <div style={{ padding: "0 50px" }}>
        <Outlet />
      </div>

      <Footer />
    </div>
  );
}

function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<HomePage />} />
          <Route path="question" element={<QuestionPage />} />
          <Route path="state" element={<StatePage />} />
          <Route path="quiz" element={<QuizPage />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
