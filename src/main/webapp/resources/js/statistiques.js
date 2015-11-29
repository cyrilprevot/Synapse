jQuery(document).ready(function()
{
   // On cache la zone de texte
   jQuery('.TopRace').hide();
   jQuery('.TopClazz').hide();
   jQuery('.TopSpec').hide();
   jQuery('.TopUsers').hide();
   jQuery('.UsersWithoutAvatar').hide();
   jQuery('.details').hide();
   
	setTimeout(function() { 
		$('.TopRace').fadeIn(); 
		$('.TopClazz').delay(500).fadeIn();
		$('.TopSpec').delay(1000).fadeIn();
		$('.TopUsers').delay(1500).fadeIn();
		$('.UsersWithoutAvatar').delay(2000).fadeIn();
	}, 500);
	
	$('.element').click(function(event)
			{
				$(this).next().slideDown();
				$(this).siblings('.element').next().slideUp();
			});
   
});
