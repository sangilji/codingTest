a=int(input())
for i in range(a) :
    b,c=input().split()
    for j in c :
        for k in range(int(b)) :
            print(j,end="")
    print()