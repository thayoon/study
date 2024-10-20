const questions = [
  {
    question: "2 + 2?",
    answer: [
      { text: "4", correct: true },
      { text: "22", correct: false },
    ],
  },
  {
    question: "3 / 3?",
    answer: [
      { text: "3", correct: false },
      { text: "0", correct: false },
      { text: "정답이 없습니다.", correct: true },
    ],
  },
  {
    question: "2 - 2 = 2?",
    answer: [
      { text: "O", correct: false },
      { text: "X", correct: true },
    ],
  },
];

const startBtn = document.getElementById("start-btn");
const nextBtn = document.getElementById("next-btn");
const questionContainerEl = document.getElementById("question-container");
const questionEl = document.getElementById("question");
const answerBtn = document.getElementById("answer-button");

// 시작 버튼 클릭 시 게임 시작
startBtn.addEventListener("click", () => {
  // 시작 버튼 숨김
  startBtn.classList.add("hide");

  // 질문 무작위로 섞기
  shuffledQuestions = questions.sort(() => Math.random() - 0.5);
  // 첫번째 질문 인덱스 설정
  currentIndex = 0;
  // 질문 컨테이너 표시
  questionContainerEl.classList.remove("hide");
  // 첫 번째 질문 표시
  nextQuestion();
});

function nextQuestion() {
  // 이전 질문의 상태 초기화
  resetAnsBtn();
  // 배경 상태 초기화
  clearStatusClass(document.body);
  // 현재 인덱스에 해당하는 질문 표시
  showQuestion(shuffledQuestions[currentIndex]);
}

// 이전 질문의 상태를 초기화하는 함수
function resetAnsBtn() {
  // answerBtn에 있는 모든 답변 버튼을 제거
  while (answerBtn.firstChild) {
    answerBtn.removeChild(answerBtn.firstChild);
  }
  nextBtn.classList.add("hide");
}

function showQuestion(question) {
  // 질문 설정
  questionEl.innerText = question.question;

  // 답변 버튼 생성 및 이벤트 리스너 등록
  question.answer.forEach((answer) => {
    const button = document.createElement("button"); // 버튼 생성
    button.innerText = answer.text; // 답변 설정
    button.classList.add("btn"); // 버튼 스타일 적용
    if (answer.correct) {
      // 정답 여부 데이터셋 저장
      button.dataset.correct = answer.correct;
    }
    button.addEventListener("click", selectAnswer); // 버튼 이벤트 리스너 등록
    answerBtn.appendChild(button); // 답변 버튼 표시
  });
}

// 답변을 선택했을 때 실행되는 함수
function selectAnswer(event) {
  const selectedButton = event.target;
  const correct = selectedButton.dataset.correct; // // 선택한 답변의 정답 여부 확인

  // 배경색을 정답/오답에 따라 변경
  setStatusClass(document.body, correct);

  // 모든 답변 버튼에 대해 정답/오답 표시 설정
  Array.from(answerBtn.children).forEach((button) => {
    setStatusClass(button, button.dataset.correct);
  });

  // 다음 질문이 남아 있으면 'Next' 버튼 표시, 그렇지 않으면 'Restart' 버튼 표시
  if (shuffledQuestions.length > currentIndex + 1) {
    nextBtn.classList.remove("hide");
  } else {
    startBtn.innerText = "Restart";
    startBtn.classList.remove("hide");
  }
}

function setStatusClass(el, correct) {
  clearStatusClass(el); // 기존의 상태를 초기화

  if (correct) {
    el.classList.add("correct");
  } else {
    el.classList.add("wrong");
  }
}

function clearStatusClass(el) {
  el.classList.remove("correct");
  el.classList.remove("wrong");
}

nextBtn.addEventListener("click", () => {
  currentIndex++;
  nextQuestion();
});
