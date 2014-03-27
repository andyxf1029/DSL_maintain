var Lable  = Backbone.Model.extend({
        urlRoot: "/lables",
        initialize: function(){
           
        },
 });


var LabelView = Backbone.View.extend({
  tagName:"a",

  className:"ui label",
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


var RuleLabelView = Backbone.View.extend({
  tagName:"div",

  className:"ui green label",
    template: _.template($('#event_label_template').html()),
   

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

   
 });


var GroupLabelView = Backbone.View.extend({
  tagName:"div",

  className:"ui blue label",
    template: _.template($('#event_label_template').html()),
   

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

   
 });



