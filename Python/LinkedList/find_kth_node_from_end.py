from LinkedList import LinkedList

def find_node_from_end(llist, k):
    if not llist:
        return None
    
    slow = llist
    fast = llist

    for _ in range(k):
        if fast is None:
            return None
        
        fast = fast.next

    while fast:
        slow = slow.next
        fast = fast.next

    return slow

def test_find_kth_node():
    # Test Case 1: Find 2nd node from end
    print("Test Case 1: Find 2nd node from end")
    ll1 = LinkedList(10)
    ll1.append(20)
    ll1.append(30)
    ll1.append(40)
    ll1.append(50)
    # List: 10 -> 20 -> 30 -> 40 -> 50
    # 2nd from end should be 40
    
    result = find_node_from_end(ll1.head, 2)
    print(f"List: 10 -> 20 -> 30 -> 40 -> 50")
    print(f"2nd node from end value: {result.value if result else 'None'}")
    print(f"Expected: 40\n")
    
    # Test Case 2: Find 1st node from end (last node)
    print("Test Case 2: Find 1st node from end (last node)")
    result = find_node_from_end(ll1.head, 1)
    print(f"1st node from end value: {result.value if result else 'None'}")
    print(f"Expected: 50\n")
    
    # Test Case 3: Find node with k greater than list length
    print("Test Case 3: Find node when k > list length")
    result = find_node_from_end(ll1.head, 10)
    print(f"Result: {result}")
    print(f"Expected: None\n")
    
    # Test Case 4: Single node list
    print("Test Case 4: Single node list")
    ll2 = LinkedList(100)
    result = find_node_from_end(ll2.head, 1)
    print(f"1st node from end value: {result.value if result else 'None'}")
    print(f"Expected: 100\n")
    
    # Test Case 5: Find 5th node from end
    print("Test Case 5: Find 5th node from end")
    ll3 = LinkedList(1)
    for i in range(2, 8):
        ll3.append(i)
    # List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    # 5th from end should be 3
    
    result = find_node_from_end(ll3.head, 5)
    print(f"List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7")
    print(f"5th node from end value: {result.value if result else 'None'}")
    print(f"Expected: 3\n")

if __name__ == "__main__":
    test_find_kth_node()