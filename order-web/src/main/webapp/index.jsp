<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>
<body>
	<b>实例</b>
	<li><a href="userList.do">查询全部</a></li>
 	<br>
    <li><a href="ws">查看webService</a></li>
    
    <form action="upload.do" method="post" enctype="multipart/form-data">  
    <table>  
        <tr>  
            <td width="100" align="right">照片：</td>  
            <td><input type="file" name="file"/>   <input type="submit"></td>  
        </tr>  
    </table>  
</form> 
</body>
</html>