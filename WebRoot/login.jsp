<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ͼ�����ϵͳ</title>
</head>
<body bgcolor="#71CABF">
<s:form action="login" method="post" theme="simple">
	<table>
		<caption>�û���¼</caption>
		<tr>
			<td>��¼��<s:textfield name="login.name" size="20"/></td>
		</tr>
		<tr>
			<td>��&nbsp;&nbsp;��<s:password name="login.password" size="21"/></td>
		</tr>
		<tr>
			<td>
				<s:submit value="��¼"/>
				<s:reset value="����"/>
			</td>
		</tr>
		<!-- ��֤ʧ����Ϣ�������Ϣ��������ʾ -->
		<tr>
			<td>
				<font color="red"><s:fielderror/><s:property value="message"/></font>
			</td>
		</tr>
	</table>
</s:form>
</body>
</html>
