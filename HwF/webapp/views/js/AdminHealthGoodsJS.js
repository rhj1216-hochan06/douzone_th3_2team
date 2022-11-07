 function submitDelete(frm) { 
    frm.action="./admin?cmd=AdminHealthGoodsDelete"
    frm.submit(); 
    return true; 
  } 