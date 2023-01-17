a=[]
b=[]
for i in range(10) :
    a.append(int(input()))
b.append(a[0]%42)
for i in range(1,10) :
    for j in range(len(b)) :
        if(a[i]%42==b[j]) :
            break
        else :
            if j ==len(b)-1 :
                b.append(a[i]%42)
            
print(len(b))
    

