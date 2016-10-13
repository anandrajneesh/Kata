function processData(input) {
console.log(input)
    countWithSetTimeout(input);
}

function countWithSetTimeout(times) {
    for (var i = 0; i < times; i++) {

        (function(a){

       setTimeout(function() {
         console.log(a);
       }, a * 10 );
        })(i)
     }
}

var readline = require('readline');
process.stdin.setEncoding('utf-8');
var _input="";
var rl = readline.createInterface({input: process.stdin, output: process.stdout});
rl.setPrompt('> ');
rl.prompt();
rl.on('line' ,function(aText) {
 console.log('echo: "%s"',aText);
  _input +=aText;
  rl.prompt();
 });
rl.on('close',function()      { console.log('input has closed'); processData(_input) });