const fs = require('fs');
const numbers = fs.readFileSync('dev/stdin').toString().split(' ').map(Number);

const a = numbers[0];
const b = numbers[1];
const c = numbers[2];

if (a==b && b==c) {
    console.log(10000+(a*1000));
} else if ((a==b && a!=c) || (a==c && a!=b)){
    console.log(1000+(a*100))
} else if ((b==a && b!= c) || (b==c && b!=a)){
    console.log(1000+(b*100))
} else {
    let max = a;
    if (max < b && c < b) {
        max = b;
        console.log(100*b);
    } else if (max < c && b < c) {
        max = c;
        console.log(100*c);
    } else  {
        console.log(max*100);
    }
}