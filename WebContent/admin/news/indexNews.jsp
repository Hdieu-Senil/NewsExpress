<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.been.News"%>
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
								<strong class="card-title">Tin tức</strong>
							</div>
							<div class="col-md-4 ml-auto">
								<a href="<%=request.getContextPath()%>/admin/news/add"><i
									class="fa fa-plus-circle"></i> Thêm tin</a>
							</div>
						</div>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tên tin tức</th>
									<th>Danh mục</th>
									<th>Người đăng</th>
									<th>Ngày đăng</th>
									<th>Hình ảnh</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							
							<tbody>
							<%
								if(request.getAttribute("listNews")!= null){
									ArrayList<News> listNews = (ArrayList<News>)request.getAttribute("listNews");
									for(News objnews : listNews){
										
							%>
								<tr>
									<td><%=objnews.getIdNews() %></td>
									<td><%=objnews.getNews_name()%></td>
									<td><%=objnews.getCat_name() %></td>
									<td><%=objnews.getUser_name() %></td>
									<td>10/10/1010</td>
									<td>
										<img class="rounded-bottom mx-auto d-block" alt="" src="<%=request.getContextPath()%>/files/<%=objnews.getPicture() %>" style="width: 150px; height: 100px;">
									</td>
									<td>
										<a
											href="<%=request.getContextPath()%>/admin/news/edit?nid=<%=objnews.getIdNews()%>">Sửa
												<i class="fa fa-edit"></i>
										</a> 
										<a
											href="<%=request.getContextPath()%>/admin/news/del?nid=<%=objnews.getIdNews()%>">Xóa
												<i class="fa fa-trash-o"></i>
										</a>
									</td>
								</tr>
								<%}} %>
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

