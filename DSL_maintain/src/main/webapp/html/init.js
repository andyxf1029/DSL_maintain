menu = {};

// ready event
menu.ready = function() {

  // selector cache
  var
    $menuItem = $('.menu a.item, .menu .link.item'),
    $dropdown = $('.main.container .menu .dropdown'),
    // alias
    handler = {

      activate: function() {
        if(!$(this).hasClass('dropdown')) {
          $(this)
            .addClass('active')
            .closest('.ui.menu')
            .find('.item')
              .not($(this))
              .removeClass('active')
          ;
        }
      }

    }
  ;

  $dropdown
    .dropdown({
      on: 'hover'
    })
  ;

  $menuItem
    .on('click', handler.activate)
  ;
   $('#sidebar').first()
  .sidebar('attach events', '#menu-button')
	;


  $('.filter.menu .item')
      .tab();
  $('.ui.dropdown')
      .dropdown();

};

$(document).ready(menu.ready)


