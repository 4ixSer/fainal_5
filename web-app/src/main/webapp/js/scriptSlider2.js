$(function() {
	    $( "#slider-range2" ).slider({
	      // orientation: "vertical",
	      // step: 15,
	      range: true,
	      min: 0,
	      max: 20,
	      values: [ 6, 15 ],
	      slide: function( event, ui ) {
	        $( "#amount2" ).val( ui.values[ 0 ] );
	        $( "#amount_2" ).val( ui.values[ 1 ] );
	      }
	    });
	    $( "#amount2" ).val( $( "#slider-range2" ).slider( "values", 0 ) );
	    $( "#amount_2" ).val( $( "#slider-range2" ).slider( "values", 1 ) );

	    // Изменение местоположения ползунка при вводиде данных в первый элемент input
		  $("input#amount2").change(function(){
		  	var value1=$("input#amount2").val();
		  	var value2=$("input#amount_2").val();
		      if(parseInt(value1) > parseInt(value2)){
		  		value1 = value2;
		  		$("input#amount2").val(value1);
		  	}
		  	$("#slider-range2").slider("values",0,value1);
		  });
		      
		  // Изменение местоположения ползунка при вводиде данных в второй элемент input 	
		  $("input#amount_2").change(function(){
		  	var value1=$("input#amount2").val();
		  	var value2=$("input#amount_2").val();

		  	if(parseInt(value1) > parseInt(value2)){
		  		value2 = value1;
		  		$("input#amount_2").val(value2);
		  	}
		  	$("#slider-range2").slider("values1",1,value2);
		  });

		  // фильтрация ввода в поля
			jQuery('#amount2, #amount_2').keypress(function(event){
				var key, keyChar;
				if(!event) var event = window.event;
				
				if (event.keyCode) key = event.keyCode;
				else if(event.which) key = event.which;
			
				if(key==null || key==0 || key==8 || key==13 || key==9 || key==46 || key==37 || key==39 ) return true;
				keyChar=String.fromCharCode(key);
				
				if(!/\d/.test(keyChar))	return false;
			
			});

	  });

