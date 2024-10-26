import React from "react";
import styled from "styled-components";

function LoginPage() {
  return (
    <div>
      <BackgroundDiv>
        <BackgroundImg />
        <ContentDiv>
          <Logo
            src="https://static-assets.bamgrid.com/product/disneyplus/images/disney-plus-logo-white.3b4910ec3c8417655f6f0511d5d9244d.svg"
            alt="Disney+"
          />
          <Title>이 모든 이야기가 여기에 지금 스트리밍 중</Title>
          <Plans>
            <Plan>
              <PlanTitle>디즈니+ 스탠다드</PlanTitle>
              <PlanPrice>월 9,900원부터</PlanPrice>
              <PlanDescription>최대 1080p Full HD</PlanDescription>
              <PlanDescription>비디오 최대 5.1 오디오</PlanDescription>
              <PlanDescription>최대 2대 기기 동시 스트리밍</PlanDescription>
            </Plan>
            <Plan>
              <PlanTitle>디즈니+ 프리미엄</PlanTitle>
              <PlanPrice>월 13,900원부터</PlanPrice>
              <PlanDescription>최대 4K UHD & HDR 비디오</PlanDescription>
              <PlanDescription>최대 Dolby Atmos 오디오</PlanDescription>
              <PlanDescription>최대 4대 기기 동시 스트리밍</PlanDescription>
            </Plan>
          </Plans>
        </ContentDiv>
      </BackgroundDiv>
    </div>
  );
}

const BackgroundDiv = styled.div`
  background-color: rgb(0, 0, 0, 0.4);
  color: rgb(255, 255, 255);
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  position: relative;
`;

const BackgroundImg = styled.img.attrs({
  src: "https://assets.nflxext.com/ffe/siteui/vlv3/74d734ca-0eab-4cd9-871f-bca01823d872/web/KR-ko-20241021-TRIFECTA-perspective_edf82f18-edb6-4fa7-b805-044b5dcc96f1_large.jpg",
  alt: "background-img",
})`
  height: 100vh;
  width: 100%;
  object-fit: cover;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;
  opacity: 0.5;
`;

const ContentDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  flex: 1;
  z-index: 1;
  padding: 20px;
  text-align: center;
`;
const Logo = styled.img`
  width: 100px;
  cursor: pointer;
`;
const Title = styled.h1`
  font-size: 36px;
  margin-bottom: 30px;
`;

const Plans = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  max-width: 600px;
`;

const Plan = styled.div`
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 10px;
  margin: 10px;
  padding: 20px;
  width: 100%;
  text-align: center;
`;

const PlanTitle = styled.h2`
  color: #02d6e8;
  font-size: 24px;
  margin: 10px 0;
`;

const PlanPrice = styled.p`
  font-size: 20px;
  margin: 10px 0;
`;

const PlanDescription = styled.p`
  font-size: 16px;
  margin: 5px 0;
`;

export default LoginPage;
