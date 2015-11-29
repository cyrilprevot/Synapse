/**
 * 
 */

$(document).ready(function(){
	$("p[stattype]").click(function(){
		$.ajax({
			url: "/synapse/stats/json/" + $(this).attr("stattype") + "/" + $(this).attr("idtype"),
			type: 'GET',
			context: this,
			success:function(data){
				if($(this).find("div").length == 0){
					data = JSON.parse(data);
					var elem = this;
					data.sort(function(a, b) {
					    return b.nb - a.nb;
					});
					addElem(elem, data);
				}
				$(this).find("div").slideToggle(500);
				$(this).siblings(this).find("div").slideUp();
			}
		});

	});
	
	function addElem(elem, data){
		var div = document.createElement("div");
		$(div).addClass("TopDetails");
		data.forEach(function(value){
			var p = document.createElement("p");
			$(p).text(value.name + " : " + value.nb);
			$(div).append(p);
		});
		$(elem).append(div);
		
	}
	
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
});