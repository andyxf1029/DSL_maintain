var AppView = Backbone.View.extend({

    el: $("#rule_maintian"),

    initialize: function() {
      $("#edit_rule_attr").hide();

    

      this.editor = CodeMirror.fromTextArea(document.getElementById("rule_content"), {
        lineNumbers: true,
        matchBrackets: true,
        mode: "text/x-groovy"
        });
    },

     events:{  
        'click #search_rule' : 'doSearch',
        'click #add_new_rule' :'addRule',
        'click #rule_edit' :   'editRule',
        'click #save_body' :'saveRuleBody',
        'click #add_rule_group' :   'addToRuleGroup',
        'click #rule_table>tbody>tr' : 'selectRow',
        'click #update_rule' :'updateRule',
        'click #rule_group_labels>a>i' :'deleteGroup',
        
    },

    saveRuleBody:function(){
      console.log("saveRuleBody");
    },



    initEvent:function(){
      alert(1);
    },

   
    deleteGroup: function(e){
      $(e.currentTarget).parent().remove();
    },

    updateRule: function(ruleList) {
      console.log("updateRule");

          $("#edit_rule_attr").hide();
          
    },

   
    render: function(ruleList) {

          var rulesView = new RulesView({collection:ruleList});
          this.$("#rule_table>tbody").remove();
          this.$("#rule_table").append(rulesView.render().el);
    },


    selectRow: function(e) {


      var rule_id = $(e.currentTarget).find("p").text()

      var selectedRule = this.rulesRecord.get(rule_id);


      var ruleContent  = new Rule({id:rule_id})
       

      $.when(ruleContent.fetch()).then(function(){
var zNodes2 =[
  { name:ruleContent.get("name"), open:true,
    children: [
    { name:"Save Policy",
    children: [
    { name:"Before save"},
    { name:"Finalize Quote"},
    ]},
        ]},];

$.fn.zTree.init($("#treeDemo2"), { }, zNodes2);

$("#edit_rule_attr").show();


//update description

    var rule_description = $("#rule_description")
    rule_description.empty()
    rule_description.append(ruleContent.get("description"))
          

        }
      )

   



      


    var rule_body = new RuleBody({id:rule_id});

    $.when(rule_body.fetch()).then(function(){

           var rule_content =  $("#rule_content")
          rule_content.empty();
          rule_content.append(rule_body.get("content"));

        }
      )

    this.rule_body=rule_body;
    },
   


    addToRuleGroup:function(){
    console.log("addToRuleGroup");

    var label_name =  $("#rule_group_label").val();

    var label = new Lable({name:label_name})

    var label_view = new LabelView({model:label});
    $("#rule_group_labels").append(label_view.render().el);


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



        this.editor.setValue(this.rule_body.get("content"))
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
      this.rulesRecord = ruleList;


      },
});



var app = new AppView();

    
var AppRouter = Backbone.Router.extend({
});

var router = new AppRouter;

Backbone.history.start();

