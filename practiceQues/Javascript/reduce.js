let arr = [2,5,10,18,20];

var sum = arr.reduce( function(total, amount){
  return total + amount
});

console.log(sum);