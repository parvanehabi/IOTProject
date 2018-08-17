function set_window_size()
{  

	if($(window).width()<1680 &&$(window).width()>=1500){
		$('.blue').css('color','#00F');
	}
	else if($(window).width()<1500 &&$(window).width()>=1199){
		$('.blue').css('color','#00F');
	}
	else if($(window).width()<1199 && $(window).width()>=991){
		$('.blue').css('color','#00F');
	}
	else if($(window).width()<991 && $(window).width()>=885){
        $('.blue').css('color','#00F');
	}
	else if($(window).width()<885 && $(window).width()>=768){
        $('.blue').css('color','#00F');
	}
	else if($(window).width()<768){
		$('.blue').css('color','#F00');

	}
	else{

	}
}

$(window).resize(function(e) {
	set_window_size();
});

$(document).ready(function(e) {
	set_window_size();

});
$(document).ready(function() {
	 $(window).scroll(function(){
		 var height=$('#userLogin').outerHeight();
		  if ($(this).scrollTop() > height) {
			  $('#mainHeader').addClass('fixed');
		  } else {
			  $('#mainHeader').removeClass('fixed');
		  }
	  });
});
function setcity(){
	  var out=document.getElementById('Mahal');
	  switch($('#city').val())
	  {
		  case 'انتخاب شهر':
			out.innerHTML='';
		  break;
		  case 'تهران':
		  	out.innerHTML='<option>تهران پارس</option><option>شهرک دانش</option><option>مهران آباد</option>';
			 break;
			  
		  case 'مشهد':
		  	out.innerHTML='<option>قاسم آباد</option><option>سجاد</option><option>فرامرز عباسی</option>';
			  break;
		  case 'سمنان':
			 out.innerHTML='<option>سمنان منطقه 1</option><option>سمنان منطقه2 </option><option>سمنان منطقه3 </option>';
			  break;
		  case 'تبریز':
			out.innerHTML='<option>تبریز1</option><option>تبریز2</option><option>تبریز3</option><option>تبریز5</option>';
			  break;
		  case 'شیراز':
			 out.innerHTML='<option>شیراز1</option><option>شیراز2</option><option>شیراز3</option>';
			  break;
		  }
	};

function setstate(){
	  var outminrahn=document.getElementById('stateset1');
	  var outmaxrahn=document.getElementById('stateset2');


	  switch($('#state').val())
	  {
		  case 'وضعیت':
		  outminrahn.innerHTML='';
		  outmaxrahn.innerHTML='';
		  break;
		  case 'رهن و اجاره':
		  	outminrahn.innerHTML='<label for="location">حدود ودیعه</label><select class="form-control"><option>۵-10 میلیون تومان</option><option>10-20 میلیون تومان</option><option>20-30 میلیون تومان</option><option>30-40میلیون تومان</option><option>40-50 میلیون تومان</option><option>50-60 میلیون تومان</option><option>60-70 میلیون تومان</option><option>70-80 میلیون تومان</option><option>80-90 میلیون تومان</option><option>90-100میلیون تومان</option><option>100-110 میلیون تومان</option><option>110-120 میلیون تومان</option><option>120-150 میلیون تومان</option><option>بیش از 150 میلیون تومان</option></select>';
			outmaxrahn.innerHTML='<label for="location">حدود اجاره</label><select class="form-control"><option>رهن کامل</option><option>100-200هزارتومان</option><option>200-300هزارتومان</option><option>300-400هزارتومان</option><option>400-500هزارتومان</option><option>500-600هزارتومان</option><option>600-700هزارتومان</option><option>800-900هزارتومان</option><option>900به بالا</option></select>';
			 break;
			  
		  case 'فروش':
		  	outminrahn.innerHTML='<label for="location">حداقل هزینه</label><select class="form-control"><option>۵۰ میلیون تومان</option><option>۱۰۰ میلیون تومان</option><option>۱۵۰ میلیون تومان</option><option>۲۰۰ میلیون تومان</option><option>۲۵۰ میلیون تومان</option><option>۳۰۰ میلیون تومان</option><option>۳۵۰ میلیون تومان</option></select>';
			outmaxrahn.innerHTML='<label for="location">حداکثر هزینه</label><select class="form-control"><option>۵۰ میلیون تومان</option><option>۱۰۰ میلیون تومان</option><option>۱۵۰ میلیون تومان</option><option>۲۰۰ میلیون تومان</option><option>۲۵۰ میلیون تومان</option><option>۳۰۰ میلیون تومان</option><option>۳۵۰ میلیون تومان</option></select>';
			 break;
		  }
	};
	
	function setstatequick(){
	  var outminrahn=document.getElementById('statesetq1');
	  var outmaxrahn=document.getElementById('statesetq2');


	  switch($('#state').val())
	  {
		  case 'وضعیت':
		  outminrahn.innerHTML='';
		  outmaxrahn.innerHTML='';
		  break;
		  case 'رهن و اجاره':
		  	outminrahn.innerHTML='<label for="location">حدود ودیعه</label><select class="form-control"><option>۵-10 میلیون تومان</option><option>10-20 میلیون تومان</option><option>20-30 میلیون تومان</option><option>30-40میلیون تومان</option><option>40-50 میلیون تومان</option><option>50-60 میلیون تومان</option><option>60-70 میلیون تومان</option><option>70-80 میلیون تومان</option><option>80-90 میلیون تومان</option><option>90-100میلیون تومان</option><option>100-110 میلیون تومان</option><option>110-120 میلیون تومان</option><option>120-150 میلیون تومان</option><option>بیش از 150 میلیون تومان</option></select>';
			outmaxrahn.innerHTML='<label for="location">حدود اجاره</label><select class="form-control"><option>رهن کامل</option><option>100-200هزارتومان</option><option>200-300هزارتومان</option><option>300-400هزارتومان</option><option>400-500هزارتومان</option><option>500-600هزارتومان</option><option>600-700هزارتومان</option><option>800-900هزارتومان</option><option>900به بالا</option></select>';
			 break;
			  
		  case 'فروش':
		  	outminrahn.innerHTML='<label for="location">حداقل هزینه</label><select class="form-control"><option><option>۵۰ میلیون تومان</option><option>۱۰۰ میلیون تومان</option><option>۱۵۰ میلیون تومان</option><option>۲۰۰ میلیون تومان</option><option>۲۵۰ میلیون تومان</option><option>۳۰۰ میلیون تومان</option><option>۳۵۰ میلیون تومان</option></select>';
			outmaxrahn.innerHTML='<label for="location">حداکثر هزینه</label><select class="form-control"><option><option>۵۰ میلیون تومان</option><option>۱۰۰ میلیون تومان</option><option>۱۵۰ میلیون تومان</option><option>۲۰۰ میلیون تومان</option><option>۲۵۰ میلیون تومان</option><option>۳۰۰ میلیون تومان</option><option>۳۵۰ میلیون تومان</option></select>';
			 break;
		  }
	};