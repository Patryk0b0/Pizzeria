<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>

<main class="menu">
	<div>
		<div>
			<h1>Nasze Menu</h1>
		</div>
		<div class="menu-box">
			<label class="menu-item pizza">Pizze</label>
			<label class="menu-item dish">Dania główne</label>
			<label class="menu-item soup">Zupy</label>
			<label class="menu-item drink">Napoje</label>
			<label class="menu-item basket">Koszyk</label>
		</div>
	</div>
	
	<section class="menu-list basket" style="display: none;">
		<div class="menu-header">
			<h2>Koszyk</h2>
		</div>
		<p class="full-price-box">
			<span>Do zapłaty łącznie: </span></span><span class="full-price">0.00</span><span> zł</span>
		</p>
		<!-- action='<spring:url value="/order"/>' -->
		<form class="basket-form" method="post" accept-charset="UTF-8">
			<div class="basket-container">

			</div>
			<div class="full-price-box">
				<p class="fieldset">
					<label name="user-name">Imię: </label>
					<input class="basket-user-name" name="user-name">
				</p>
				<p class="fieldset">
					<label name="user-surname">Nazwisko: </label>
					<input class="basket-user-surname" name="user-surname">
				</p>			
				<p class="fieldset">
					<label name="user-mail">Mail: </label>
					<input class="basket-user-mail" name="user-mail">
				</p>						
				<p class="fieldset">
					<input class="full-width" type="submit" value="Zamów">
				</p>
			</div>
		</form>
	</section>

	<section class="menu-list pizza">
		<div class="menu-header">
			<h2>Pizze</h2>
		</div>
		
		<c:if test="${not empty pizzas}">
			<c:forEach items="${pizzas}" var="pizza">
				<div class="menu-list-item">
					<div>
						<h3 class="name">${pizza.getName()}</h3>
						<span class="price"><fmt:formatNumber value="${pizza.getPrice()}" type="currency" currencySymbol="" /></span><span>zł</span>
					</div>
					
					<div class="menu-list-item-adds">
						<div>
							<h4>Dodatki:</h4>
						</div>
						
						<c:forEach items="${pizza.getPizzaAddons()}" var="addon">
							<div class="menu-list-item-adds-item">
								<input type="checkbox" id="pizza${pizza.getId()}-${addon.getAddon().getId()}" name="pizza${pizza.getId()}-${addon.getAddon().getId()}">
								<label for="pizza${pizza.getId()}-${addon.getAddon().getId()}" class="add-name">${addon.getAddon().getName()} </label><span> (</span><label for="pizza${pizza.getId()}-${addon.getAddon().getId()}" class="add-price"><fmt:formatNumber value="${addon.getAddon().getPrice()}" type="currency" currencySymbol="" /></label><span>zł)</span>
							</div>
						</c:forEach>
					</div>
					
					<div class="menu-list-item-quantity left">
						<label class="menu-list-item-quantity-lower">-</label>
						<label class="menu-list-item-quantity-label">1</label>
						<label class="menu-list-item-quantity-higher">+</label>
					</div>
					<div class="menu-list-order left">
						<label class="menu-list-order-label">Dodaj do zamówienia</label>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</section>
	
	<section class="menu-list dish" style="display: none;">
		<div class="menu-header">
			<h2>Dania główne</h2>
		</div>
		
		<c:if test="${not empty dishes}">
			<c:forEach items="${dishes}" var="dish">
				<div class="menu-list-item">
					<div>
						<h3 class="name">${dish.getName()}</h3>
						<span class="price"><fmt:formatNumber value="${dish.getPrice()}" type="currency" currencySymbol="" /></span><span>zł</span>
					</div>
					
					<div class="menu-list-item-adds">
						<div>
							<h4>Dodatki:</h4>
						</div>
						
						<c:forEach items="${dish.getDishAddons()}" var="addon">
							<div class="menu-list-item-adds-item">
								<input type="checkbox" id="dish${dish.getId()}-${addon.getAddon().getId()}" name="dish${dish.getId()}-${addon.getAddon().getId()}">
								<label for="dish${dish.getId()}-${addon.getAddon().getId()}" class="add-name">${addon.getAddon().getName()} </label><span> (</span><label for="dish${dish.getId()}-${addon.getAddon().getId()}" class="add-price"><fmt:formatNumber value="${addon.getAddon().getPrice()}" type="currency" currencySymbol="" /><span>zł</span>)</label>
							</div>
						</c:forEach>
					</div>
					
					<div class="menu-list-item-quantity left">
						<label class="menu-list-item-quantity-lower">-</label>
						<label class="menu-list-item-quantity-label">1</label>
						<label class="menu-list-item-quantity-higher">+</label>
					</div>
					<div class="menu-list-order left">
						<label class="menu-list-order-label">Dodaj do zamówienia</label>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</section>
	
	<section class="menu-list soup" style="display: none;">
		<div class="menu-header">
			<h2>Zupy</h2>
		</div>
		
		<c:if test="${not empty soups}">
			<c:forEach items="${soups}" var="soup">
				<div class="menu-list-item">
					<div>
						<h3 class="name">${soup.getName()}</h3>
						<span class="price"><fmt:formatNumber value="${soup.getPrice()}" type="currency" currencySymbol="" /></span><span>zł</span>
					</div>
					
					<div class="menu-list-item-quantity left">
						<label class="menu-list-item-quantity-lower">-</label>
						<label class="menu-list-item-quantity-label">1</label>
						<label class="menu-list-item-quantity-higher">+</label>
					</div>
					<div class="menu-list-order left">
						<label class="menu-list-order-label">Dodaj do zamówienia</label>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</section>
	
	<section class="menu-list drink" style="display: none;">
		<div class="menu-header">
			<h2>Napoje</h2>
		</div>
		
		<c:if test="${not empty drinks}">
			<c:forEach items="${drinks}" var="drink">
				<div class="menu-list-item">
					<div>
						<h3 class="name">${drink.getName()}</h3>
						<span class="price"><fmt:formatNumber value="${drink.getPrice()}" type="currency" currencySymbol="" /></span><span>zł</span>
					</div>
					
					<div class="menu-list-item-quantity left">
						<label class="menu-list-item-quantity-lower">-</label>
						<label class="menu-list-item-quantity-label">1</label>
						<label class="menu-list-item-quantity-higher">+</label>
					</div>
					<div class="menu-list-order left">
						<label class="menu-list-order-label">Dodaj do zamówienia</label>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</section>	
	
	<script src="<c:url value="/js/script.js" />"></script>
</main>