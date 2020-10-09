class MEArrayList<E>{
	private static final int BUFFER_MULTIPLIER = 2;
	private static final int DEF_BUFFER_SIZE = 5;
	//private E[] al; Tried to do with Generic array creation but as generics are invariant creating an error
	private Object[] al;
	private int size;
	
	private int elemCount; // Not necessary but for keepsake
	
	MEArrayList(){
		this.size = DEF_BUFFER_SIZE;
		this.al = new Object[this.size];
	}
	// add method overloaded
	public void add(int index, E e){
		if(this.elemCount == this.al.length){
			resizeBuffer();
		}
		for(int i=this.elemCount; i>index;i--){
			al[i]=al[i-1];
		}
		al[index] = e;
		this.elemCount++;
	}
	
	public void add(E e){
		this.add(this.elemCount, e);
	}
	
	public Object get(int index){
		if(index < 0 || index >= this.elemCount){
			//throw IndexOutOfBoundsException("Index: " + index + ", Size: "+this.size);
		}
		return al[index];
	}
	
	public Object remove(int index){
		if(index < 0 || index >= this.size){
			//throw IndexOutOfBoundsException("Index: " + index + ", Size: "+this.size);
		}
		Object removedElement = al[index];
		for(int i=index; i<this.elemCount - 1;i++){
			al[i]=al[i+1];
		}
		this.elemCount--;
		return removedElement;
	}
	
	public void display(){
		for(int i=0; i<this.elemCount; i++){
			System.out.println(al[i]);
		}
	}
	//private method
	private void resizeBuffer(){
		int oldSize = this.elemCount;
		this.size*= BUFFER_MULTIPLIER;
		Object[] newAL = new Object[this.size];
		System.out.printf("Resizing array: Increasing size from %d to %d\n", oldSize, this.size);
		System.arraycopy(this.al, 0, newAL, 0, oldSize);
		this.al = newAL;
	}
     
    public static void main(String... a) {
           MEArrayList<Integer> list = new MEArrayList<Integer>();
           //Add elements in custom ArrayList
           list.add(1);
           list.add(2);
           list.add(3);
           list.add(4);
           list.add(1);
           list.add(2);
 
           //Display custom ArrayList
           list.display();
           System.out.println("\nelement at index in custom ArrayList > " + 1 + " = " + list.get(1));
 
           //Remove element from custom ArrayList
           System.out.println("element removed from index " + 1 + " = "
                        + list.remove(1));
 
           //Again display custom ArrayList
           System.out
                   .println("\nlet's display custom ArrayList again after removal at index 1");
 
           list.display();
 
           // list.remove(11); //will throw IndexOutOfBoundsException, because
                        // there is no element to remove on index 11.
           // list.get(11); //will throw IndexOutOfBoundsException, because there
                        // is no element to get on index 11.
    }
     
}

