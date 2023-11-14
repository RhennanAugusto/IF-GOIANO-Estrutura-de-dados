class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key


def insert(root, key):
    if root is None:
        return Node(key)
    else:
        if root.val < key:
            root.right = insert(root.right, key)
        else:
            root.left = insert(root.left, key)
    return root


def preorder_traversal(root):
    if root:
        print(root.val, end=' ')
        preorder_traversal(root.left)
        preorder_traversal(root.right)


def inorder_traversal(root):
    if root:
        inorder_traversal(root.left)
        print(root.val, end=' ')
        inorder_traversal(root.right)


def postorder_traversal(root):
    if root:
        postorder_traversal(root.left)
        postorder_traversal(root.right)
        print(root.val, end=' ')


def level_order_traversal(root):
    if not root:
        return

    queue = [root]
    while queue:
        current = queue.pop(0)
        print(current.val, end=' ')

        if current.left:
            queue.append(current.left)
        if current.right:
            queue.append(current.right)



def remove_elements(root, n):
    for _ in range(n):
       
        root = remove_root(root)
    return root


def remove_root(root):
    if root is None:
        return None
    elif root.left is None:
        return root.right
    elif root.right is None:
        return root.left
    else:
        
        successor = find_min_value(root.right)
        root.val = successor.val
        root.right = remove_root(root.right)
    return root


def find_min_value(node):
    current = node
    while current.left is not None:
        current = current.left
    return current



root = None


import random

numbers = random.sample(range(101), 20)
for number in numbers:
    root = insert(root, number)

print("Árvore original:")
print("Pre-ordem:", end=' ')
preorder_traversal(root)
print("\nIn-ordem:", end=' ')
inorder_traversal(root)
print("\nPós-ordem:", end=' ')
postorder_traversal(root)
print("\nEm nível:", end=' ')
level_order_traversal(root)

root = remove_elements(root, 5)
print("\n\nÁrvore após remoção de 5 elementos:")
print("Pre-ordem:", end=' ')
preorder_traversal(root)
print("\nIn-ordem:", end=' ')
inorder_traversal(root)
print("\nPós-ordem:", end=' ')
postorder_traversal(root)
print("\nEm nível:", end=' ')
level_order_traversal(root)
