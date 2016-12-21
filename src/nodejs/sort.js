var obj = [
 {
  title: 'one',
  popularity: 4,
  novelty: 3
 },
 {
  title: 'two',
  popularity: 1,
  novelty: 4
 },
 {
  title: 'three',
  popularity: 5,
  novelty: 3,
  roulette: 0
 },
 {
  title: 'four',
  popularity: 5,
  novelty: 3,
  roulette: 1
 }
];

obj.sort(function(a, b) {
    var rouletteDiff = compare(a.roulette, b.roulette);
    if(rouletteDiff != 0) return rouletteDiff;
    var noveltyDiff = compare(a.novelty, b.novelty);
    if(noveltyDiff != 0) return noveltyDiff;
    return compare(a.popularity, b.popularity);
  });

  function compare(x,y){
    if(x == undefined) return 1;
    if(y == undefined) return -1;
    if(x === y){
        return 0;
    }else{
        return x > y ? -1 : 1
    }
  }


  console.log('abc'-'def')