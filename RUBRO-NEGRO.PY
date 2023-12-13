import random

class No:
    def __init__(self, key, color):
        self.key = key
        self.color = color
        self.left = None
        self.right = None

class ArvoreRubroNegra:
    def __init__(self):
        self.root = None

    def inserir(self, key):
        novo_no = No(key, "vermelho")
        self.inserir_rec(self.root, novo_no)

    def inserir_rec(self, no, novo_no):
        if no is None:
            self.root = novo_no
            return

        if novo_no.key < no.key:
            if no.left is None:
                no.left = novo_no
            else:
                self.inserir_rec(no.left, novo_no)

        else:
            if no.right is None:
                no.right = novo_no
            else:
                self.inserir_rec(no.right, novo_no)

        self.manter_propriedades_rb(novo_no)

    def remover(self, key):
        no_removido = self.remover_rec(self.root, key)
        if no_removido is not None:
            del no_removido

    def remover_rec(self, no, key):
        if no is None:
            return None

        if key < no.key:
            return self.remover_rec(no.left, key)

        elif key > no.key:
            return self.remover_rec(no.right, key)

        else:
            if no.left is None:
                return no.right

            elif no.right is None:
                return no.left

            else:
                sucessor = self.sucessor(no)
                no.key = sucessor.key
                self.remover(sucessor.key)
                return no

    def sucessor(self, no):
        if no.right is not None:
            return self.menor_elemento(no.right)

        else:
            no = no.parent
            while no is not None and no.right is no:
                no = no.parent

            return no

    def menor_elemento(self, no):
        while no.left is not None:
            no = no.left

        return no

    def contar_ocorrencias(self, key):
        no = self.buscar(key)

        if no is None:
            return 0

        else:
            return self.contador_ocorrencias_rec(no, 0)

    def contador_ocorrencias_rec(self, no, contador):
        if no is None:
            return contador

        if no.key == key:
            return contador + 1

        return self.contador_ocorrencias_rec(no.left, contador) + self.contador_ocorrencias_rec(no.right, contador)

    def imprimir(self):
        if self.root is None:
            print("A árvore está vazia.")
            return

        self.imprimir_rec(self.root)

    def imprimir_rec(self, no):
        if no is None:
            return

        print(f"{no.key} {no.color}")
        self.imprimir_rec(no.left)
        self.imprimir_rec(no.right)


def main():
    arquivo = open(r"C:\Users\Rhenn\Downloads\dados100_mil.txt")

    dados = []
    for linha in arquivo:
        dados.append((linha))

    arvore = ArvoreRubroNegra()

    for dado in dados:
        arvore.inserir(dado)

    for _ in range(50000):
        numero = random.randint(-9999, 9999)

        if numero % 3 == 0:
            arvore.inserir(numero)

        elif numero % 5 == 0:
            arvore.remover(numero)

        else:
            ocorrencias = arvore.contar_ocorrencias(numero)
            print(f"O número {numero} aparece {ocorrencias} vezes na árvore.")

    print("Dados da árvore:")
    arvore.imprimir()


if __name__ == "__main__":
    main()