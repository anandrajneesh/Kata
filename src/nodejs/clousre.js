'use strict'
const preProcess = function(a){
    return function(fn){
        return fn(a+10)
    }
}

const multiplier = function(a){
    return a*10
}

const num = 1

console.log(multiplier(num))

console.log(preProcess(num)(multiplier))
