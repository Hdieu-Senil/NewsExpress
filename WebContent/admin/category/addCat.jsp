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
					<div class="card-header">Thêm danh mục</div>
					<div class="card-body card-block">
						<form action="<%=request.getContextPath()%>/admin/cat/add" method="post" class="col-8">
							<div class="form-group">
								<div class="input-group">
									<input type="text" id="username" name="category"
										placeholder="Danh mục" class="form-control">
									<div class="input-group-addon">
										<i class="fa fa-pencil"></i>
									</div>
								</div>
								<%
									if(request.getParameter("msg")!=null){
										int msg = Integer.parseInt(request.getParameter("msg")) ;
										switch(msg){
										case 0: out.print("<p style = 'color: red'>Danh mục này đã tồn tại. Vui lòng nhập tên danh mục khác</p>");
										}
									}
								%>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">
								<i class="fa fa-dot-circle-o"></i> Submit
							</button>
							<button type="reset" class="btn btn-danger btn-sm">
								<i class="fa fa-ban"></i> Reset
							</button>

						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<!-- end content -->
<%@include file="/templates/admin/inc/footer.jsp"%>