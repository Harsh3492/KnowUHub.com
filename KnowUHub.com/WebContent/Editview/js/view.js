function valid()
{
    var oldpwd=document.forms["changepwd"]["oldpwd"].value;
	if(oldpwd=="")
	{
		alert("Please Enter Password");
		return false;
	}
    /////////////////////////////////////////////////////////
	var newpwd=document.forms["changepwd"]["newpwd"].value;
	if(newpwd=="")
	{
		alert("Please Enter New Password");
		return false;
	}
	/////////////////////////////////////////////////////////
	var cnfnewpwd=document.forms["changepwd"]["cnfnewpwd"].value;
	if(cnfnewpwd=="")
	{
		alert("Please Enter Confirm Password");
		return false;
	}
	if(newpwd!=cnfnewpwd)
	{
		alert("Password Does not match");
		return false;
	}
/////////////////////validation for Search////////////////////

	function searchvalid()
	{
	    var rollno=document.forms["search"]["rollno"].value;
		if(rollno=="")
		{
			alert("Please Enter Rollno");
			return false;
		}
	    
		
		if(isNaN(rollno))
		{
			alert("Please Enter Valid Roll Number");
			return false;
		}
	
}
}
