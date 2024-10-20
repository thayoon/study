import React, { useState, useEffect } from "react";
import "./App.css";
import List from "./components/Lists";
import Form from "./components/Form";
import Toast from "./components/Toast";
const initialBudget = localStorage.getItem("budget")
  ? JSON.parse(localStorage.getItem("budget"))
  : [];

export default function App() {
  const [budget, setBudget] = useState(initialBudget);
  const [title, setTitle] = useState("");
  const [money, setMoney] = useState("");
  const [edit, setEdit] = useState(false);
  const [editId, seteditId] = useState("");
  const [allMoney, setAllMoney] = useState(0);

  const [type, setType] = useState("");
  useEffect(() => {
    if (type !== "") {
      const timer = setTimeout(() => {
        setType("");
      }, 3000);
      return () => clearTimeout(timer);
    }
  }, [type]);

  useEffect(() => {
    const total = budget.reduce((acc, item) => acc + Number(item.money), 0);
    setAllMoney(total);
  }, [budget]);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (edit) {
      let newBudget = budget.map((data) => {
        if (data.id === editId) {
          data.title = title;
          data.money = money;
        }
        return data;
      });
      setBudget(newBudget);
      localStorage.setItem("budget", JSON.stringify(newBudget));
      setEdit(false);
      setType("edit");
    } else {
      let newBudget = {
        id: Date.now(),
        title: title,
        money: money,
      };

      setBudget((prev) => [...prev, newBudget]);
      localStorage.setItem("budget", JSON.stringify([...budget, newBudget]));
      setType("create");
    }
    setTitle("");
    setMoney("");
  };
  const handleRemoveClick = () => {
    setBudget([]);
    localStorage.setItem("budget", JSON.stringify([]));
    setType("delete");
  };
  const handleEditChange = (id) => {
    setEdit(true);
    seteditId(id);
    setTitle(budget.filter((data) => data.id === id)[0].title);
    setMoney(budget.filter((data) => data.id === id)[0].money);
  };

  return (
    <div className="flex items-center justify-center w-screen h-screen bg-blue-100 flex-col">
      <Toast type={type} />
      <div className="w-full p-6 m-4 bg-white rounded shadow lg:w-3/4 lg:max-w-lg">
        <div className="flex justify-between mb-3">
          <h1>예산 계산기</h1>
        </div>
        <Form
          title={title}
          setTitle={setTitle}
          money={money}
          setMoney={setMoney}
          handleSubmit={handleSubmit}
          edit={edit}
        />
        <List
          budget={budget}
          setBudget={setBudget}
          handleEditChange={handleEditChange}
          type={type}
          setType={setType}
        />
        <div className="flex justify-between items-center text-center mt-4">
          <button onClick={handleRemoveClick}>목록 지우기</button>
          <div>총지출: {allMoney}원</div>
        </div>
      </div>
    </div>
  );
}
