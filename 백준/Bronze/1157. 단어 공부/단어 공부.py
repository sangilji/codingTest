a=input()
b=[0 for i in range(26)]
for i in a :
    if ord(i)>=ord("a") :
        b[ord(i)-ord("a")]+=1
    else :
        b[ord(i)-ord("A")]+=1
c=b[0]
n=0
for i in range(1,26) :
    if(c<b[i]) :
        c=b[i]
        n=i
b.sort()

if b[-1]==b[-2] :
    print("?")
else :
    print(chr(ord("A") + n))