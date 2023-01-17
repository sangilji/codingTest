import sys
a= int(input())
for i in range(a) :
   b,c=map(int,input().split())
   print("Case #%d"%(i+1),": %d"%b," + %d"%c," = %d"%(b+c),sep="")