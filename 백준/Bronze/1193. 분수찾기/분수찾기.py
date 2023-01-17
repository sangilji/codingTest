a = int(input())
b=1
c=0
while 1 :
    if a>c :
        c+=b
        b+=1
    else :
        break
if b%2==1 :
    print(b-1-(c-a),end="/")
    print(1+(c-a))
else :
    print(1+(c-a),end="/")
    print(b-1-(c-a))
