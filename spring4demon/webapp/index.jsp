<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>首页</title>
    <script type="text/javascript">
        //处理键盘事件
        function doKey(e){
            var ev = e || window.event;//获取event对象
            var obj = ev.target || ev.srcElement;//获取事件源
            var t = obj.type || obj.getAttribute('type');//获取事件源类型
            if(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea"){
                return false;
            }
        }
        //禁止后退键 作用于Firefox、Opera
        document.onkeypress=doKey;
        //禁止后退键  作用于IE、Chrome
        document.onkeydown=doKey;
    </script>
</html>
</head>
<div align="center" style="height:300px;" id="index_top_div"></div>
<div align="center" id="index_middle_div"></div>
<div align="center" style="height:300px;"  id="index_foot_div"></div>
</html>