let arr = [2,5,10,18,20];

let odd = arr.filter(function(data) {
    return data % 2 != 0;
});

console.log(odd);

let even = arr.filter(function(data) {
    return data % 2 == 0;
});

console.log(even);