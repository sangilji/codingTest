a=[-1 for i in range(26)]

b=list(map(str,input()))
c=0
for i in b :
    if a[ord(i)-ord("a")]==-1 :
        a[ord(i)-ord("a")] =c
    c+=1
for i in a :
    print(i,end=" ")
