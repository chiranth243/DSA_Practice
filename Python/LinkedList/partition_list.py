from LinkedList import LinkedList
from LinkedList import Node

def partition(llist, x):
    if not llist:
        return None
    
    dummy_1 = Node(0)
    prev_1 = dummy_1

    dummy_2 = Node(0)
    prev_2 = dummy_2

    current = llist.head

    while current:
        if current.value < x:
            prev_1.next = current
            prev_1 = prev_1.next
        else:
            prev_2.next = current
            prev_2 = prev_2.next

        current = current.next

    prev_2.next = None
    prev_1.next = dummy_2.next

    return dummy_1.next


# Create the list: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
my_list = LinkedList(3)
my_list.append(5)
my_list.append(8)
my_list.append(5)
my_list.append(10)
my_list.append(2)
my_list.append(1)

# Partition around x = 5
partition(my_list, 5)

# Output: 3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10
my_list.print_list()
