import sys
city= int(input())
load_len=list(map(int,sys.stdin.readline().split()))
gas_price=list(map(int,sys.stdin.readline().split()))
price =0
a=0
b=gas_price[a]
while a<city-1 :
    price+=b*load_len[a]
    a+=1
    if b> gas_price[a] :
        b= gas_price[a]
  
print(price)

