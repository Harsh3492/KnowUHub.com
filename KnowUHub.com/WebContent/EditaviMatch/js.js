function validateForm() {
  var optionA = document.forms["myForm"]["nameA"].value;
  if(optionA == ""){
    document.myForm.nameA.focus() ;
    alert("Please enter your match");
    return false;
  }
  if(isNaN(optionA))
  {
    document.myForm.nameA.focus() ;
    alert("Please enter number");
    return false;
  }
  if ((optionA).length >1) {
      document.myForm.nameA.focus() ;
      alert("Please correct number");
      return false;
  }
  if(optionA>=6){
	  document.myForm.nameA.focus() ;
	  alert("Please correct number in A");
      return false;
  }
  if(optionA<=0){
	  document.myForm.nameA.focus() ;
	  alert("Please correct number in A");
      return false;
  }
  // option D
  var optionD = document.forms["myForm"]["nameD"].value;
  if(optionD == ""){
    document.myForm.nameD.focus() ;
    alert("Please enter your match");
    return false;
  }
  if(isNaN(optionD))
  {
    document.myForm.nameD.focus() ;
    alert("Please enter number");
    return false;
  }
  if ((optionD).length >1) {
      document.myForm.nameD.focus() ;
      alert("Please correct number");
      return false;
  }
  if(optionD>5){
	  document.myForm.nameD.focus() ;
	  alert("Please correct number in D");
      return false;
  }
  if(optionD<=0){
	  document.myForm.nameA.focus() ;
	  alert("Please correct number in D");
      return false;
  }
  // option B

  var optionB = document.forms["myForm"]["fname"].value;
      if (optionB == "") {
          alert("Please Fill the B");
          return false;
      }
      if(isNaN(optionB))
      {
        document.myForm.fname.focus() ;
        alert("Please enter number");
        return false;
      }
      if ((optionB).length >1) {
          document.myForm.fname.focus() ;
          alert("Please correct number");
          return false;
      }
      if(optionB>5){
    	  
    	  alert("Please correct number in B");
          return false;
      }
      if(optionB<=0){
    	  document.myForm.nameA.focus() ;
    	  alert("Please correct number in B");
          return false;
      }
      // option C
    var optionC = document.forms["myForm"]["fname2"].value;
    if (optionC == "") {
        alert("Please Fill the C");
        return false;
    }
    if(isNaN(optionC))
    {
      alert("Please enter number");
      return false;
    }
    if ((optionC).length >1) {
        alert("Please correct number");
        return false;
    }
    if(optionC>5){
  	
  	  alert("Please correct number in C");
        return false;
    }
    if(optionC<=0){
  	  document.myForm.nameA.focus() ;
  	  alert("Please correct number in C");
        return false;
    }
    var optionE = document.forms["myForm"]["fname3"].value;
    if (optionE == "") {
        alert("Please Fill the E");
        return false;
    }
    if(isNaN(optionE))
    {
      alert("Please enter number");
      return false;
    }
    if ((optionE).length >1) {
        alert("Please correct number");
        return false;
    }
    if(optionE>5){
  	  
  	  alert("Please correct number in E");
        return false;
    }
    if(optionE<=0){
  	  document.myForm.nameA.focus() ;
  	  alert("Please correct number in E");
        return false;
    }

}
