import sys
a= int(input())
for i in range(a) :
    for k in range(a-i-1) :
        print(" ",end="")
    for j in range(i+1) :
        print("*",end="")
    
    print()