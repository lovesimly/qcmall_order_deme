<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>

<script  src="resources/js/jquery-1.8.3.js">//引入jquery框架
  </script>
  
  <script type="text/javascript">
  function doUpload() {  
  alert("s");
     var formData = new FormData($( "#uploadForm" )[0]);  
     $.ajax({  
          url: 'upload2.do' ,  
          type: 'POST',  
          data: formData,  
          async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
          success: function (returndata) {  
              alert(returndata);  
          },  
          error: function (returndata) {  
              alert(returndata);  
          }  
     });  
} 
  </script>
<body>
	
    <form id="uploadForm" action="upload2.do" method="post" enctype="multipart/form-data">  
    <table>  
        <tr>  
            <td width="100" align="right">照片：</td>  
            <td><input type="file" name="file"/>   <input type="button" onclick="doUpload()"  value="提交"></td>  
        </tr>  
    </table>  
</form> 
</body>
</html>