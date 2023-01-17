a= ["ABC","DEF,","GHI","JKL","MNO","PQRS","TUV","WXYZ"]
b= input()
count =0
for i in b :
    for list in a :
        for k in list :
            if k==i :
                count+=3 +a.index(list)
print(count) 