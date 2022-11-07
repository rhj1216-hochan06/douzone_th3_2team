 function submitDelete(frm) { 
    frm.action="./admin?cmd=AdminNutrientsDelete"
    frm.submit(); 
    return true; 
  } 