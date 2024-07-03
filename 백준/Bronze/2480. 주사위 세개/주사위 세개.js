const fs = require('fs');

const numbers = fs.readFileSync('/dev/stdin').toString().split(' ').map(Number);
// const numbers = fs.readFileSync('input.txt').toString().split(' ').map(Number);

const a = numbers[0];
const b = numbers[1];
const c = numbers[2];

if(a==b && b==c){
    console.log(10000+a*1000);
}else if(a==b){
    console.log(1000+a*100);
}
else if(a==c){
    console.log(1000+a*100);
    
}
else if(b==c){
    console.log(1000+b*100);
    
}else{
    let result = Math.max(a,b,c);
    console.log(result*100);
}