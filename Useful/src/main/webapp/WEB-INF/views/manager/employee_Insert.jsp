<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
th {
	background-color: #CCC;
}

</style>
</head>
<body>
	<div>
		<font size="5" style="font-style: inherit;margin-right: 300px;">����������� </font>
		<button id="btn_Save">����</button>
		<button id="btn_List">���</button>
		<br>
	</div>
<hr>
	<table class="bbs_row">
		<colgroup>
			<col width="150" />
			<col />
		</colgroup>
		<tbody style="">
			<tr>
				<th>����ڵ�*</th>
				<td><input type="hidden" id="emp_no_dup_check" value="N" /> <input
					id="emp_no" name="emp_no" class="text" type="text" value="1"
					maxlength="20" /> <span id="sp_empNoDupMsg" class="blackColor b"></span>



				</td>
			</tr>
			<tr>
				<th>���� *</th>
				<td><input id="emp_nm" name="emp_nm" class="text" type="text"
					value="�赥��" maxlength="15" /></td>
			</tr>
			<tr>
				<th>��й�ȣ*</th>
				<td><input id="emp_pw" name="emp_pw" class="text" value="0000"
					type="password" value="" maxlength="20" /></td>
			</tr>
			<tr>
				<th>��й�ȣ Ȯ��*</th>
				<td><input type="password" id="emp_pw_confirm" class="text"
					maxlength="20" value="0000" /></td>
			</tr>
			<tr>
				<th>�ֹι�ȣ *</th>
				<td><input id="ssn" name="ssn" class="text" type="text"
					value="810416-1234001" maxlength="14" /></td>
			</tr>
			<tr>
				<th>�μ���*</th>
				<td><select id="dept_cd" name="dept_cd" class="select"
					style="width: 200px;">
						<option value="">-- ���� --</option>

						<option value="002">�Ӥä���</option>

						<option value="001" selected="selected">��������</option>

				</select></td>
			</tr>
			<tr>
				<th>��å *</th>
				<td><select id="position_cd" name="position_cd" class="select"
					style="width: 200px;">
						<option value="">-- ���� --</option>

						<option value="003">��ǥ</option>

						<option value="001" selected="selected">����</option>

						<option value="005">����</option>

						<option value="002">�븮</option>

						<option value="004">���</option>

				</select></td>
			</tr>
			
			<tr>
				<th>�̸���</th>
				<td><input id="email" name="email" class="text"
					style="width: 200px;" type="text" value="demo00@demo.co.kr"
					maxlength="50" /></td>
			</tr>
			<tr>
				<th>�ڵ��� *</th>
				<td><input id="mobile" name="mobile" class="text"
					style="width: 200px;" type="text" value="010-0000-0000"
					maxlength="20" />&nbsp;&nbsp;(ex 010-1234-1234)</td>
			</tr>
			<tr>
				<th>�ּ�</th>
				<td><input id="addr" name="addr" class="text"
					style="width: 100%;" type="text" value="����� �������� ���ǵ��� XXXX"
					maxlength="100" /></td>
			</tr>
			<tr>
				<th>���¹�ȣ</th>
				<td><input id="account_no" name="account_no" class="text"
					style="width: 200px;" type="text" value="" maxlength="100" /></td>
			</tr>

			<tr>
				<th>�Ի���</th>
				<td>
					<div id="div_inDt"></div>
				</td>
			</tr>

			<tr>
				<th>��������</th>
				<td><select id="work_status" name="work_status" class="select">

						<option value="E">����</option>

						<option value="W" selected="selected">����</option>

				</select></td>
			</tr>

			<tr>
				<th>�ֱ������Ͻ�</th>
				<td>2016-11-22 22:51:29</td>
			</tr>
		</tbody>
	</table>
</body>
</html>