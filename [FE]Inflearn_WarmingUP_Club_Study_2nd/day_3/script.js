let playerScore = 0;
let computerScore = 0;
let round = 10;

const playerScoreEl = document.getElementById("player-score");
const computerScoreEl = document.getElementById("computer-score");
const roundEl = document.getElementById("round");
const resultMessgeEl = document.getElementById("result");
const finalMessageEl = document.getElementById("final-result");
const gameDoneEl = document.getElementById("game-done");
const restartBtnEl = document.getElementById("restart-btn");
const gameIngEl = document.getElementById("game-ing");

// Event listener for the category group (Event Delegation)
const gameButtons = document.querySelector(".game-btn");
gameButtons.addEventListener("click", (event) => {
  if (event.target.type !== "button") return; // ignore non-button clicks
  const computer = Math.floor(Math.random() * 3); // 0: 가위 1: 바위 2: 보
  const player = parseInt(event.target.id);

  let resultMessage = "";

  if (computer == player) {
    // 비기는 경우
    resultMessage = "무승부";
  } else if ((player + 1) % 3 == computer) {
    // 지는 경우
    resultMessage = "컴퓨터 승리";
    computerScore++;
    computerScoreEl.innerText = computerScore;
  } else {
    // 이기는 경우
    resultMessage = "플레이어 승리";
    playerScore++;
    playerScoreEl.innerText = playerScore;
  }

  resultMessgeEl.innerText = resultMessage;
  round--;
  roundEl.innerText = round;

  if (round === 0) {
    // 모든 라운드 종료
    gameDone();
  }
});

function gameDone() {
  gameIngEl.style.display = "none";
  resultMessgeEl.innerText = "";

  result =
    playerScore > computerScore
      ? "게임에서 이겼습니다!"
      : playerScore < computerScore
      ? "게임에서 졌습니다."
      : "무승부!";
  finalMessageEl.innerText = result;

  gameDoneEl.style.display = "block";
}

restartBtnEl.addEventListener("click", () => {
  playerScore = 0;
  computerScore = 0;
  round = 10;

  playerScoreEl.innerText = playerScore;
  computerScoreEl.innerText = computerScore;
  roundEl.innerText = round;

  resultMessgeEl.innerText = "";
  finalMessageEl.innerText = "";

  gameDoneEl.style.display = "none";
  gameIngEl.style.display = "block";
});
