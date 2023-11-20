import random

class Node:
    def __init__(self, key):
        self.key = key
        self.left = self.right = None

def create_tree(n):
    # Cria uma árvore binária com n números aleatórios de 0 a 100
    numbers = random.sample(range(101), n)
    root = Node(numbers[0])
    for num in numbers[1:]:
        insert(root, num)
    return root

def insert(root, key):
    # Insere um novo nó na árvore
    if root is None:
        return Node(key)
    else:
        if key < root.key:
            root.left = insert(root.left, key)
        else:
            root.right = insert(root.right, key)
    return root

def dsw_balance(root):
    # Implementação do Algoritmo DSW para balancear a árvore
    nodes = []
    in_order_traversal(root, nodes)
    root = create_backbone(nodes)
    root = create_balanced_tree(root, len(nodes))
    return root

def in_order_traversal(root, nodes):
    # Percurso em ordem para preencher a lista de nós
    if root:
        in_order_traversal(root.left, nodes)
        nodes.append(root)
        in_order_traversal(root.right, nodes)

def create_backbone(nodes):
    # Cria a espinha dorsal (linear) da árvore
    root = Node(0)
    current = root
    for node in nodes:
        current.right = node
        current = node
    return root.right

def create_balanced_tree(root, size):
    # Transforma a espinha dorsal em uma árvore balanceada
    m = 2 ** (size.bit_length() - 1) - 1
    make_rotations(root, size - m)
    while m > 1:
        m //= 2
        make_rotations(root, m)
    return root

def make_rotations(root, bound):
    # Realiza rotações para balancear a árvore
    parent = dummy = Node(0)
    dummy.right = root
    for _ in range(bound):
        child = parent.right
        if child and child.right:
            parent.right = child.right
            child.right = parent.right.left
            parent.right.left = child
            parent = parent.right.left

# Usar as funções
random.seed(42)  # Para reprodutibilidade
initial_tree = create_tree(100)

for _ in range(20):
    insert(initial_tree, random.randint(0, 100))

balanced_tree = dsw_balance(initial_tree)
