def s(b :int, st :list)-> list :
    l = []
    if b==3 :
        return st
    else :
        for i in st:
            l.append(i*3)
        for i in st:
            l.append(i+' '*len(st)+i)
        for i in st:
            l.append(i*3)
        return s(b//3,l)

    
a=int(input())
star = ["***","* *","***"]
star = s(a,star)
for i in star :
    print(i)
