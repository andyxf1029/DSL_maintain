var Lable  = Backbone.Model.extend({
        urlRoot: "/lables",
        initialize: function(){
           
        },
 });


var LabelView = Backbone.View.extend({
  tagName:"div",

  className:"ui blue labels",
    template: _.template($('#label-template').html()),
 events:{ 
       
        'click .icon.close'  :'deleteLabel'

    },

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

    deleteLabel:function(){
        this.model.set("status","delete");
    }
 });