<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.ac.kku.cs.wp.hyuk.user.User" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="custom" uri="kr.ac.kku.cs.wp.hyuk.tools.tags.custom" %>


<h2>Custom 사용자 목록</h2>



<!-- 필터 입력 필드 -->
<div class="filter-container">
    <input type="text" id="user-filter" placeholder="이름, 이메일, 역할 또는 사번으로 검색" onkeyup="filterUsers()">
</div>

<div id="user-count" style="margin-bottom: 15px;">전체 :<strong>${fn:length(requestScope.users)}</strong></div>

<div class="user-card-container" id="user-list">

<c:forEach var="user" items="${requestScope.users}">
    <!-- 사용자 카드 1 (여러 역할 및 사번 추가) -->
	<custom:userCard status="${user.status}" email="${user.email}" name="${user.name}" roles="${user.roles[0]},${user.roles[1]}" id="${user.id}" />
</c:forEach>
</div>

<script>
    // 사용자 필터링 함수
    function filterUsers() {
        const filterValue = document.getElementById('user-filter').value.toLowerCase();
        const users = document.getElementsByClassName('user-card');

        for (let i = 0; i < users.length; i++) {
            const userName = users[i].getAttribute('data-name').toLowerCase();
            const userEmail = users[i].getAttribute('data-email').toLowerCase();
            const userRole = users[i].getAttribute('data-role').toLowerCase();
            const userId = users[i].getAttribute('data-id').toLowerCase();

            if (userName.includes(filterValue) || userEmail.includes(filterValue) || userRole.includes(filterValue) || userId.includes(filterValue)) {
                users[i].style.display = "block";
            } else {
                users[i].style.display = "none";
            }
        }
    }
</script>

<style>
    .filter-container {
        margin-bottom: 20px;
    }

    .filter-container input {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .user-card-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(180px, 1fr)); /* 카드 크기를 좁게 설정 */
        gap: 20px;
    }

    .user-card {
        background-color: white;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        text-align: center;
        transition: transform 0.3s ease;
        width: 180px; /* 카드 폭을 좁게 */
        height: 300px; /* 카드 높이를 길게 */
    }

    .user-card:hover {
        transform: scale(1.05);
    }

    .user-card img {
        width: 100%;
        height: 150px; /* 이미지 높이 늘림 */
        object-fit: cover;
    }

    .user-info {
        padding: 10px;
        font-size: 14px;
    }

    .user-info h3 {
        font-size: 16px;
        margin-bottom: 10px;
        color: #007bff;
    }

     .user-info p {
        font-size: 12px;
        color: #333;
        line-height : 0;
        margin-bottom : 15px;
    }


    .user-info button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 5px 10px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 12px;
        margin-top: 10px;
    }

    .user-info button:hover {
        background-color: #0056b3;
    }

    /* 반응형 디자인 */
    @media (max-width: 768px) {
        .user-card-container {
            grid-template-columns: repeat(auto-fit, minmax(120px, 1fr)); /* 작은 화면에서 더 좁게 */
        }

        .user-info h3 {
            font-size: 14px;
        }

        .user-info p {
            font-size: 11px;
        }

        .user-info button {
            font-size: 10px;
        }
    }
</style>
    