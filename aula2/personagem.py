class Personagem:
    def __init__(self, nome, vida, forca):
        self.nome = nome
        self.vida = vida
        self.forca = forca

    def receberDano(self, dano):
        self.vida -= dano

        if self.vida < 0:
            self.vida = 0

    def estaVivo(self):
        return self.vida > 0

    def ficha(self):
        print("Nome:", self.nome)
        print("Vida:", self.vida)
        print("Força:", self.forca)
        print()

    def atacar(self, alvo):
        alvo.receberDano(self.forca)
        print(
            self.nome,
            "atacou",
            alvo.nome,
            "causando",
            self.forca,
            "de dano!"
        )


if __name__ == '__main__':
    heroi = Personagem("Batman", 100, 20)
    chefe = Personagem("Coringa", 150, 25)


    heroi.ficha()
    chefe.ficha()


    while heroi.estaVivo() and chefe.estaVivo():
        heroi.atacar(chefe)

        if chefe.estaVivo():
            chefe.atacar(heroi)

        print()

    heroi.ficha()
    chefe.ficha()

    if heroi.estaVivo():
        print("O Batman venceu!")
    else:
        print("O Coringa venceu!")
