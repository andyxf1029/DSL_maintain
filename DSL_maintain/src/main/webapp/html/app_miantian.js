var AppView = Backbone.View.extend({

    el: $("#rule_maintian"),

    initialize: function() {

      $("#edit_rule_attr").hide();
       
        
    },

     events:{  
        'click #search_rule' : 'doSearch',
        'click #add_new_rule' :'addRule',
        'click #rule_edit' :   'editRule',
        'click #add_rule_group' :   'addToRuleGroup',
        'click #rule_table>tbody>tr' : 'selectRow'
        

    },

   
    render: function(ruleList) {

          var rulesView = new RulesView({collection:ruleList});
          this.$("#rule_table>tbody").remove();
          this.$("#rule_table").append(rulesView.render().el);
    },


    selectRow: function(e) {


      var rule_id = $(e.currentTarget).find("p").text()
    
           var zNodes2 =[
{ name:"Check premium", open:true,
children: [
{ name:"Save Policy",
children: [
{ name:"Before save"},
{ name:"Finalize Quote"},
]},
]},

];

$.fn.zTree.init($("#treeDemo2"), { }, zNodes2);

$("#edit_rule_attr").show();


//update description


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
       var input =  $("#rule-search").val();
        $.when(ruleList.fetch({data:{name:input}})).then(function(){
          var rulesView = new RulesView({collection:ruleList});
          $("#rule_table>tbody").remove();
          $("#rule_table").append(rulesView.render().el);
        })



  },
});



var app = new AppView;

    
var AppRouter = Backbone.Router.extend({
});

var router = new AppRouter;

Backbone.history.start();

