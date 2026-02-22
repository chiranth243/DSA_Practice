from LinkedList import LinkedList

def find_duplicate(llist, len):
    if not llist:
        return None
    
    values = set()

    previous = llist
    current = llist

    while current:

        if current.value in values:
            previous.next = current.next
        else:
            values.add(current.value)
            previous = current

        current = current.next

def test_find_duplicate():
    # Test Case 1: List with duplicates
    print("Test Case 1: Remove duplicates from list with duplicates")
    ll1 = LinkedList(10)
    ll1.append(20)
    ll1.append(10)
    ll1.append(30)
    ll1.append(20)
    ll1.append(40)
    # Original: 10 -> 20 -> 10 -> 30 -> 20 -> 40
    # Expected: 10 -> 20 -> 30 -> 40
    
    print(f"Before: {ll1.get_values()}")
    find_duplicate(ll1.head, ll1.len)
    print(f"After:  {ll1.get_values()}")
    print(f"Expected: [10, 20, 30, 40]\n")
    
    # Test Case 2: List with all unique values
    print("Test Case 2: List with all unique values")
    ll2 = LinkedList(1)
    ll2.append(2)
    ll2.append(3)
    ll2.append(4)
    ll2.append(5)
    # Original: 1 -> 2 -> 3 -> 4 -> 5
    # Expected: 1 -> 2 -> 3 -> 4 -> 5 (no change)
    
    print(f"Before: {ll2.get_values()}")
    find_duplicate(ll2.head, ll2.len)
    print(f"After:  {ll2.get_values()}")
    print(f"Expected: [1, 2, 3, 4, 5]\n")
    
    # Test Case 3: List with consecutive duplicates
    print("Test Case 3: List with consecutive duplicates")
    ll3 = LinkedList(5)
    ll3.append(5)
    ll3.append(5)
    ll3.append(10)
    ll3.append(10)
    # Original: 5 -> 5 -> 5 -> 10 -> 10
    # Expected: 5 -> 10
    
    print(f"Before: {ll3.get_values()}")
    find_duplicate(ll3.head, ll3.len)
    print(f"After:  {ll3.get_values()}")
    print(f"Expected: [5, 10]\n")
    
    # Test Case 4: Single node list
    print("Test Case 4: Single node list")
    ll4 = LinkedList(100)
    # Original: 100
    # Expected: 100 (no change)
    
    print(f"Before: {ll4.get_values()}")
    find_duplicate(ll4.head, ll4.len)
    print(f"After:  {ll4.get_values()}")
    print(f"Expected: [100]\n")
    
    # Test Case 5: All duplicates (same value)
    print("Test Case 5: All same values")
    ll5 = LinkedList(7)
    ll5.append(7)
    ll5.append(7)
    ll5.append(7)
    # Original: 7 -> 7 -> 7 -> 7
    # Expected: 7
    
    print(f"Before: {ll5.get_values()}")
    find_duplicate(ll5.head, ll5.len)
    print(f"After:  {ll5.get_values()}")
    print(f"Expected: [7]\n")
    
    # Test Case 6: Duplicates at different positions
    print("Test Case 6: Duplicates scattered throughout")
    ll6 = LinkedList(1)
    ll6.append(2)
    ll6.append(3)
    ll6.append(1)
    ll6.append(4)
    ll6.append(2)
    ll6.append(5)
    # Original: 1 -> 2 -> 3 -> 1 -> 4 -> 2 -> 5
    # Expected: 1 -> 2 -> 3 -> 4 -> 5
    
    print(f"Before: {ll6.get_values()}")
    find_duplicate(ll6.head, ll6.len)
    print(f"After:  {ll6.get_values()}")
    print(f"Expected: [1, 2, 3, 4, 5]\n")

if __name__ == "__main__":
    test_find_duplicate()