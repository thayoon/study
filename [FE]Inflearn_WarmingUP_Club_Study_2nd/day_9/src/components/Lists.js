import React from "react";
import List from "./List";

const Lists = React.memo(({ budget, setBudget, handleEditChange, setType }) => {
  return (
    <div>
      {budget.map((data) => (
        <List
          key={data.id}
          id={data.id}
          title={data.title}
          money={data.money}
          budget={budget}
          setBudget={setBudget}
          handleEditChange={handleEditChange}
          setType={setType}
        />
      ))}
    </div>
  );
});

export default Lists;
