<%@page import="model.been.Category"%>
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
								<strong class="card-title">Danh mục</strong>
							</div>
							<div class="col-md-4 ml-auto">
								<a href="<%=request.getContextPath()%>/admin/cat/add" style="float:right;"><i
									class="fa fa-plus-circle"></i> Thêm danh mục</a>
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
							<span class="badge badge-pill badge-<%=type%>"><%=result %></span>&emsp;<%=note %>
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
									<th>Category</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<%
									if (request.getAttribute("listCat") != null) {
										ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
										if (listCat.size() > 0) {
											for (Category objCat : listCat) {
								%>
								<tr>
									<th scope="row"><%=objCat.getIdCat()%></th>
									<td><%=objCat.getCat_name()%></td>
									<td><a
										href="<%=request.getContextPath()%>/admin/cat/edit?cid=<%=objCat.getIdCat()%>">Sửa
											<i class="fa fa-edit"></i>
									</a>&emsp;<a
										href="<%=request.getContextPath()%>/admin/cat/del?cid=<%=objCat.getIdCat()%>">Xóa
											<i class="fa fa-trash-o"></i>
									</a></td>
								</tr>

								<%
									}
										}
									}
								%>
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

