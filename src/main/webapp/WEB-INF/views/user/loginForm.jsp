<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class= "container">

<form action="/login" class="was-validated" method="post">
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" class="form-control"  placeholder="Enter username" name="username" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control"  placeholder="Enter password" name="password" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>

  <button type="submit" class="btn btn-primary">login</button>
  <button type="submit" class="btn btn-primary" onClick="location.href='/joinForm'">join</button>

</form>

</div>

<%@ include file="../layout/footer.jsp" %>