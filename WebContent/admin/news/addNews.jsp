<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<!--header  -->
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- end header -->
<!-- content -->
<div class="col-lg-12">
	<div class="card">
		<div class="card-header">     
			<strong>Thêm tin</strong>
		</div>
		<div class="card-body card-block">
			<form action="" method="post" enctype="multipart/form-data"
				class="form-horizontal">
				<div class="row form-group">
					<div class="col col-md-3">
						<label class=" form-control-label">Static</label>
					</div>
					<div class="col-12 col-md-9">
						<p class="form-control-static">Username</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-3">
						<label for="text-input" class=" form-control-label">Tên tin tức</label>
					</div>
					<div class="col-12 col-md-9">
						<input type="text" id="text-input" name="text-input"
							placeholder="Text" class="form-control"><small
							class="form-text text-muted">This is a help text</small>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-3">
						<label for="select" class=" form-control-label">Danh mục</label>
					</div>
					<div class="col-12 col-md-9">
						<select name="select" id="select" class="form-control">
							<option value="0">Please select</option>
							<option value="1">Option #1</option>
							<option value="2">Option #2</option>
							<option value="3">Option #3</option>
						</select>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-3">
						<label for="textarea-input" class=" form-control-label">Mô tả</label>
					</div>
					<div class="col-12 col-md-9">
						<textarea name="textarea-input" id="textarea-input" rows="7"
							placeholder="Content..." class="form-control"></textarea>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-3">
						<label for="file-input" class=" form-control-label">File
							input</label>
					</div>
					<div class="col-12 col-md-9">
						<input type="file" id="file-input" name="file-input"
							class="form-control-file">
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-3">
						<label for="textarea-input" class=" form-control-label">Nội dung</label>
					</div>
					<div class="col-12 col-md-9">
						<textarea name="textarea-input" class="ckeditor" id="editor" rows="9"
							placeholder="Content..." class="form-control"></textarea>
					</div>
				</div>
			</form>
		</div>
		<div class="card-footer">
			<button type="submit" class="btn btn-primary btn-sm">
				<i class="fa fa-dot-circle-o"></i> Submit
			</button>
			<button type="reset" class="btn btn-danger btn-sm">
				<i class="fa fa-ban"></i> Reset
			</button>
		</div>
	</div>
</div>
<!-- end content -->
<%@include file="/templates/admin/inc/footer.jsp"%>

