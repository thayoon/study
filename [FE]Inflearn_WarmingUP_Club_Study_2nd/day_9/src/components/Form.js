import React from "react";

export default function Form({
  title,
  setTitle,
  money,
  setMoney,
  handleSubmit,
  edit,
}) {
  const handleChange = (e) => {
    const id = e.target.id;
    if (id === "title") {
      setTitle(e.target.value);
    } else if (id === "money") {
      setMoney(e.target.value);
    }
  };
  return (
    <div>
      <form className="flex pt-2" onSubmit={handleSubmit}>
        <input
          type="text"
          name="value"
          className="w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow"
          placeholder="지출 항목"
          id="title"
          value={title}
          onChange={handleChange}
        />
        <input
          type="text"
          name="value"
          className="w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow"
          placeholder="비용"
          id="money"
          value={money}
          onChange={handleChange}
        />
        <input
          type="submit"
          value={!edit ? "제출" : "수정"}
          className="p-2 text-blue-400 border-2 border-blue-400 rounded hover:text-white hover:bg-blue-400"
          style={{ flex: "1" }}
        />
      </form>
    </div>
  );
}
