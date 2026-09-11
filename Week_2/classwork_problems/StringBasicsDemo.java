public class StringBasicsDemo {
public static void main(String[] args) {
// Two identical literal Strings are automatically stored as ONE
// shared object in memory, called the String Pool.
String a = "Java";
String b = "Java";
System.out.println(a == b); // true -- same shared object
// Using 'new' explicitly creates a separate object, even with
// identical text -- it does NOT use the shared pool.
String c = new String("Java");
System.out.println(a == c); // false -- different object
// .equals() compares the ACTUAL TEXT, regardless of memory location.
System.out.println(a.equals(c)); // true -- same content
// "Changing" a String really means creating a brand-new one.
String greeting = "Hello";
greeting = greeting + " World"; // "Hello" itself is untouched
System.out.println(greeting); // Hello World
}
}