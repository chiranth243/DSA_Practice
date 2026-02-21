from LinkedList import LinkedList as ll


def find_middle_node(list):
    if list.head:

        slow = list.head
        fast = list.head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        return slow


if __name__ == "__main__":
    llist = ll(24)
    llist.append(23)
    llist.append(47)
    llist.append(94)
    llist.append(188)

    print("llist nodes:")
    llist.print_list()

    #odd number list
    llist_mid = find_middle_node(llist)
    print(f"llist mid is: {llist_mid.value}")

    my_list = ll(2)
    my_list.append(4)
    my_list.append(6)
    my_list.append(8)

    print("my list nodes:")
    my_list.print_list()

    #even number list
    my_list_mid = find_middle_node(my_list)
    print(f"my list mid is: {my_list_mid.value}")