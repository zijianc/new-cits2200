package CITS2200;
import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

public class ListLinked implements List {
  private Link before;
  private Link after;

  public ListLinked() {
    after = new Link(null, null);
    before = new Link(null, after);
  }

  public boolean isEmpty() {
    return before.successor == after;
    
  }

  public boolean isBeforeFirst(WindowLinked w) {
    // TODO: Implement isBeforeFirst
    return w.link.equals(before);
  }

  public boolean isAfterLast(WindowLinked w) {
    // TODO: Implement isAfterLast
    return w.link.equals(after);
  }

  public void beforeFirst(WindowLinked w) {
    w.link = before;
  }

  public void afterLast(WindowLinked w) {
    // TODO: Implement afterLast
     w.link = after;
  }

  public void next(WindowLinked w) throws OutOfBounds {
    if (isAfterLast(w)) {
      throw new OutOfBounds("Calling next after list end.");
    }
    w.link = w.link.successor;
  }

  public void previous(WindowLinked w) throws OutOfBounds {
    if (isBeforeFirst(w)) {
      throw new OutOfBounds("Calling previous before start of list.");
    }
    Link current = before.successor;
    Link previous = before;
    while (current != w.link) {
      previous = current;
      current = current.successor;
    }
    w.link = previous;
  }

  public void insertAfter(Object e, WindowLinked w) throws OutOfBounds {
    // TODO: Implement insertAfter
    if (!isAfterLast(w)) {
 
            w.link.successor = new Link(e, w.link.successor);
 
        } else {
            throw new OutOfBounds("cant insert after then end of the list");
        }
  }

  public void insertBefore(Object e, WindowLinked w) throws OutOfBounds {
    if (isBeforeFirst(w)) {
      throw new OutOfBounds("Inserting before start of list.");
    }
    w.link.successor = new Link(w.link.item, w.link.successor);
    if (isAfterLast(w)) {
      after = w.link.successor;
    }
    w.link.item = e;
    w.link = w.link.successor;
  }

  public Object examine(WindowLinked w) throws OutOfBounds {
    // TODO: Implement examine
     if (!isBeforeFirst(w) && !isAfterLast(w)) {
            return w.link.item;
        } else {
            throw new OutOfBounds("window is outside of the list");
        }
  }

  public Object replace(Object e, WindowLinked w) throws OutOfBounds {
    // TODO: Implement replace
    
  if (!isAfterLast(w) && !isBeforeFirst(w)) {
 
            Object temp = w.link.item;
            w.link.item = e;
 
            return temp;
        } else {
            throw new OutOfBounds("cant replace element before first or after last position");
        }

  }

  public Object delete(WindowLinked w) throws OutOfBounds {
    // TODO: Implement delete
    // NOTE: Your delete implementation MUST be constant time,
    // and therefore MAY NOT contain a loop or call previous()
    		  if (!isBeforeFirst(w) && !isAfterLast(w)) {
            Object temp = w.link.item;
           w.link.item = null;
 
            w.link = w.link.successor;
 
            return temp;
 
        } else {
            throw new OutOfBounds("cant delete element before first or after last position");
        }
  }
}
