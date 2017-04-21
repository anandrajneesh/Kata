'use strict'
const filters = ['hat','shirt','pant'];
const products = [{
                 	sku: 101,
                 	type: 'hat'
                 }, {
                 	sku: 102,
                 	type: 'hat'
                 }, {
                 	sku: 103,
                 	type: 'shirt'
                 }, {
                 	sku: 104,
                 	type: 'pant'
                 }, {
                 	sku: 101,
                 	type: 'pant'
                 }, {
                 	sku: 101,
                 	type: 'shirt'
                 }]


const filterize = function (products, filters){
    let map = {};
    filters.forEach(function(filter){
        map[filter] = [];
    })
    products.forEach(function(product){
        if(typeof map[product.type] !== undefined){
            map[product.type].push(product);
        }
    })
    return map;
}


console.log(filterize(products, filters));