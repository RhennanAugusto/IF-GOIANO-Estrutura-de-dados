import time

class Node:
    def __init__(self, key):
        self.key = key
        self.height = 1
        self.left = None
        self.right = None

def height(node):
    if node is None:
        return 0
    return node.height

def update_height(node):
    if node is not None:
        node.height = 1 + max(height(node.left), height(node.right))

def balance_factor(node):
    if node is None:
        return 0
    return height(node.left) - height(node.right)

def rotate_right(y):
    x = y.left
    T2 = x.right

    x.right = y
    y.left = T2

    update_height(y)
    update_height(x)

    return x

def rotate_left(x):
    y = x.right
    T2 = y.left

    y.left = x
    x.right = T2

    update_height(x)
    update_height(y)

    return y

def insert(root, key):
    if root is None:
        return Node(key)

    if key < root.key:
        root.left = insert(root.left, key)
    else:
        root.right = insert(root.right, key)

    update_height(root)

    balance = balance_factor(root)

    if balance > 1:
        if key < root.left.key:
            return rotate_right(root)
        else:
            root.left = rotate_left(root.left)
            return rotate_right(root)
    if balance < -1:
        if key > root.right.key:
            return rotate_left(root)
        else:
            root.right = rotate_right(root.right)
            return rotate_left(root)

    return root

def inorder_traversal(root):
    result = []
    if root:
        result.extend(inorder_traversal(root.left))
        result.append(root.key)
        result.extend(inorder_traversal(root.right))
    return result

if __name__ == "__main__":
    file_path = r"c:\Users\rhenn\Downloads\dados100_mil.txt"
    with open(file_path, "r") as file:
        data = [(line.strip()) for line in file]

    start_time = time.time()

    root = None
    for item in data:
        root = insert(root, item)

    sorted_data = inorder_traversal(root)
    print("Dados ordenados:", sorted_data)

    end_time = time.time()

    total_time = end_time - start_time
    print(f"Tempo total do programa: {total_time:.6f} segundos")
