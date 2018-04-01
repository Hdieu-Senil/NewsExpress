<%@page import="model.been.Category"%>
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
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">Sửa danh mục</div>
					<div class="card-body card-block">
						<%
							if (request.getAttribute("objCat") != null) {
								Category objCat = (Category) request.getAttribute("objCat");
						%>
						<form action="" method="post" class="col-8">
							<div class="form-group">
								<div class="input-group">
									<input type="text" id="username" name="catName"
										value="<%=objCat.getCat_name()%>" placeholder="Tên danh mục"
										class="form-control">
									<div class="input-group-addon">
										<i class="fa fa-pencil"></i>
									</div>
								</div>
								<%
									if (request.getParameter("msg") != null) {
											int msg = Integer.parseInt(request.getParameter("msg"));
											if (msg == 0) {
												out.print(
														"<p style='color: red'>Tên danh mục này đã tồn tại. Vui lòng nhập tên danh mục khác!</p>");
											}
										}
								%>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="hidden" id="fullname" name="idCat"
										value="<%=objCat.getIdCat()%>">
								</div>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">
								<i class="fa fa-dot-circle-o"></i> Submit
							</button>
							<button type="reset" class="btn btn-danger btn-sm">
								<i class="fa fa-ban"></i> Reset
							</button>
						</form>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end content -->
<%@include file="/templates/admin/inc/footer.jsp"%>