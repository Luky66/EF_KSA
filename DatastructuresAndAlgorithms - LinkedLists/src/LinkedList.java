
public class LinkedList<T> {
    LinkedList<T> next;		// Sets next to a list of type T
    T current;				// Sets current to type T
    
    public LinkedList() {} // What is this for?
    
    public void setCurrent(T item)
    {
        assert(next != null); // makes sure next isn't null... Although I don't know why that would be a problem...
        this.current = item;
    }
    public T getCurrent() // Returns something of type T
    {
        assert(next != null); // makes sure next isn't null... Although I don't know why that would be a problem...
        return current;
    }
    
    public boolean hasMoreElements()
    {
        return next != null; // returns true if next != to null -> has more elements
    }
    
    public LinkedList<T> getNextElement()
    {
        assert(next != null); // Makes sure next isn't null
        return next;
    }
    
    public void append(T newItem)
    {
        LinkedList<T> last = this;						// Sets the current list to last
        while(last.next != null) { last = last.next; } 	// As long as the next item isn't empty go to the next one...
        last.current = newItem; 						// Then set the current(empty) to the newItem
        last.next = new LinkedList<T>(); 				// Creates a new empty item at the end.
    }
}
