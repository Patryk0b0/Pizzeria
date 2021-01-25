<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>

<main class="menu">
	<section class="menu-list">
		<c:if test="${not empty list}">
			<c:forEach items="${list}" var="listItem">
				<div class="history-item">
					Kupujący ${listItem.getName()} ${listItem.getSurname()}
					Data ${listItem.getDate().getYear()}.${listItem.getDate().getMonthValue()}.${listItem.getDate().getDayOfMonth()}
	
					<c:forEach items="${listItem.getItems()}" var="menuItem">
						<div>
							${menuItem.getItem().getName()}, ${menuItem.getItem().getPrice()}
							
							<c:if test="${ menuItem.getItem().getItemAddon().size() > 0}">
								Dodatki:
								<c:forEach items="${menuItem.getItem().getItemAddon()}" var="addon">
								
									${addon.getAddon().getName()} ${addon.getAddon().getPrice()}
								</c:forEach>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</c:if>
	</section>
</main>