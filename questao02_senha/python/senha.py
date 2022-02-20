from tkinter import *
import tkinter

class Funcoes():
    def verificarSenha(self):
        self.senha = str(self.entradaSenha.get())
        contadorEspeciais = 0
        contadorCaracteres = 0
        contadorMinuscula = 0
        contadorMaiuscula = 0
        contadorDigito = 0
        contadorCriterios = 0
        contadorRelativo = 0
        faltaCaracteres = 0
        listaCaracteresEspeciais = ['!', '@', '#', '$', '%', '¨', '&', '*', '(', ')', '-', '+']
        listaPrintTela = []

        lista_senha = list(self.senha)
        contadorCaracteres = len(self.senha)

        for letra in listaCaracteresEspeciais:
            if letra in self.senha:
                contadorEspeciais = contadorEspeciais + 1
        for i in lista_senha:
            minuscula = i.islower()
            maiuscula = i.isupper()
            digito = i.isdigit()
            if minuscula == True: 
                contadorMinuscula = contadorMinuscula + 1
            elif maiuscula == True:
                contadorMaiuscula = contadorMaiuscula + 1
            elif digito == True:
                contadorDigito = contadorDigito + 1
      
        if contadorMinuscula == 0:
            listaPrintTela.append("1 letra minusculo")
            contadorCriterios = contadorCriterios + 1

        if contadorMaiuscula == 0:
            listaPrintTela.append("1 letra maisculo")
            contadorCriterios = contadorCriterios + 1

        if contadorEspeciais == 0: 
            listaPrintTela.append("1 caractere especial")
            contadorCriterios = contadorCriterios + 1

        if contadorDigito == 0: 
            listaPrintTela.append("1 digito")
            contadorCriterios = contadorCriterios + 1

        if contadorCriterios != 0 or contadorCaracteres < 6:
            self.labelSenhaFraca["text"] = "Senha fraca! Está faltando os seguintes critérios:"

        if contadorCriterios == 0 and contadorCaracteres >= 6:
            self.labelSenhaFraca["text"] = ""
            self.telaSecundaria()
        else:
            contadorRelativo = 6 - contadorCaracteres
            if contadorCriterios <= contadorRelativo:
                faltaCaracteres = contadorRelativo
            else:
                faltaCaracteres = contadorCriterios
            listaPrintTela.append("{} caracteres".format(faltaCaracteres))
        #Printa a lista sem os colchetes
        self.labelCriterio["text"] = ';\n'.join(listaPrintTela)

    def imprimirNaTelaSecundaria(self):
        imprimirNomeTelaSecundaria = str(self.entradaNome.get())
        imprimirSobrenomeTelaSecundaria = str(self.entradaSobrenome.get())
        imprimirEmailTelaSecundaria = str(self.entradaEmail.get())
        imprimirSenhaTelaSecundaria = str(self.entradaSenha.get())
        self.labelImprimirNomeESobrenome["text"] = "Nome: {} {}".format(imprimirNomeTelaSecundaria, 
        imprimirSobrenomeTelaSecundaria)
        self.labelImprimirEmail["text"] = "Email: {}".format(imprimirEmailTelaSecundaria)
        self.labelImprimirSenha["text"] = "Senha: {}".format(imprimirSenhaTelaSecundaria)
        
class Aplicativo(Funcoes):
    def __init__(self):
        self.telaPrincipal()
        
    def telaPrincipal(self):
        telaCadastro = Tk()
        telaCadastro.geometry("345x520+500+95")
        telaCadastro.title("Cadastro")
        telaCadastro.configure(background="#0070ad")
        #Proibe modificar o tamanho da janela.
        telaCadastro.resizable(width=False, height=False)
        self.telaCadastro = telaCadastro
        self.framesTelaPrincipal()
        self.widgetsTelaPrincipal()
        telaCadastro.mainloop()

    def telaSecundaria(self):
        telaDados = tkinter.Toplevel()
        telaDados.geometry("300x300+523+170")
        telaDados.title("Dados")
        telaDados.configure(background="#0070ad")
        telaDados.resizable(width=False, height=False)
        telaDados.grab_set()#Prioriza essa tela quando aberta.
        self.telaDados = telaDados
        self.widgetsTelaSecundaria()
        self.imprimirNaTelaSecundaria()
        #telaDados.mainloop()

    def framesTelaPrincipal(self):
        self.frameTitulo = Frame(self.telaCadastro, borderwidth=2, relief="sunken", bg="#242739")      
        self.frameTitulo.place(x=3 , y=4, width=339 , height= 95)

    def widgetsTelaPrincipal(self):
        #Criação das saidas
        Label(self.frameTitulo, text="Capgemini", font=("Arial", 16, "bold"), bg="#242739", 
        fg="#fff").place(x=113, y= 10)
        Label(self.frameTitulo, text="Crie sua nova conta\nÉ rápido e fácil.", bg="#242739", 
        fg="#fff").place(x=114, y= 50)
        Label(self.telaCadastro, text="Preencha os campos abaixo"
        " atendendo os seguintes prerequisitos", font=("Arial", 8), bg="#0070ad").place(x=10, y=99)
        Label(self.telaCadastro, text="*Senha deve conter no mínimo:", 
        font=("Arial", 8), bg="#0070ad").place(x=10, y=113)
        Label(self.telaCadastro, text="6 caracteres", font=("Arial", 8), bg="#0070ad").place(x=10, y=127)
        Label(self.telaCadastro, text="1 digito", font=("Arial", 8), bg="#0070ad").place(x=10, y=141)
        Label(self.telaCadastro, text="1 letra minúscula", font=("Arial", 8), bg="#0070ad").place(x=10, y=155)
        Label(self.telaCadastro, text="1 letra maiúscula", font=("Arial", 8), bg="#0070ad").place(x=10, y=169)
        Label(self.telaCadastro, text="1 caractere especial->'! @ # $ % ¨ & * ( ) - +'", 
        font=("Arial", 8), bg="#0070ad").place(x=10, y=183)
        Label(self.telaCadastro, text="Nome", font=("Arial", 10, "bold"), bg="#0070ad").place(x=10, y=215)
        Label(self.telaCadastro, text="Sobrenome", font=("Arial", 10, "bold"), bg="#0070ad").place(x=185, y=215)
        Label(self.telaCadastro, text="Email", font=("Arial", 10, "bold"), bg="#0070ad").place(x=10, y=271)
        Label(self.telaCadastro, text="Senha", font=("Arial", 10, "bold"), bg="#0070ad").place(x=10, y=328)
        #Label(self.telaCadastro, text="Confirmar senha", font=("Arial", 10, "bold")).place(x=186, y=328)
        #get
        self.labelSenhaFraca = Label(self.telaCadastro, text="", foreground="#cf1500", bg="#0070ad")
        self.labelSenhaFraca.place(x=45, y=420)
        self.labelCriterio = Label(self.telaCadastro, text="", foreground="#cf1500", bg="#0070ad" )
        self.labelCriterio.place(x=116, y=440)
        #Criação das entradas
        self.entradaNome = Entry(self.telaCadastro)
        self.entradaNome.place(x=13, y=238, width=140)
        self.entradaSobrenome = Entry(self.telaCadastro)
        self.entradaSobrenome.place(x=189, y=238, width=140)
        self.entradaEmail = Entry(self.telaCadastro)
        self.entradaEmail.place(x=13, y=295, width=240)
        self.entradaSenha = Entry(self.telaCadastro)
        self.entradaSenha.place(x=13, y=351 , width=140)
        #self.entradaConfirmarSenha = Entry(self.telaCadastro)
        #self.entradaConfirmarSenha.place(x=190, y=351 , width=140)
        #Criação dos botões
        self.botaoCadastrar = Button(self.telaCadastro, text="Cadastrar", command=self.verificarSenha)
        self.botaoCadastrar.place(x=142, y=390)
        self.entradaNome.focus() #Vai focar o curso na entrada nome.

    def widgetsTelaSecundaria(self):
        Label(self.telaDados, text="Parabéns, sua senha é considerada forte!", bg="#0070ad").place(x=13, y= 10)
        self.labelImprimirNomeESobrenome = Label(self.telaDados, text="", font=("Arial", 10, "bold"), 
        bg="#0070ad")
        self.labelImprimirNomeESobrenome.place(x=13, y= 40)
        self.labelImprimirEmail = Label(self.telaDados, text="", font=("Arial", 10, "bold"), bg="#0070ad")
        self.labelImprimirEmail.place(x=13, y= 70)
        self.labelImprimirSenha = Label(self.telaDados, text="", font=("Arial", 10, "bold"),
        foreground="#37ab98", bg="#0070ad")
        self.labelImprimirSenha.place(x=13, y= 100)

Aplicativo()
