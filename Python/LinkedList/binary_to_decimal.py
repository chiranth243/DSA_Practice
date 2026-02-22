from LinkedList import LinkedList

def binary_to_decimal(llist):
    if not llist:
        return None
    
    result = 0
    while llist:
        result = (result * 2) + llist.value
        llist = llist.next

    return result

def test_binary_to_decimal():
    # Test Case 1: Binary 101 (decimal 5)
    print("Test Case 1: Binary 101 (decimal 5)")
    ll1 = LinkedList(1)
    ll1.append(0)
    ll1.append(1)
    print(f"Binary: {ll1.get_values()}")
    print(f"Decimal: {binary_to_decimal(ll1.head)}")
    print(f"Expected: 5\n")
    
    # Test Case 2: Binary 1110 (decimal 14)
    print("Test Case 2: Binary 1110 (decimal 14)")
    ll2 = LinkedList(1)
    ll2.append(1)
    ll2.append(1)
    ll2.append(0)
    print(f"Binary: {ll2.get_values()}")
    print(f"Decimal: {binary_to_decimal(ll2.head)}")
    print(f"Expected: 14\n")
    
    # Test Case 3: Binary 1 (decimal 1)
    print("Test Case 3: Binary 1 (decimal 1)")
    ll3 = LinkedList(1)
    print(f"Binary: {ll3.get_values()}")
    print(f"Decimal: {binary_to_decimal(ll3.head)}")
    print(f"Expected: 1\n")
    
    # Test Case 4: Binary 1010 (decimal 10)
    print("Test Case 4: Binary 1010 (decimal 10)")
    ll4 = LinkedList(1)
    ll4.append(0)
    ll4.append(1)
    ll4.append(0)
    print(f"Binary: {ll4.get_values()}")
    print(f"Decimal: {binary_to_decimal(ll4.head)}")
    print(f"Expected: 10\n")
    
    # Test Case 5: Binary 1111 (decimal 15)
    print("Test Case 5: Binary 1111 (decimal 15)")
    ll5 = LinkedList(1)
    ll5.append(1)
    ll5.append(1)
    ll5.append(1)
    print(f"Binary: {ll5.get_values()}")
    print(f"Decimal: {binary_to_decimal(ll5.head)}")
    print(f"Expected: 15\n")

if __name__ == "__main__":
    test_binary_to_decimal()