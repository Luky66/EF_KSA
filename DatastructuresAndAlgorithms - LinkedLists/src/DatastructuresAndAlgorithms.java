
public class DatastructuresAndAlgorithms {
    public static void main(String[] args)
    {
        //testIntLinkedList();
    	//testLinkedList();
    	
        //testDoubleLinkedListForward();
        testDoubleLinkedListBackwards();
    }
    
    static void testIntLinkedList()
    {
        int numbers[] = { 2, 3, 1, 6, 4, 7, 8 };
        LinkedIntList listHead = new LinkedIntList();	// Sets listHead to a LinkedIntList
        LinkedIntList listTail = listHead; 				// No clue actually; seems to set listTail to the same LinkedIntList
        for(int num : numbers)
        {
        	// Fills the list with the integers from numbers[]
            listTail.current = num; 					// Sets the current item to a int
            listTail.next = new LinkedIntList(); 		// Sets up a new list-item for the next int
            listTail = listTail.next; 					// Sets itself to the next item
        }
        for(listTail = listHead; listTail.next != null; listTail = listTail.next)
        // Emptys listTail, and loops through as long as there is a next element.  
        {
            System.out.println(listTail.current);
        }
    }
    static void testLinkedList()
    {
        String strings[] = { "The", "quick", "brown", "fox" };
        LinkedList<String> listHead = new LinkedList<String>();
        LinkedList<String> listTail = listHead;
        for (String string : strings)
        {
            listTail.append(string);
            listTail = listTail.getNextElement();   
        }
        
        for(listTail = listHead; listTail.hasMoreElements(); listTail = listTail.getNextElement())
        {
            System.out.println(listTail.getCurrent());
        }
    } 
    static void testDoubleLinkedListForward()
    {
    	String strings[] = {"L", "I", "V", "E"};
    	DoubleLinkedList<String> listHead = new DoubleLinkedList<String>();
    	DoubleLinkedList<String> listTail = listHead;
    	for (String string : strings)
    	{
    		listTail.append(string);
    		listTail = listTail.getNextElement();
    	}
    	
    	for(listTail = listHead; listTail.hasMoreElementsForward(); listTail = listTail.getNextElement())
    	{
    		System.out.println(listTail.getCurrent());
    	}
    }
    static void testDoubleLinkedListBackwards()
    {
    	String strings[] = {"L", "I", "V", "E"};
    	DoubleLinkedList<String> listHead = new DoubleLinkedList<String>();
    	DoubleLinkedList<String> listTail = listHead;
    	for (String string : strings)
    	{
    		listTail.append(string);
    		listTail = listTail.getNextElement();
    	}
    	listTail = listTail.prev;
    	for(listHead = listTail; listTail.next.hasMoreElementsBackwards(); listTail = listTail.getLastElement())
    	{
    			System.out.println(listTail.getCurrent());
    		
    		if(listTail.prev == null) // For safety reasons, otherwise it would throw a NullPointer-Exception
    		{
    			break;
    		}
    	}
    }
}
