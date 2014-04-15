var Lable  = Backbone.Model.extend({
        urlRoot: "/lables",
        initialize: function(){
           
        },
 });


var LabelView = Backbone.View.extend({
  tagName:"a",

  className:"argolable",
    template: _.template($('#label-template').html()),
    

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

    
 });


var RuleLabelView = Backbone.View.extend({
  tagName:"div",

  className:"argolable",
    template: _.template($('#rule_label_template').html()),
   

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

   
 });


var GroupLabelView = Backbone.View.extend({
  tagName:"div",

  className:"argolable",
    template: _.template($('#group_label_template').html()),
   

    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

   
 });



