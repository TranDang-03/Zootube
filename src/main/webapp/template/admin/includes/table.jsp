<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Danh sách người dùng</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Tên</th>
                  <th>Username</th>
                  <th>Email</th>
                  <th>Quyền</th>
                  <th>Trạng thái</th>
                  <th>Ngày tạo</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Tên</th>
                  <th>Username</th>
                  <th>Email</th>
                  <th>Quyền</th>
                  <th>Trạng thái</th>
                  <th>Ngày tạo</th>
                </tr>
              </tfoot>
              <tbody>
          <!--       <c:forEach items="${f:getAllUsers()}" var="users"> 
                <tr>
                  <td>${users.fullname}</td>
                  <td>${users.username}</td>
                  <td>${users.email}</td>
                  <td>${users.roleid}</td>
                  <td>${users.status}</td>
                  <td>${users.createddate}</td>
                </tr>
                </c:forEach> --> 
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
