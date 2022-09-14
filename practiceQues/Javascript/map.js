let arr = [2,5,10,18,20];

let square = arr.map((data,index) => {
    return data*data;
});

let cube = arr.map(function(data,index) {
    return data*data*data;
});

console.log(arr);
console.log(square);
console.log(cube);