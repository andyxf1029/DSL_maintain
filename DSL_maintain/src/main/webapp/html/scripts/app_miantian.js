


$(function(){





var setting = { };


//build Event Tree
var zNodes =[
{ name:"Before Save", open:true,
children: [
{ name:"save validation",
children: [
{ name:"check Location premium"},
{ name:"cehck Coverage GCL"},

]},


]},


];

//Build rule tree 




  $.fn.zTree.init($("#treeDemo"), setting, zNodes);
  



var Lable  = Backbone.Model.extend({
        urlRoot: "/lables",
        initialize: function(){
           
        },
        defaults:{ 
          "name":""
        }
    });


var LabelView = Backbone.View.extend({

  tagName:"div",

  className:"ui blue labels",

 // Cache the template function for a single item.
    template: _.template($('#label-template').html()),
 events:{  //就是在这里绑定的
       
        'click .icon.close'  :'deleteLabel'

    },

    // Re-render the titles of the todo item.
    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },

    deleteLabel:function(){
        this.model.set("status","delete");
    }


    


  });




var Rule  = Backbone.Model.extend({
        urlRoot: "dsl/rule",
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
          "description":""
        }
    });


 var RuleList = Backbone.Collection.extend({

  url: "http://localhost:8080/dsl/restful/rulelist",

   // Reference to this collection's model.
   model: Rule,

  

  
 });





var RuleView = Backbone.View.extend({

  tagName:"tr",

 // Cache the template function for a single item.
    template: _.template($('#rule-template').html()),


    // Re-render the titles of the todo item.
    render: function() {
      this.$el.html(this.template(this.model.toJSON()));
      return this ;
    },


  });


var RulesView = Backbone.View.extend({

  
tagName: "tbody",
    

  

    // Re-render the titles of the todo item.
    render: function() {
      this.collection.each(function(rule){
        var ruleView = new RuleView({model: rule});
        this.$el.append(ruleView.render().el);
      },this);

      return this;
    },



  });




var AppView = Backbone.View.extend({

    el: $("#rule_maintian"),


    

    // At initialization we bind to the relevant events on the `Todos`
    // collection, when items are added or changed. Kick things off by
    // loading any preexisting todos that might be saved in *localStorage*.
    initialize: function() {
       
        
    },

     events:{  //就是在这里绑定的
        'click #search_rule' : 'doSearch',
        'click #add_new_rule' :'addRule',
        'click #rule_edit' :   'editRule',
        'click #add_rule_group' :   'addToRuleGroup',
        'click #rule_table>tbody>tr' : 'selectRow'
        

    },

    // Re-rendering the App just means refreshing the statistics -- the rest
    // of the app doesn't change.
    render: function(ruleList) {

          var rulesView = new RulesView({collection:ruleList});
          this.$("#rule_table>tbody").remove();
          this.$("#rule_table").append(rulesView.render().el);
    },


  selectRow: function(e) {

          console.log($(e.currentTarget).first());
    },
   


    addToRuleGroup:function(){
    console.log("addToRuleGroup");

    var label_name =  $("#rule_group_label").val();

    var label = new Lable({name:label_name})

    var label_view = new LabelView({model:label});
    $("#lables_space").append(label_view.render().el);


    },

   

    addRule:function(){
        console.log("go to addRule");

        router.navigate("#new_rule");
          
    },

    editRule:function(){
      console.log("go to edit");
       $('#edit_rule_body')
        .modal('show')
        ; 


        console.log(!this.editor)

        if(!this.editor){

        var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
        lineNumbers: true,
        matchBrackets: true,
        mode: "text/x-groovy"
        });
          this.editor = editor
        }
      

      
    },

    doSearch: function() {
        console.log("go to search")
        var ruleList = new RuleList;

        $.when(ruleList.fetch({data:{name:"test"}})).then(function(){
          var rulesView = new RulesView({collection:ruleList});
          $("#rule_table>tbody").remove();
          $("#rule_table").append(rulesView.render().el);
        })
















var zNodes2 =[
{ name:"Check premium", open:true,
children: [
{ name:"Save Policy",
children: [
{ name:"Before save"},
{ name:"Finalize Quote"},
]},
]},

{ name:"Check Limit", open:true,
children: [
{ name:"Save Coverage",
children: [
{ name:"Before save"},
{ name:"Finalize Quote"},
]},
]}

];



$.fn.zTree.init($("#treeDemo2"), setting, zNodes2);

    },


  });









var app = new AppView;

    


var AppRouter = Backbone.Router.extend({

   

});

var router = new AppRouter;


Backbone.history.start();

});