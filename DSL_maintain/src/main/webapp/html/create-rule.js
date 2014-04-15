var CreateRuleView = Backbone.View.extend({
	el: $("#rule"),

    initialize: function() {

        $('#fileupload').fileupload({
        dataType: 'json',
        add: function (e, data) {

			$('#create_rule')
                .click(function () {
                	



                	data.formData={id:"test"}
                    data.submit();
                });
        },
    }); 
    },

     events:{  
        'change .ui.dropdown' : 'changeField',
        

       
    },





    changeField: function(e){
    	console.log("testr")

    }

    
})

var createRuleView = new CreateRuleView;


