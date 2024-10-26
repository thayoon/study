import React from "react";
import styled from "styled-components";

export default function Footer() {
  return (
    <FooterContainer>
      <FooterContent>
        <FooterLinkContainer>
          <FooterLinkTitle href="/">
            <FooterLogo
              src="https://static-assets.bamgrid.com/product/disneyplus/images/disney-plus-logo-white.3b4910ec3c8417655f6f0511d5d9244d.svg"
              alt="Disney+"
            />
          </FooterLinkTitle>
          <FooterLinkContent>
            <FooterLink href="https://www.disneyplus.com/ko-kr/legal/%EB%94%94%EC%A6%88%EB%8B%88+-%EC%9D%B4%EC%9A%A9%EC%95%BD%EA%B4%80">
              디즈니+ 이용약관
            </FooterLink>
            <FooterLink href="https://help.disneyplus.com/?utm_source=disneyplus&utm_medium=web&utm_campaign=unauthenticated-site-footer&utm_content=home-page">
              고객 센터
            </FooterLink>
            <FooterLink href="https://www.disneyplus.com/ko-kr/legal/%EA%B0%9C%EC%9D%B8%EC%A0%95%EB%B3%B4-%EC%B2%98%EB%A6%AC%EB%B0%A9%EC%B9%A8">
              개인정보 처리방침
            </FooterLink>
            <FooterLink href="https://help.disneyplus.com/article/disneyplus-introduction/?utm_source=disneyplus&utm_medium=web&utm_campaign=unauthenticated-site-footer&utm_content=introduction">
              디즈니+ 소개
            </FooterLink>
          </FooterLinkContent>
          <FooterDescContainer>
            <FooterDescRights>
              © 2024 Disney and its related entities. All Rights Reserved.
            </FooterDescRights>
          </FooterDescContainer>
        </FooterLinkContainer>
      </FooterContent>
    </FooterContainer>
  );
}

const FooterContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px 0;
  border-top: 1px solid rgb(25, 25, 25);
  width: 100%;
  position: relative;
  z-index: 100;

  @media (max-width: 769px) {
    padding: 20px 20px;
    padding-bottom: 30px;
  }
`;

const FooterContent = styled.div``;

const FooterLinkContainer = styled.div`
  width: 500px;

  @media (max-width: 768px) {
    width: 100%;
  }
`;

const FooterLinkTitle = styled.a`
  display: flex;
  align-items: center;
  justify-content: center;
  color: gray;
  font-size: 17px;
`;

const FooterLogo = styled.img`
  width: 80px;
  cursor: pointer;
`;

const FooterLinkContent = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  margin-top: 35px;

  @media (max-width: 768px) {
    margin-top: 26px;
  }
`;

const FooterLink = styled.a`
  color: gray;
  font-size: 14px;
  width: 110px;
  margin-bottom: 21px;
  text-decoration: none;
  text-align: center;
  &:hover {
    text-decoration: underline;
  }

  @media (max-width: 768px) {
    margin-bottom: 16px;
  }
`;

const FooterDescContainer = styled.div`
  margin-top: 30px;
  @media (max-width: 768px) {
    margin-top: 20px;
  }
`;

const FooterDescRights = styled.h2`
  color: white;
  font-size: 14px;
  text-align: center;
`;
