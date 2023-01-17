a=int(input())
b=int(input())
c=int(input())
d=list(str(a*b*c))
e=[]
for i in range(10) :
   e.append(int(0)) 
for i in range(len(d)) :
    e[int(d[i])]+=1
for i in range(10) :
    print(e[i])



