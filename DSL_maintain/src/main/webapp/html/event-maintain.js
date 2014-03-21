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
  
