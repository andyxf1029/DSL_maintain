

//Build rule tree 

var SoureLabelView = Backbone.View.extend({
	el: $("#event_label"),





});





var EventMaintainView = Backbone.View.extend({
	el: $("#event_maintain"),

    initialize: function() {

    	
    	this.search_type = $('#search_type')

    	this.search_rule_name =  $("#search_rule_name")

    	this.source_label = $('#source_label');

    },

     events:{  
        'click #search_event' : 'searchEvent',
        'click #event_table>tbody>tr' : 'selectRow',
        'click #search_ruleOrGroup' :'searchRuleOrGroup',
        'click #AddEvent' : 'addEvent'


       
    },

    addEvent:function(){





    	if(!this.currentEvent){
    		console.log("currentEvent don't exist")
    	}else{

    		

    	}







    },


    searchRuleOrGroup:function(){
    	


    	var type_value = this.search_type.dropdown('get value');
    	
		var input = this.search_rule_name.val();
		this.source_label.empty();
    	if(type_value==1){
		var ruleList = new RuleList;
        $.when(ruleList.fetch({data:{name:input}})).then(function(){
          	ruleList.each(function(rule){
          		var rule_label = new RuleLabelView({model:rule});
          		$('#source_label').append(rule_label.render().el)
          	})

     		$(".container").shapeshift();
        })

    	}


    	if(type_value==2){
    		var groupList = new RuleGroupList;

			$.when(groupList.fetch({data:{name:input}})).then(function(){
          	groupList.each(function(rule){
          		var group_label = new GroupLabelView({model:rule});
          		$('#source_label').append(group_label.render().el)
          	})

     		$(".container").shapeshift();
        })	
    	}


 		


    	
    	//show assign session 

    	



    	//build source 




    	//build target 




    	
    },


    selectRow:function(e){
    		 var event_id = $(e.currentTarget).find("p").text()
			 var event = this.eventsRecord.get(event_id);
				// update tree 
		var setting = { };
		console.log(event.get("name"))

//build Event Tree
			var zNodes =[
		{ name:event.get("name"), open:true,
		children: [
		{ name:"save validation",
		children: [
		{ name:"check Location premium"},
		{ name:"cehck Coverage GCL"},
		]},
		]},
		];

			$.fn.zTree.init($("#treeDemo"), setting, zNodes);	

				// update description  
		this.currentEvent = event



    },


    searchEvent:function(){ 
    var  eventsList = new EventList;


	$.when(eventsList.fetch({data:{name:"input"}})).then(function(){
         var eventsView = new EventListView({collection:eventsList});
         $("#event_table>tbody").remove();
          $("#event_table").append(eventsView.render().el);
        })

	this.eventsRecord = eventsList
    },

     
});


var eventMaintainView = new EventMaintainView;

  
