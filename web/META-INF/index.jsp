<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<h2>Addition</h2>
<hr>
<form method=get action=\"http://localhost:8080/web_war_exploded/sum>
    Operand1<input type=text size=100 name=op1><br>
    Operand2<input type=text size=100 name=op2><br>
    <br><input type=submit value=Get>
</form>
<form method=post action=\"http://localhost:8080/web_war_exploded/sum>
    Operand1<input type=text size=100 name=op1><br>
    Operand2<input type=text size=100 name=op2><br>
    <br><input type=submit value=Post>
</form>
</body>
</html>
