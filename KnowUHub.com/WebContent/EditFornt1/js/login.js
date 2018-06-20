function valid()
{
	var x=document.forms["fname"]["t1"].value;
	if(x=="")
	{
		alert("Please enter Roll Number");
		return false;
	}
	if(isNaN(x))
	{
		alert("Please enter valid Roll Number");
		return false;
	}
	if((x).length>=11)
	{
		alert("Please enter valid Roll Number");
		return false;
	}
    var y=document.forms["fname"]["t2"].value;
	if(y=="")
	{
		alert("Please Enter Password");
		return false;
	}


}
