while 1 :
    a=list(map(int,input().split()))
    if a.count(0)==3 :
        break
    a.sort()
    if a[0]*a[0] +a[1]*a[1] ==a[2]*a[2] :
        print("right")
    else :
        print("wrong")

