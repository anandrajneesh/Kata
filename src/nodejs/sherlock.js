function processData(input) {
console.log(input)

}

function processArray(nums){

    if(nums.length)

}


var readline = require('readline');
process.stdin.setEncoding('utf-8');
var _input="";
var rl = readline.createInterface({input: process.stdin, output: process.stdout});
rl.setPrompt('> ');
rl.prompt();
rl.on('line' ,function(aText) {
  _input +=aText;
  rl.prompt();
 });
rl.on('close',function()      {  processData(_input) });