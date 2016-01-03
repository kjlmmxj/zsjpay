<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>版本管理</title>
<style type="text/css">
body {width:90%; margin-right: auto; margin-left: auto; font-size: 14px;}
span { color:red;}
.myTable,.myTable td { border:1px solid #cccccc; border-collapse:collapse; padding:5px 2px;} 
.myTable {width: 100%;}
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	function create(){
		$("#editbox").css("display","none");
		$("#createbox").css("display","block");
	}
	function edit(id) {
		$("#createbox").css("display","none");
		$("#editbox").css("display","block");
		$.ajax({
			type : "POST",
			url : "<%=basePath%>admin/queryVersion.do",
			data : "id=" + id,
			success : function(data) {
				$("#eid").val(data.id);
				$("#ename").val(data.name);
				$("#eversion").val(data.version);
				$("#etype").val(data.type);
				if (data.update_level) {
					$("input[id=eupdate_level][value=true]").attr("checked",
							true);
				} else {
					$("input[id=eupdate_level][value=false]").attr("checked",
							true);
				}
				$("#eupdate_url").val(data.update_url);
				$("#eupdate_description").val(data.update_description);
			}
		});
	}
	
	function chkCreate(){
		if ($("#name").val()=="") {
			$("#msgname").html("The name is required!");
			return false;
		}else{
			$("#msgname").html("");
		}
		
		if ($("#version").val()=="") {
			$("#vermsg").html("The version number is required!");
			return false;
		}else{
			$("#vermsg").html("");
		}
		
		if ($("#type").val()=="") {
			$("#typemsg").html("The type is required!");
			return false;
		}else{
			$("#typemsg").html("");
		}
		
		if($("#update_url").val()==""){
			$("#urlmsg").html("The update the address is required!");
			return false;
		}else{
			$("#urlmsg").html("");
		}
		return true;
	}

	function chkEdit() {
		if ($("#ename").val()=="") {
			$("#enamemsg").html("The name is required!");
			return false;
		}else{
			$("#msgname").html("");
		}
		
		if ($("#eversion").val()=="") {
			$("#evermsg").html("The version number is required!");
			return false;
		}else{
			$("#evermsg").html("");
		}
		
		if ($("#etype").val()=="") {
			$("#etypemsg").html("The type is required!");
			return false;
		}else{
			$("#etypemsg").html("");
		}
		
		if($("#eupdate_url").val()==""){
			$("#eurlmsg").html("The update the address is required!");
			return false;
		}else{
			$("#eurlmsg").html("");
		}
		return true;
	}
</script>
</head>
<body>
	<h1>欢迎来到版本管理页面</h1>
	<div align="right">
		<a href="javascript:create()">新增</a>
	</div>
	<br />
	<div>
		<table class="myTable">
			<tr>
				<!-- <td>编号ID</td> -->
				<td>APP名称</td>
				<td>版本号</td>
				<td>类&nbsp;&nbsp;&nbsp;&nbsp;型</td>
				<td>强制更新</td>
				<td>更新日期</td>
				<td>下载地址</td>
				<td>更新说明</td>
				<td>操&nbsp;&nbsp;作</td>
			</tr>
			<c:forEach var="ver" items="${versions}">
				<tr>
					<!-- <td>&nbsp;${ver.id}</td> -->
					<td>${ver.name}&nbsp;</td>
					<td>${ver.version}&nbsp;</td>
					<td>${ver.type}&nbsp;</td>
					<td>${ver.update_level}&nbsp;</td>
					<td>${ver.update_date}&nbsp;</td>
					<td>${ver.update_url}&nbsp;</td>
					<td>${ver.update_description}&nbsp;</td>
					<td>&nbsp;&nbsp;<a id="v${i.index}"
						href="javascript:edit('${ver.id}')">改</a>&nbsp;&nbsp;
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<h1 id="message" style="color: red;">${message}</h1>
	<div id="editbox" style="display: none;">
		<hr />
		<br />
		<h3>修改</h3>
		<form action="<%=basePath%>admin/editVersion.do" method="post" onsubmit="return chkEdit()"
			id="editform">
			<p style="display: none">
				编号ID：<input type="text" id="eid" name="id" readonly="readonly" />
			</p>
			<p>
				APP名称：<input type="text" id="ename" name="name" onkeyup="value=value.trim()"/>&nbsp;<span id="emsgname"></span>
			</p>
			<p>
				版本号：<input type="text" id="eversion" name="version" onkeyup="value=value.trim()"/>&nbsp;<span id="evermsg"></span>
			</p>
			<p>
				类&nbsp;&nbsp;&nbsp;&nbsp;型：<input type="text" id="etype" name="type" onkeyup="value=value.trim()"/>&nbsp;<span id="etypemsg"></span>
			</p>
			<p>
				更新级别：<label><input type="radio" id="eupdate_level"
					name="update_level" value="false" checked="checked" />一般更新</label>&nbsp;&nbsp;<label><input
					type="radio" id="eupdate_level" name="update_level" value="true" />强制更新</label>
			</p>
			<p>
				下载地址：<input type="text" id="eupdate_url" name="update_url" size="99" onkeyup="value=value.trim()"/>&nbsp;<span id="eurlmsg"></span>
			</p>
			<p>
				更新说明：
				<textarea id="eupdate_description" name="update_description"
					cols="75" rows="5"></textarea>
			</p>
			<p>
				<input type="submit" id="edit" name="edit" value="修改" />
			</p>
		</form>
	</div>
	<div id="createbox" style="display: none;">
		<hr />
		<br />
		<h3>新增</h3>
		<form action="<%=basePath%>admin/createVersion.do" method="post" onsubmit="return chkCreate();">
			<p>
				APP名称：<input type="text" id="name" name="name" onkeyup="value=value.trim()"/>&nbsp;<span id="msgname"></span>
			</p>
			<p>
				版本号：<input type="text" id="version" name="version" onkeyup="value=value.trim()"/>&nbsp;<span id="vermsg"></span>
			</p>
			<p>
				类&nbsp;&nbsp;&nbsp;&nbsp;型：<input type="text" id="type" name="type" onkeyup="value=value.trim()"/>&nbsp;<span id="typemsg"></span>
			</p>
			<p>
				更新级别：<label><input type="radio" id="update_level"
					name="update_level" value="false" checked="checked" />一般更新</label>&nbsp;&nbsp;<label><input
					type="radio" id="update_level" name="update_level" value="true" />强制更新</label>
			</p>
			<p>
				下载地址：<input type="text" id="update_url" name="update_url" size="99" onkeyup="value=value.trim()"/>&nbsp;<span id="urlmsg"></span>
			</p>
			<p>
				更新说明：
				<textarea id="update_description" name="update_description"
					cols="75" rows="5"></textarea>
			</p>
			<p>
				<input type="submit" id="create" name="create" value="新增" />
			</p>
		</form>
	</div>
</body>
</html>