<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Web路径 -->
<%
	request.setAttribute("APP_PATH", request.getContextPath());
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>list</title>
<link href="${APP_PATH}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${APP_PATH}/jquery/jquery-1.11.0.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>ssm-crud</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-8 col-md-4">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:forEach items="${pageInfo.list}" var="emp">
						<tbody>
							<tr>
								<th scope="row">${emp.empId }</th>
								<td>${emp.empName }</td>
								<td>${emp.gender == "M" ? "男" : "女"}</td>
								<td>${emp.email }</td>
								<td>${emp.department.deptName }</td>
								<td>
									<button class="btn btn-primary">
										<span class="glyphicon glyphicon glyphicon-pencil"></span> 编辑
									</button>
									<button class="btn btn-danger">
										<span class="glyphicon glyphicon glyphicon-trash"></span> 删除
									</button>
								</td>
							</tr>
						</tbody>

					</c:forEach>

				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">当前页码：${pageInfo.pageNum }，总${pageInfo.pages }页，总${pageInfo.total }条记录</div>
			<div class="col-md-6">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li><a href="${APP_PATH}/emps">首页</a></li>
						<c:if test="${ pageInfo.pageNum != 1}">
							<li><a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach items="${ pageInfo.navigatepageNums}" var="i">
							<c:if test="${i == pageInfo.pageNum }">
								<li class="active"><a href="#">${i}</a></li>
							</c:if>
							<c:if test="${i != pageInfo.pageNum }">
								<li><a href="${APP_PATH}/emps?pn=${i}">${i}</a></li>
							</c:if>

						</c:forEach>
						<c:if test="${ pageInfo.pageNum != pageInfo.pages}">
							<li><a href="${APP_PATH}/emps?pn=${pageInfo.pageNum + 1 }" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>

						</c:if>

						<li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
					</ul>
				</nav>
			</div>

		</div>
	</div>


</body>
</html>