import random

class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = self.right = None

def in_order_traversal(root, result):
    if root:
        in_order_traversal(root.left, result)
        result.append(root.key)
        in_order_traversal(root.right, result)

def create_random_tree(size):
    import random
    numbers = random.sample(range(0, 101), size)
    root = TreeNode(numbers[0])
    for num in numbers[1:]:
        insert(root, num)
    return root

def insert(root, key):
    if not root:
        return TreeNode(key)
    if key < root.key:
        root.left = insert(root.left, key)
    elif key > root.key:
        root.right = insert(root.right, key)
    return root

def rotate_right(grandparent, parent, child):
    if grandparent:
        grandparent.left = parent.right
    else:
        grandparent = parent.right

    parent.right = child
    return parent

def create_backbone(root):
    dummy = TreeNode(0)
    dummy.right = root
    current = dummy
    while current.right:
        if current.right.left:
            current = rotate_right(current, current.right, current.right.left)
        else:
            current = current.right
    return dummy.right

def create_balanced_tree(root, size):
    backbone_root = create_backbone(root)
    for _ in range(size - 1):
        backbone_root = rotate_right(None, backbone_root, backbone_root.right)
    return backbone_root

def main():
    
    tree_size = 100
    original_tree = create_random_tree(tree_size)

   
    for _ in range(20):
        insert(original_tree, random.randint(0, 100))

    
    balanced_tree = create_balanced_tree(original_tree, tree_size + 20)

    
    original_tree_in_order = []
    balanced_tree_in_order = []

    in_order_traversal(original_tree, original_tree_in_order)
    in_order_traversal(balanced_tree, balanced_tree_in_order)

    print("Árvore Original:", original_tree_in_order)
    print("Nova Árvore Balanceada:", balanced_tree_in_order)

if __name__ == "__main__":
    main()
