function alertDelete()  {
 	var confirmMsg = confirm("정말로 삭제하시겠습니까?");
  
  if (confirmMsg=='true') {
  	alert("삭제가 완료되었습니다.");
	  return submitDelete();
  } 
  
  else { 
  	alert("취소를 누르셨습니다.");
  	return false;
	}
}



function submitDelete(frm) { 
    frm.action="./admin?cmd=AdminHealthGoodsDelete"
    return true; 
  } 