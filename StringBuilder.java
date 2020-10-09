public class StringBuilder{

private static final int BUFFER_MULTIPLIER = 2;
private static final int DEF_BUFFER_SIZE = 16;

private char[] str;
private int size;
private int charCount;


//Cnstructors 

// with parameter
StringBuilder(int size){
	this.size = size;
	this.str = new char[this.size];
}

// parameter-less
StringBuilder(){
	this(DEF_BUFFER_SIZE);
}

// String parameter
StringBuilder(String str){
	this();
	append(str);
}

//Char parameter
StringBuilder(char[] str){
	this();
	append(str);
}

// Append method overloaded for different scenarios
public StringBuilder append(Object item){
	String str = item.toString();
	while(resizeRequired(str)){resizeBuffer();}
	addString(str);
	updateCharCount(str.length());
	return this;
}
public StringBuilder append(String str){
	while(resizeRequired(str)){resizeBuffer();}
	addString(str);
	updateCharCount(str.length());
	return this;
}
public StringBuilder append(char[] str){
	while(resizeRequired(str)){resizeBuffer();}
	addString(str);
	updateCharCount(str.length);
	return this;
}

//to String method Overridden
@Override
public String toString(){
	return String.valueOf(this.str);
}

//resizeRequired overloaded
private boolean resizeRequired(String newInput){
	return this.charCount + newInput.length() > this.size;
}

private boolean resizeRequired(char[] newInput){
	return this.charCount + newInput.length > this.size;
}

//addString overloaded
private void addString(char[] str){
	System.arraycopy(str, 0,this.str, this.charCount, str.length);
}
private void addString(String str){
	System.arraycopy(str.toCharArray(), 0,this.str, this.charCount, str.length());
}

private void updateCharCount(int count){
	this.charCount+=count;
}


//resizeBuffer

private void resizeBuffer(){
	int oldsize = this.size;
	this.size*=BUFFER_MULTIPLIER;
	char[] newStr = new char[this.size];
	System.out.printf("Resizing array: Increasing size from %d to %d\n", oldsize, this.size);
	System.arraycopy(this.str, 0 , newStr, 0, oldsize);
	this.str = newStr;
}

public static void main(String[] args) {
       

        StringBuilder sb = new StringBuilder();
        sb.append("Test1");
        sb.append("Test2");
        sb.append(" troll");

        // Resize internal char array from 64 to 128.
        sb.append("New String Addition starting RAWRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");

        // Append char array
        char[] str = { 'b', 'o', 'o'};
        sb.append(str);

        // Resize from 128 to 256
        sb.append("Another super long string here we go !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println(sb.toString());
    }
}