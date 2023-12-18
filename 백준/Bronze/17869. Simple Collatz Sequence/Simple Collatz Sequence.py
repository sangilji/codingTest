N=int(input()) 

count=0

while N!=1: 
    if N%2==0: 
        N=N//2 
    else: 
        N=N+1 
    count+=1 
    
print(count)