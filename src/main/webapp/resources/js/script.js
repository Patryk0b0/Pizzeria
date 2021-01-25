$(document).ready(function () {
    
    $(".menu-list-item-quantity-higher").click(function () {
		var obj = $(this).parent().children('.menu-list-item-quantity-label');
        var value = parseInt(obj.text());
        if (value < 20) {
            obj.text(value + 1);
        }
	});
    
    $(".menu-list-item-quantity-lower").click(function () {
		var obj = $(this).parent().children('.menu-list-item-quantity-label');
        var value = parseInt(obj.text());
        if (value > 1) {
            obj.text(value - 1);
        }
	});
	
	$('.menu-box label').click(function () {
		$('.menu-list').hide();
	
		var class_name = $('.'+$(this).attr('class').split(' ')[1]);

		$(class_name).show();
	});
	
	$('.menu-list-order-label').click(function () {
		var tag = $(this).closest(".menu-list").attr('class').split(' ')[1];
		var main = $(this).closest(".menu-list-item");
		console.log(tag);
		var input_value = tag + "|";
		
		var basket = $("form .basket-container");
		basket.append("<p class='basket-item'></p>");
		var item = $("form .basket-item").last();		
		
		var name = main.find(".name");
		item.append("<label class='basket-item-name-label'>"+ name.text() +"</label>");
		input_value = input_value.concat(name.text() +"|");
		
		var price = main.find(".price");
		item.append("<label class='basket-item-price-label'>"+ price.text() +"</label><span> zł</span>");
		
		var amount = main.find(".menu-list-item-quantity-label");
		input_value = input_value.concat(amount.text() +"|");

		var addons = main.find(".menu-list-item-adds");
		input_value = input_value.concat("addon|");
		
		addons.find(".menu-list-item-adds-item").each(function() {
			if ($(this).find("input[type='checkbox']").prop('checked')) {				
				console.log($(this).find(".add-name").text());
				console.log($(this).find(".add-price").text());
				
				input_value = input_value.concat($(this).find(".add-name").text() +"|");
				
				item.append("<label class='basket-item-addon-name-label'>"+ $(this).find(".add-name").text() +"</label><span> </span>");
				item.append("<label class='basket-item-addon-price-label'>"+ $(this).find(".add-price").text() +"</label><span> zł</span>");
			}
		});

		
		
		console.log(name.text());
		console.log(price.text());
		console.log(amount.text());
		
		item.append("<input name='item' class='basket-item-name-label' value='"+input_value+"' readonly>");
		
//<input class="basket-item-price" value="20,00" readonly style="display: none;">
//<input class="basket-item-addon-name" value="Podwójny ser" readonly style="display: none;"><input class="basket-item-addon-price" value="2,00" readonly style="display: none;">

	});

});