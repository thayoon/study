import React, { useCallback } from "react";

const List = React.memo(
  ({ id, title, money, budget, setBudget, handleEditChange, setType }) => {
    const handleClick = useCallback(
      (id) => {
        let newBudget = budget.filter((data) => data.id !== id);
        setBudget(newBudget);
        localStorage.setItem("budget", JSON.stringify(newBudget));
        setType("delete");
      },
      [budget, setType]
    );

    return (
      <div
        key={id}
        className="flex items-center justify-between w-full px-4 py-1 my-1 text-gray-600 bg-gray-100 border rounded row"
      >
        <div className="flex w-full items-center justify-between">
          <div>{title}</div>
          <div>{money}</div>
        </div>
        <div className="items-center w-full">
          <button
            className="px-4 py-2 float-right"
            onClick={() => handleClick(id)}
          >
            x
          </button>
          <button
            className="px-4 py-2 float-right"
            onClick={() => handleEditChange(id)}
          >
            edit
          </button>
        </div>
      </div>
    );
  }
);

export default List;
