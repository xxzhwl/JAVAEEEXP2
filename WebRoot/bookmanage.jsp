<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>ͼ�����ϵͳ</title>
<style>
	.font1{font-size:13px;}
</style>
<script language="javascript">
function check(thisObject){
	var sTmp="";
	sTmp=thisObject.value;
	if(isNaN(sTmp)){
		alert("����������");
		thisObject.select();
	}
}
</script>
</head>
<body>
	<table bgcolor=#71CABF align="center" class="font1">
		<tr>
			<td colspan="2"><jsp:include page="head.jsp"/></td>
		</tr>
		<tr>
			<s:form theme="simple" action="book" method="post" enctype="multipart/form-data" validate="true">
			<td><jsp:include page="funcselect.jsp"/></td>
			<td><jsp:include page="bookinfo.jsp"/></td>
			</s:form>
		</tr>
		<tr>
			<td colspan="2" align="center">
				�Ͼ�ʦ����ѧ���Ͼ�������·122��&nbsp;&nbsp;�ʱࣺ210097<br>ʦ�̽����о����İ�Ȩ����2010-2015
			</td>
		</tr>
	</table>
</body>
</html>
