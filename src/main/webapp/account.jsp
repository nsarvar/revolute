<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create an account</title>
</head>
<body>
<h2>Create an accaunt</h2>
    
    <p>
    <a href="/revolut">Home Page</a> |
    <a href="webapi/accounts">Accounts</a> |
    <a href="webapi/transfers">Transfer History</a></p>     
    <hr>

<form id='form' action='revolut/webapi/accounts' method='POST'>
<table>
	<tr><td>Name: </td><td><input type='text' name='name'></td></tr>
	<tr><td>Balance: </td><td><input type='text' name='balance'></td></tr>
	<tr><td><input id='submit' type='submit' value='Save'></td><td></td></tr>
</table>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
function ConvertFormToJSON(form){
    var array = jQuery(form).serializeArray();
    var json = {};
    
    jQuery.each(array, function() {
        json[this.name] = this.value || '';
    });
    
    return json;
}

    $(document).ready(function(){
    	$("#submit").on('click', function(){
    		var data = JSON.stringify(ConvertFormToJSON($("#form")));
        	 // send ajax
            $.ajax({
                url: 'http://localhost:8080/revolut/webapi/accounts', // url where to submit the request
                type : "POST", // method type 
                dataType : 'json', // data type
                data : data, 
                headers: { 
                	'Accept': 'application/json',
                	'Content-Type': 'application/json' 
                },
                success : function(result) {
                    alert(result.message);
                    $("form")[0].reset();
                },
                error: function(resp) {
                    var jsonResponseText = $.parseJSON(resp.responseText);
					alert(jsonResponseText.message);
                }
            });

            return false;
        });
    });
</script>

</body>
</html>
