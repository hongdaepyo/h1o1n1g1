$(document).ready(function() {
		
		$('#prev_btn').click(function() {
			m--;
			theDate.setMonth(m);
			alert(theDate);
			
		});
		
		$('#next_btn').click(function() {
			m++;
			theDate.setMonth(m);
			cal();
		}); 
		
	});

