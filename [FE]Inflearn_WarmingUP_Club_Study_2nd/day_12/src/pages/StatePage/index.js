import React, { useState } from "react";
import PracticeForm from "../../components/PracticeForm";
import styled from "styled-components";
const states = {
  math: {
    val: "math",
    questions: [
      {
        question: "1 + 1?",
        answers: ["1", "2", "3", "4"],
        correct: "2",
      },
      {
        question: "6 * 3 = ?",
        answers: ["6", "9", "12", "18"],
        correct: "18",
      },
    ],
  },
  alphabet: {
    val: "alphabet",
    questions: [
      {
        question: "abcde 다음은?",
        answers: ["a", "f", "g", "r"],
        correct: "f",
      },
      {
        question: "app_e 빈칸에 들어갈 알맞은 알파벳은?",
        answers: ["a", "b", "l", "o"],
        correct: "l",
      },
    ],
  },
};

function StatePage() {
  const [state, setState] = useState(states.math);

  const handleSelect = (e) => {
    setState(states[e.target.value]);
  };

  const [selectedAnswers, setSelectedAnswers] = useState({});

  const handleAnswerSelect = (question, answer) => {
    setSelectedAnswers((prev) => ({ ...prev, [question]: answer }));
  };

  return (
    <div>
      <StyledSelect value={state.val} onChange={handleSelect}>
        <option value="math">math</option>
        <option value="alphabet">alphabet</option>
      </StyledSelect>
      <div>
        {state.questions.map((q) => (
          <PracticeForm
            key={q.question}
            question={q}
            handleAnswerSelect={handleAnswerSelect}
            selectedAnswer={selectedAnswers[q.question]}
          />
        ))}
      </div>
    </div>
  );
}
const StyledSelect = styled.select`
  width: 100%;
  padding: 10px;
  border: 2px solid #f0f0f0;
  border-radius: 5px;
  margin: 10px 0;
`;
export default StatePage;
