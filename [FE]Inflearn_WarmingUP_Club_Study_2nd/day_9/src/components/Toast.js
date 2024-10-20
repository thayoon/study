import React from "react";

const Toast = ({ type }) => {
  if (!type) return null;
  const toastConfig = {
    create: {
      message: "아이템이 생성되었습니다.",
      style: "bg-green-700 text-white",
    },
    edit: {
      message: "아이템이 수정되었습니다.",
      style: "bg-green-700 text-white",
    },
    delete: {
      message: "아이템이 삭제되었습니다.",
      style: "bg-red-300",
    },
  };

  const { message, style } = toastConfig[type] || {};
  return (
    <div
      className={`fixed top-40 left-1/2 transform -translate-x-1/2 p-4 max-w-md w-auto text-center text-white rounded shadow-lg ${style}`}
    >
      {message}
    </div>
  );
};

export default Toast;
