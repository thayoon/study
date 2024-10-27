import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
function HomePage() {
  return (
    <Container>
      <h2>Welcome to Quiz App</h2>
      <StyledLink to="/quiz">
        <QuizButton>Quiz 풀러가기</QuizButton>
      </StyledLink>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 50vh;
  background-color: #f0f4f8;
  color: #333;
  text-align: center;
`;

const StyledLink = styled(Link)`
  text-decoration: none; /* 링크의 기본 밑줄 제거 */
`;

const QuizButton = styled.button`
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
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
export default HomePage;
