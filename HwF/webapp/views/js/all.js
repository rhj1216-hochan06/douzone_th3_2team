// 메뉴 선택
const change = (choice) => {
	const parentElem = document.getElementById("selectList");
	document.getElementById("nutrientsListDiv").style.display = "none";

	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("s" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};

// 사는 방식 선택
const selectbuymethod = (choice) => {
	const parentElem = document.getElementById("selectbuymethod");

	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("buy" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};


// 일수 수량, 갯수 늘리는 함수
const countnum = (type) => {

	const takeoneElement = document.getElementById("takeone");

	const onetotalElement = document.getElementById("onetotal");

	const countoneElement = document.getElementById("countone");

	let takeone = parseInt(takeoneElement.innerText);
	let onetotal = parseInt(onetotalElement.innerText);
	let countone = parseInt(countoneElement.innerText);

	if (type === "plus") {
		onetotal += takeone;
		countone += 1;
	} else if (type === "minus") {
		if (onetotal >= takeone) {
			onetotal -= takeone;
			countone -= 1;
		}
	}

	onetotalElement.innerText = onetotal;
	countoneElement.innerText = countone;
}



// 낱개 수량, 가격 늘리는 함수
const count = (type) => {

	const resultElemet = document.getElementById("result");

	const totalElement = document.getElementById("total");

	const countElement = document.getElementById("countnum");

	let number = resultElemet.innerText;
	let result = parseInt(totalElement.innerText);
	let countnum = parseInt(countElement.innerText);

	if (type === "plus") {
		result += parseInt(number);
		countnum += 1;
	} else if (type === "minus") {
		if (result >= parseInt(number)) {
			result -= parseInt(number);
			countnum -= 1;
		}
	}

	totalElement.innerText = result;
	countElement.innerText = countnum;
}

// 시작시 한병 가격 나타나게 하기
window.onload = function() {
	const resultElemet = document.getElementById("result");
	const numperElement = document.getElementById("numperbottle");
	const oneElement = document.getElementById("takeone");

	let result = parseInt(resultElemet.innerText);
	let numper = parseInt(numperElement.innerText);

	oneElement.innerText = (result / numper).toFixed(0);

	document.getElementById("buy2").style.display = "none";

}


// 날짜 선택 

function selectnudate() {
	let sd = document.getElementById("selectdate").value;
	// 입력 받은 날짜

	let result = new Date(document.getElementById("selectdate").value);
	// 입력 받은 날짜를 시간 형태로 저장

	console.log(result);

	const countday = document.getElementById("countone");

	let count = countday.innerText;

	//result.setDate(result.getDate() + count);

	let addDate = result.toISOString().substring(0, 10);


	console.log(addDate);

	//console.log(new Date(+result + 3240 * 10000).toISOString().split("T")[0]);

}

function AddDays(date, days) {
    // date는 문자열로 받는다 ex, '2020-10-15'
    var result = new Date(date);
    result.setDate(result.getDate() + days);
    return result;
}


























