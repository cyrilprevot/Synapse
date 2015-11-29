jQuery(document).ready(function()
{
   // On cache la zone de texte

	
	$('.element').click(function(event)
			{
				$(this).next().slideDown();
				$(this).siblings('.element').next().slideUp();
			});
   
});
