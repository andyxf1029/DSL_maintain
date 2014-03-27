var Event = Backbone.Model.extend({
	urlRoot: "dsl/event",
        initialize: function(){
           
        },
        defaults:{ 
          "eventName":"Before Save",
          "eventType":"UI",
          "business_unit":"contract",
          "product":"CGL",
          "verison":"1"
        }
    });
	



var EventList = Backbone.Collection.extend({

  url: "http://localhost:8080/dsl/restful/eventList",

   model: Event,
  
 });


var EventView = Backbone.View.extend({

 	tagName:"tr",

    template: _.template($("#event-template").html()),

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },
  });


var EventListView = Backbone.View.extend({

  
	tagName: "tbody",
    

    render: function() {
      this.collection.each(function(e){
        var eventView = new EventView({model: e});
        this.$el.append(eventView.render().el);
      },this);

      return this;
    },



  });
