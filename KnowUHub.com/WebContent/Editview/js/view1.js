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
/////////////////////validation for Search////////////////////

	

}
