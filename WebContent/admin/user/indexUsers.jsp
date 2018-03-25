<%@page import="model.been.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<!--header  -->
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- end header -->

<!-- content -->

<div class="content mt-3">
	<div class="animated fadeIn">

		<div class="row">
			<div class="col-md-12">

				<div class="card">
					<div class="card-header">
						<div class="row">
							<div class="col-md-4">
								<strong class="card-title">Người dùng</strong>
							</div>
							<div class="col-md-4 ml-auto">
								<a href="<%=request.getContextPath()%>/admin/user/add"><i
									class="fa fa-plus-circle"></i> Thêm người dùng</a>
							</div>
						</div>
					</div>

					<div class="card-body">
						<%
							if (request.getParameter("msg") != null) {
								int msg = Integer.parseInt(request.getParameter("msg"));
								String result = null;
								String note = null;
								String type=null;
								
								switch (msg) {
								case 0:
									result = "Defeat";
									note = "Có lỗi trong quá trình xử lý!";
									type = "danger";
									break;
								case 1:
									result = "Success";
									note = "Thêm Thành công!";
									type = "primary";
									break;
								case 2:
									result = "Success";
									note = "Sửa Thành công!";
									type = "primary";
									break;
								case 3:
									result = "Success";
									note = "Xóa Thành công!";
									type = "primary";
									break;
								}
						%>
						<div
							class="sufee-alert alert with-close alert-primary alert-dismissible fade show">
							<span class="badge badge-pill badge-<%=type%>"><%=result %></span><%=note %>
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<%
							}
						%>
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Username</th>
									<th scope="col">Fullname</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<%
									if (request.getAttribute("listUser") != null) {
										ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
										if (listUser.size() > 0) {
											for (User objUser : listUser) {
								%>
								<tr>
									<th scope="row"><%=objUser.getIdUser()%></th>
									<td><%=objUser.getUsername()%></td>
									<td><%=objUser.getFullname()%></td>
									<td>
										<a
											href="<%=request.getContextPath()%>/admin/user/edit?uid=<%=objUser.getIdUser()%>">Sửa
												<i class="fa fa-edit"></i>
										</a> 
										<%if(!"admin".equals(objUser.getUsername())){ %>
										<a
											href="<%=request.getContextPath()%>/admin/user/del?uid=<%=objUser.getIdUser()%>">Xóa
												<i class="fa fa-trash-o"></i>
										</a>
										<%}%>
									</td>
								</tr>
								<%}}}%>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- .animated -->
</div>
<!-- end content -->

<%@include file="/templates/admin/inc/footer.jsp"%>

