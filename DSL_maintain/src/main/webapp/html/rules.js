var Rule  = Backbone.Model.extend({
        urlRoot: "restful/rule",
        initialize: function(){
           
        },
        defaults:{ 
          "name":"",
          "ruleType":"UI",
          "ruleGroup":"common",
          "business_unit":"contract",
          "product":"CGL",
          "verison":"1",
          "status":"approved",
          "description":"description"
        }
    });


 var RuleList = Backbone.Collection.extend({

  url: "restful/rule/list",

   model: Rule,
  
 });


 var RuleBody = Backbone.Model.extend({
    urlRoot: "restful/rule/body",




 });





var RuleView = Backbone.View.extend({

  tagName:"tr",

    template: _.template($('#rule-template').html()),


    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },


  });


var RulesView = Backbone.View.extend({

  
    tagName: "tbody",
    

    render: function() {
      this.collection.each(function(rule){
        var ruleView = new RuleView({model: rule});
        this.$el.append(ruleView.render().el);
      },this);

      return this;
    },



  });


var RuleUpdateView =  Backbone.View.extend({

      template: _.template($('#rule-form-template').html()),


       events:{  
        'click #update_rule' : 'updateRule',
    },


      render: function() {
      Backbone.ModelBinding.bind(this);  
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

      updateRule :function(){
        console.log(this.model)


    },



});