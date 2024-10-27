import React, { useState } from "react";
import PracticeForm from "../../components/PracticeForm";

const questions = [
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
];

function QuestionPage() {
  const [selectedAnswers, setSelectedAnswers] = useState({});

  const handleAnswerSelect = (question, answer) => {
    setSelectedAnswers((prev) => ({ ...prev, [question]: answer }));
  };

  return (
    <div>
      {questions.map((q) => {
        return (
          <PracticeForm
            key={q.question}
            question={q}
            handleAnswerSelect={handleAnswerSelect}
            selectedAnswer={selectedAnswers[q.question]}
          />
        );
      })}
    </div>
  );
}
export default QuestionPage;
