function valid()
  {
  var x=document.forms["fname"]["username"].value;
  if(x=="")
  {
  alert("Name is not filled");
  return false;
  }
  var z=document.forms["fname"]["pwd"].value;
  if(z=="")
  {
	  alert("The Password is not Filled");
	   return false;
  }
  var a=document.forms["fname"]["pwd"].value;
  if(a=="")
  {
	  alert("Plz enter re-password");
       return false;
  }
  if(z!=a)
  {
	  alert("Password does not match");
      
	   return false;
  }
   if((z).length<8)
  {
	  alert("Please enter password more then 8 Character");
	  return false;
  }  
  }
  