a=list(map(int,input().split()))
a[2]=a[2]-a[0]
a[3]=a[3]-a[1]
a.sort()
print(a[0])