var _ = require('lodash');

var obj = { 'filter.where.id.gt': '1000',
  'filter[where][price][between].[0]': '10',
  'filter[where].[price].[between][3]': '7' }

var output = {};
_.keys(obj).forEach(function(key) {
console.log(key);
    _.set(output, key, obj[key]);
});


console.log(JSON.stringify(output));