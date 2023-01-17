a= int(input())
count =0
for i in range(a) :
    c=[0 for j in range(26)]
    b=input()
    for i in range(len(b)) :
        if(c[ord(b[i])-ord("a")]==0) :

            c[ord(b[i])-ord("a")]=1

        else :
            if b[i]==b[i-1] :
                continue
            else :
                c[ord(b[i])-ord("a")]=-1
    b=1
    for i in c :
        if i==-1 :
            b-=1
            break   
    count+=b
print(count)    
