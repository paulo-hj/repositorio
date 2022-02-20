import sys

print("{}\nPor favor, leia a instruções abaixo:\n*Digite somente números inteiros.\n"
"*Para fechar o programa digite 'sair' ou 's'.\n{}\n".format(("#" * 50), ("#" * 50)))

while True:
    lista_space = []
    lista_asterisco = []
    linha = 0
    try:
        degraus = input("Digite a quantidade de degraus que sua escada vai ter: ")
        sair = str(degraus).upper()
        if sair == "SAIR" or sair == "S":
            print("\nSaindo...\n")
            break
        else:
            degraus = int(degraus)
            while linha <= degraus:
                lista_space.append(" ")
                linha = linha + 1
            while degraus > 0:
                lista_asterisco.append("*")
                lista_space.pop(0)
                degraus = degraus - 1
                lista =  lista_space + lista_asterisco
                #lista2.reverse()
                for j in lista:   
                    sys.stdout.write(j)
                print()
    except:
        print("Digite somente números inteiros!")
