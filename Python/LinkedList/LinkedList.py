class Node:

    #--------------------------------------
    # Initialize node with given value
    #--------------------------------------
    def __init__(self, value):
        self.value = value
        self.next = None

class LinkedList:
    #--------------------------------------
    # Create list with single node
    #--------------------------------------
    def __init__(self, value):
        new_node = Node(value)
        self.head = new_node
        self.tail = new_node
        self.len = 1
        
    #--------------------------------------
    # Add value to list tail
    #--------------------------------------
    def append(self, value):
        new_node = Node(value)

        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

        self.len += 1

        return True

    #--------------------------------------
    # Add value to list head
    #--------------------------------------
    def prepend(self, value):
        new_node = Node(value)

        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node

        self.len +=1
        return True


    #--------------------------------------
    # Print all node values
    #--------------------------------------
    def print_list(self):
        temp = self.head

        while temp is not None:
            print(temp.value)
            temp = temp.next

    #--------------------------------------
    # Remove and return last node
    #--------------------------------------
    def pop(self):
        if self.len == 0:
            return None
        
        temp = self.head
        prev = self.head

        while (temp.next):
            prev = temp
            temp = temp.next

        self.tail = prev
        self.tail.next = None
        self.len -= 1

        if self.len == 0:
            self.head = None
            self.tail = None

        return temp
    
    #--------------------------------------
    # Remove and return first node
    #--------------------------------------
    def pop_first(self):
        if self.len == 0:
            return None
        
        temp = self.head
        self.head = self.head.next
        temp.next = None
        self.len -= 1

        if self.len == 0:
            self.tail = None

        return temp
    
    #--------------------------------------
    # Get node at given index
    #--------------------------------------
    def get(self, index):
        if index < 0 or index >= self.len:
            return None
        
        temp = self.head
        
        for _ in range(index):
            temp = temp.next

        return temp
    
    #--------------------------------------
    # Set node value at index
    #--------------------------------------
    def set_value(self, index, value):
        temp = self.get(index)

        if temp:
            temp.value = value
            return True
        
        return False
    
    #--------------------------------------
    # Insert value at specified index
    #--------------------------------------
    def insert(self, index, value):
        if index < 0 or index > self.len:
            return False
        
        if index == 0:
            return self.prepend(value)
        
        if index == self.len:
            return self.append(value)
        
        temp = self.get(index-1)
        new_node = Node(value)

        new_node.next = temp.next
        temp.next = new_node

        return True
    
    #--------------------------------------
    # Remove node at specified index
    #--------------------------------------
    def remove(self, index):
        if index < 0  or index >= self.len:
            return None
        
        if index == 0:
            return self.pop_first()
        
        if index == self.len - 1:
            return self.pop()
        
        prev = self.get(index-1)
        temp = prev.next

        prev.next = temp.next
        temp.next = None

        return temp
    
    #--------------------------------------
    # Reverse list in place
    #--------------------------------------
    def reverse(self):
        if self.len == 0:
            return False
        
        temp = self.head
        self.head = self.tail
        self.tail = temp

        after = None
        before = None

        for _ in range(self.len):
            after = temp.next
            temp.next = before
            before = temp
            temp = after

        return True



def demonstrate_insert_zero(linked_list, value):
    #--------------------------------------
    # Demo insert at index zero
    #--------------------------------------
    linked_list.insert(0, value)
    print("Inserting to 0")
    linked_list.print_list()


def main():
    #--------------------------------------
    # Demonstrate linked list operations
    #--------------------------------------
    my_linked_list = LinkedList(1)

    my_linked_list.append(2)

    my_linked_list.prepend(24)

    my_linked_list.prepend(23)

    my_linked_list.append(26)

    print("printing linked list before pop")
    my_linked_list.print_list()

    poped_element = my_linked_list.pop()
    print(f"Succeesfully pooped {poped_element.value}")
    my_linked_list.print_list()

    my_linked_list.prepend(8)

    print("printing list before pop first")
    my_linked_list.print_list()

    pop_first = my_linked_list.pop_first()
    print(f"successfully popped {pop_first.value} from first")
    my_linked_list.print_list()

    get_node = my_linked_list.get(1)
    print(f"node value is: {get_node.value}")

    print("printing list before setting value")
    my_linked_list.print_list()

    my_linked_list.set_value(2, 47)
    print("printing after setting value")
    my_linked_list.print_list()

    my_linked_list.insert(2, 7)
    print("Printing after insert")
    my_linked_list.print_list()

    demonstrate_insert_zero(my_linked_list, 12)

    my_linked_list.insert(5, 13)
    print("Inserting to last")
    my_linked_list.print_list()

    my_linked_list.remove(3)
    print("printing of after remove")
    my_linked_list.print_list()

    my_linked_list.reverse()
    print("printing after reverse")
    my_linked_list.print_list()


if __name__ == "__main__":
    main()