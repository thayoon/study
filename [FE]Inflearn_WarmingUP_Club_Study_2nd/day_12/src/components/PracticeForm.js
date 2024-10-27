import React, { useState } from "react";
import styled from "styled-components";

function PracticeForm({ question, handleAnswerSelect, selectedAnswer }) {
  const [isChecked, setIsChecked] = useState(false);
  const [isAnswered, setIsAnswered] = useState(false);

  const handleAnswerChange = (answer) => {
    handleAnswerSelect(question.question, answer);
    setIsChecked(true);
    setIsAnswered(false);
  };

  const handleCheckAnswer = () => {
    setIsAnswered(true);
  };

  const isCorrect = selectedAnswer === question.correct;

  return (
    <StyledPracticeForm isAnswered={isAnswered} isCorrect={isCorrect}>
      <label>{question.question}</label>
      <div>
        {question.answers.map((ans) => (
          <InputDiv key={ans}>
            <span>
              {isAnswered && isCorrect
                ? question.correct === ans
                  ? "✅"
                  : ""
                : isAnswered && (question.correct === ans ? "✅" : "❌")}
            </span>
            <input
              type="radio"
              name={question.question}
              value={ans}
              checked={selectedAnswer === ans}
              onChange={() => handleAnswerChange(ans)}
            />
            {ans}
          </InputDiv>
        ))}
      </div>
      {isChecked && !isAnswered && (
        <CheckButton onClick={handleCheckAnswer}>답변 확인하기</CheckButton>
      )}
    </StyledPracticeForm>
  );
}

const StyledPracticeForm = styled.div`
  border: 2px solid
    ${({ isAnswered, isCorrect }) =>
      isAnswered
        ? isCorrect
          ? "lightseagreen"
          : "lightcoral"
        : "transparent"};
  padding: 10px;
  margin: 10px 0;
  border-radius: 5px;
  background-color: #f0f0f0;
`;

const InputDiv = styled.div`
  margin: 6px auto;
`;

const CheckButton = styled.button`
  margin-top: 10px;
  padding: 10px;
  background-color: lightblue;
  border: none;
  border-radius: 5px;
  cursor: pointer;

  &:hover {
    background-color: deepskyblue;
  }
`;

export default PracticeForm;
