// menu data
const menus = [
  {
    title: "아메리카노",
    category: "coffee",
    price: "2500원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107203019521_01_300x300.jpg",
    desc: "기본 2샷의 진한 에스프레소와 물을 섞어 청자다방만의 깔끔한 에스프레소를 느낄 수 있는 커피",
  },
  {
    title: "1리터 아메리카노",
    category: "coffee",
    price: "3500원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107203144522_01_300x300.jpg",
    desc: "기본 4샷으로 청자다방만의 깔끔한 에스프레소를 더욱 깊고 진하게 느낄 수 있는 특대용량 커피",
  },
  {
    title: "청자다방커피",
    category: "coffee",
    price: "3300원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107203308523_01_300x300.jpg",
    desc: "청자다방 대표 메뉴인 달콤한 어른들의 커피로, 달달한 믹스커피의 맛을 그대로 느낄 수 있는 음료",
  },
  {
    title: "카페라떼",
    category: "coffee",
    price: "3500원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107203610525_01_300x300.jpg",
    desc: "청자다방만의 깔끔한 에스프레소와 고소한 생우유가 어우러져 부드러운 커피",
  },
  {
    title: "티라미수라떼",
    category: "coffee",
    price: "4500원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107204247529_01_300x300.jpg",
    desc: "부드러운 치즈의 풍미와 커피의 향이 조화를 이루는 음료",
  },
  {
    title: "청자스페셜",
    category: "ade",
    price: "4000원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107211138549_01_300x300.jpg",
    desc: "청자다방의 시그니쳐 메뉴! 상큼한 청포도와 달콤쌉싸름한 자몽이 만나 청량함을 두 배로 느낄 수 있는 에이드",
  },
  {
    title: "바나나주스",
    category: "ade",
    price: "4500원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240107212449558_01_300x300.jpg",
    desc: "달콤한 바나나를 가득 담아 달콤하고 시원하게 즐길 수 있는 바나나쥬스",
  },
  {
    title: "자바칩 프라푸치노",
    category: "blended",
    price: "4700원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240108095608080_01_300x300.jpg",
    desc: "달콤한 초코소스와 우유 그리고 얼음을 함께 블랜딩 하여 초콜릿 칩이 입안 가득 느껴지는 프라푸치노",
  },
  {
    title: "민트초코 프라푸치노",
    category: "blended",
    price: "4700원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240108095709081_01_300x300.jpg",
    desc: "시원하고 청량한 민트와 초코칩 그리고 얼음을 함께 블랜딩하여 달콤한 초코소스와 휘핑크림을 얹은 프라푸치노",
  },
  {
    title: "밀크티버블라떼",
    category: "tea",
    price: "4800원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240108105018118_01_300x300.jpg",
    desc: "향긋한 밀크티에 진한 흑당의 달콤함과 쫄깃쫄깃한 타피오카 펄을 가득 담아 조화를 이루는 음료",
  },
  {
    title: "문경오미자차",
    category: "tea",
    price: "4500원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240108111248133_01_300x300.png",
    desc: "다섯가지의 풍미를 느낄 수 있는 새콤달콤한 문경오미자차",
  },
  {
    title: "리얼군고구마라떼",
    category: "beverage",
    price: "4000원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240108140758255_01_300x300.jpg",
    desc: "청자다방 시그니처 메뉴로, 매장에서 직접 구운 고구마를 갈아서 만든 달달한 고구마라떼",
  },
  {
    title: "단호박라떼",
    category: "beverage",
    price: "4000원",
    img: "https://www.cheongjadabang.com/data/g1_menu/thumb-note_20240108153131313_01_300x300.jpg",
    desc: "달콤한 단호박과 고소한 우유가 어우러져 든든하게 즐길 수 있는 건강한 음료",
  },
];

// Create menu items and append to the menu list container
const createMenuItems = (menus) => {
  const menuList = document.querySelector(".menu-list"); // parent container for menu items

  menuList.innerHTML = ""; // clear previous menu items

  // for (let i = 0; i < mene.length; i++) {
  for (const menu of menus) {
    const col = document.createElement("div");
    col.setAttribute("class", "col");
    const card = document.createElement("div");
    card.setAttribute("class", "card");
    const img = document.createElement("img");
    img.setAttribute("src", menu.img);
    img.setAttribute("class", "card-img-top");
    img.setAttribute("alt", menu.title);
    const cardBody = document.createElement("div");
    cardBody.setAttribute("class", "card-body");
    const title = document.createElement("h5");
    title.setAttribute("class", "card-title");
    title.innerText = menu.title;
    const desc = document.createElement("p");
    desc.setAttribute("class", "card-text");
    desc.innerText = menu.desc;
    const price = document.createElement("div");
    price.setAttribute("class", "d-flex justify-content-end align-items-right");
    price.innerText = menu.price;

    menuList.appendChild(col).appendChild(card).appendChild(img);
    card.appendChild(cardBody);
    cardBody.append(title, desc, price);
  }
  // sorting menu items length
  if (menus.length <= 3) {
    menuList.classList.add("justify-content-center");
  } else {
    menuList.classList.remove("justify-content-center");
  }
};

// Event listeners for each category buttons
// const allBtn = document.querySelector("#all");
// allBtn.addEventListener("click", () => {
//   createMenuItems(menus);
// });

// const coffeeBtn = document.querySelector("#coffee");
// coffeeBtn.addEventListener("click", () => {
//   createMenuItems(menus.filter((item) => item.category === "coffee"));
// });

// const adeBtn = document.querySelector("#ade");
// adeBtn.addEventListener("click", () => {
//   createMenuItems(menus.filter((item) => item.category === "ade"));
// });

// const blendedBtn = document.querySelector("#blended");
// blendedBtn.addEventListener("click", () => {
//   createMenuItems(menus.filter((item) => item.category === "blended"));
// });

// const teaBtn = document.querySelector("#tea");
// teaBtn.addEventListener("click", () => {
//   createMenuItems(menus.filter((item) => item.category === "tea"));
// });

// const beverageBtn = document.querySelector("#beverage");
// beverageBtn.addEventListener("click", () => {
//   createMenuItems(menus.filter((item) => item.category === "beverage"));
// });

// Event listener for the category group (Event Delegation)
const categoryButtons = document.querySelector(".categorys");
categoryButtons.addEventListener("click", (event) => {
  if (event.target.type !== "button") return; // ignore non-button clicks
  if (event.target.id === "all") {
    createMenuItems(menus);
  } else {
    // coffee, ade, blended, tea, beverage
    createMenuItems(menus.filter((item) => item.category === event.target.id));
  }
});

window.onload = function () {
  // 초기에 문서가 로드되면 모든 메뉴를 보여줌
  createMenuItems(menus);
};
