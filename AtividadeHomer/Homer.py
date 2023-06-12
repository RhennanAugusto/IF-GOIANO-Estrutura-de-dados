class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def add_to_end(self, data):
        new_node = Node(data)
        if self.tail is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node

    def add_to_start(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node

    def add_at_position(self, data, position):
        if position < 0:
            print("Position cannot be negative.")
            return
        elif position == 0:
            self.add_to_start(data)
        else:
            new_node = Node(data)
            current = self.head
            count = 0
            while current.next is not None and count < position - 1:
                current = current.next
                count += 1
            if current.next is None:
                self.add_to_end(data)
            else:
                new_node.prev = current
                new_node.next = current.next
                current.next.prev = new_node
                current.next = new_node

    def remove_from_end(self):
        if self.tail is None:
            print("List is empty.")
        elif self.head == self.tail:
            self.head = None
            self.tail = None
        else:
            self.tail = self.tail.prev
            self.tail.next = None

    def remove_at_position(self, position):
        if position < 0:
            print("Position cannot be negative.")
            return
        elif position == 0:
            self.remove_from_start()
        else:
            current = self.head
            count = 0
            while current is not None and count < position:
                current = current.next
                count += 1
            if current is None:
                print("Position is out of range.")
            elif current == self.tail:
                self.remove_from_end()
            else:
                current.prev.next = current.next
                current.next.prev = current.prev

    def remove_from_start(self):
        if self.head is None:
            print("List is empty.")
        elif self.head == self.tail:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.next
            self.head.prev = None

    def is_in_list(self, data):
        current = self.head
        while current is not None:
            if current.data == data:
                return True
            current = current.next
        return False

    def print_list(self):
        current = self.head
        while current is not None:
            print(current.data)
            current = current.next

    def get_size(self):
        count = 0
        current = self.head
        while current is not None:
            count += 1
            current = current.next
        return count


my_list = DoublyLinkedList()

my_list.add_to_end("Homer")
my_list.add_to_end("Marge")
my_list.print_list()
print()


my_list = DoublyLinkedList()
my_list.print_list()
print()


my_list.add_to_end("Homer")
my_list.add_at_position("Bart", 0)
my_list.add_at_position("Moll", 1)
my_list.print_list()
print()


my_list = DoublyLinkedList()
my_list.print_list()
print()

my_list.add_to_end("Homer")
my_list.add_to_end("Bart")
my_list.add_to_start("Lisa")
my_list.print_list()
print("Size:", my_list.get_size())
print()


my_list = DoublyLinkedList()
my_list.print_list()
print()


my_list.add_to_end("Homer")
my_list.add_to_end("Maggie")
my_list.add_at_position("Bart", 0)
my_list.add_at_position("Marge", 1)
my_list.print_list()
print("Lisa in list:", my_list.is_in_list("Lisa"))
print()


my_list = DoublyLinkedList()
my_list.print_list()
print()


my_list.add_to_end("Homer")
my_list.add_to_end("Bart")
my_list.print_list()
print("Size:", my_list.get_size())
print()


print("Marge in list:", my_list.is_in_list("Marge"))
print("Homer in list:", my_list.is_in_list("Homer"))
print("Bart in list:", my_list.is_in_list("Bart"))
print("Maggie in list:", my_list.is_in_list("Maggie"))
print("Size:", my_list.get_size())
print()


my_list = DoublyLinkedList()
my_list.print_list()
print()

my_list.add_to_start("Homer")
my_list.add_to_start("Bart")
my_list.add_at_position("Marge", 1)
my_list.add_at_position("Maggie", 1)
my_list.add_to_start("Ned Flanders")
my_list.add_to_end("Sr. Burns")
my_list.print_list()
print()


my_list.remove_from_end()
my_list.print_list()
print()

my_list.remove_at_position(1)
my_list.print_list()
print("Size:", my_list.get_size())
print()


print("Marge in list:", my_list.is_in_list("Marge"))
print("Homer in list:", my_list.is_in_list("Homer"))
print("Bart in list:", my_list.is_in_list("Bart"))
print("Maggie in list:", my_list.is_in_list("Maggie"))
print("Size:", my_list.get_size())
print()


my_list.remove_from_start()
my_list.print_list()
print("Size:", my_list.get_size())
print()

# 17) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado e o tamanho da lista.
print("Marge in list:", my_list.is_in_list("Marge"))
print("Homer in list:", my_list.is_in_list("Homer"))
print("Bart in list:", my_list.is_in_list("Bart"))
print("Maggie in list:", my_list.is_in_list("Maggie"))
print("Size:", my_list.get_size())
print()

# 18) Esvazie a lista e imprima.
my_list = DoublyLinkedList()
my_list.print_list()
