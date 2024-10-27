import React from "react";
import styled from "styled-components";

function QuizForm({ question, handleSelect }) {
  const handleChange = (e) => {
    handleSelect(e.target.value);
  };

  return (
    <div>
      <h3>{question.question}</h3>
      <div>
        {question.answers.map((ans) => (
          <InputDiv key={ans}>
            <input
              type="radio"
              name={question.question}
              value={ans}
              onChange={handleChange}
            />
            {ans}
          </InputDiv>
        ))}
      </div>
    </div>
  );
}

const InputDiv = styled.div`
  margin: 6px auto;
`;

export default QuizForm;
