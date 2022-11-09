<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	function requestPay() {
		IMP.init('imp02185252'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
		IMP.request_pay({
			pg : "inicis",
			pay_method : "card",
			merchant_uid : 'INIpayTest' + new Date().getTime(),
			name : '결제테스트',
			amount : 14000,
			buyer_email : 'booklike112@gmail.com',
			buyer_name : '홍건호',
			buyer_tel : '01031566304',
		}, function(rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				alert(msg);
				location.href = "결제 완료 후 이동할 페이지 url"
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				alert(msg);
			}
		});
	}
</script>

</head>
<body>
	<button id="check_module" type="button" onclick="requestPay()">아임
		서포트 결제 모듈 테스트 해보기</button>


</body>
</html>
