import React, { useState } from "react";
import QuizForm from "../../components/QuizForm";
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
      {
        question: "1 + 1?",
        answers: ["1", "2", "3", "4"],
        correct: "2",
      },
      {
        question: "app_e 빈칸에 들어갈 알맞은 알파벳은?",
        answers: ["a", "b", "l", "o"],
        correct: "l",
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
      {
        question: "과일이 아닌 것은?",
        answers: ["오이", "바나나", "사과", "망고"],
        correct: "오이",
      },
      {
        question: "'순결, 변함없는 사랑'의 꽃말을 가진 꽃은?",
        answers: ["해바라기", "장미", "국화", "백합"],
        correct: "백합",
      },
    ],
  },
};

function QuizPage() {
  const [state, setState] = useState(states.math);
  const [shuffle, setShuffle] = useState([]);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [correctCount, setCorrectCount] = useState(0);
  const [selected, setSelected] = useState("");
  const [isSelect, setIsSelect] = useState(false);

  const handleInitSelect = (e) => {
    const selectedState = states[e.target.value];
    setState(selectedState);
    setShuffle([]);
  };

  const handleStart = () => {
    const shuffledQuestions = state.questions.sort(() => Math.random() - 0.5);
    setShuffle(shuffledQuestions);
    setCurrentIndex(0);
    setCorrectCount(0);
    setSelected("");
    setIsSelect(false);
  };

  const handleNext = () => {
    if (selected === shuffle[currentIndex].correct) {
      setCorrectCount((prev) => prev + 1);
    }
    setCurrentIndex((prev) => prev + 1);
    setSelected("");
    setIsSelect(false);
  };

  const handleSelect = (val) => {
    setSelected(val);
    setIsSelect(true);
  };

  const handleReset = () => {
    setState(states.math);
    setShuffle([]);
    setCurrentIndex(0);
    setCorrectCount(0);
    setSelected("");
    setIsSelect(false);
  };

  return (
    <div>
      <h1>시험</h1>
      {shuffle.length === 0 ? (
        <>
          <StyledSelect onChange={handleInitSelect} value={state.val}>
            <option value="math">math</option>
            <option value="alphabet">alphabet</option>
          </StyledSelect>
          <ResetButton onClick={handleStart}>연습 테스트 시작</ResetButton>
        </>
      ) : shuffle.length !== 0 && currentIndex < shuffle.length ? (
        <div>
          <QuizForm
            question={shuffle[currentIndex]}
            handleSelect={handleSelect}
          />
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "center",
            }}
          >
            <p>
              문제 {currentIndex + 1}/{shuffle.length}
            </p>
            {isSelect && <NextButton onClick={handleNext}>next</NextButton>}
          </div>
        </div>
      ) : (
        <div>
          <h1>퀴즈 결과</h1>
          <p>
            {shuffle.length}점 중{" "}
            <span
              style={{
                color: correctCount === shuffle.length ? "green" : "red",
              }}
            >
              {correctCount}
            </span>{" "}
            점을 획득했습니다.
          </p>
          <p>
            {correctCount === shuffle.length
              ? "시험에 합격했습니다!"
              : "시험에 합격하지 못했습니다."}
          </p>
          <ResetButton onClick={handleReset}>
            새로운 연습 테스트 시작하기
          </ResetButton>
        </div>
      )}
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

const NextButton = styled.button`
  font-size: 16px;
  width: 80px;
  height: 30px;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;

  &:hover {
    background-color: #0056b3;
  }

  &:active {
    background-color: #004494;
  }
`;
const ResetButton = styled.button`
  font-size: 16px;
  width: 200px;
  height: 30px;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-bottom: 10px;
  &:hover {
    background-color: #0056b3;
  }

  &:active {
    background-color: #004494;
  }
`;
export default QuizPage;
