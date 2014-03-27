var ruleGroup  = Backbone.Model.extend({
        urlRoot: "/restful/event/group",
        initialize: function(){
           
        },
 });


var RuleGroupList = Backbone.Collection.extend({

  url: "restful/ruleGourps",

   model: ruleGroup,
  
 });





