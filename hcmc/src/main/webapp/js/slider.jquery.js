;(function($, window, undefined) {

    $.fn.slider = function(prev, sig) {
        return this.each(function(){
            $container = $(this).children().eq(0);

            if($container) {
                var $fotos = $container.children();
                var cantidad = $fotos.length; //사진 갯수
                var incremento = $fotos.outerWidth(true); //border를 포함한 넓이
                var enSlider = Math.floor($(this).width() / incremento);
                var primerElemento = 1;
                var estaMoviendo = false;
            }
            console.log('fotos: '+$fotos+' cantidad: '+cantidad+' incremento: '+incremento+ ' enSlider: '+enSlider)

            $container.css('width', (cantidad + enSlider) * incremento);
            for(var i = 0; i < enSlider; i++) {
                $container.append($fotos.eq(i).clone());
            }

            $(sig).click(function(e) {
                e.preventDefault();

                if(!estaMoviendo) {
                   if(primerElemento > cantidad-2) {
                        primerElemento = 3;
                        $container.css('left', '0px');
                    } else {
                        primerElemento++;
                    }
                    
                    estaMoviendo = true;
                    $container.animate({
                        left: '-=' + incremento,
                    }, 'swing', function(){
                        estaMoviendo = false;
                    });
                }
            });

            $(prev).click(function(e) {
                e.preventDefault();

                if(!estaMoviendo) {
                    if(primerElemento == 1) {
                        $container.css('left', cantidad * incremento * -1);
                        primerElemento = cantidad;
                    } else {
                        primerElemento--;
                    }
                    estaMoviendo = true;
                    $container.animate({
                        left: '+=' + incremento,
                    }, 'swing', function(){
                        estaMoviendo = false;
                    });
                }
            });

        });
    }
	

})(jQuery, window)