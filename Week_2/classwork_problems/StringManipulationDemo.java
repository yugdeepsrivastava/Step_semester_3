public class StringManipulationDemo {
public static void main(String[] args) {
System.out.println(" Hello Java ".trim()); // "Hello Java"
System.out.println("I like cats".replace("cats", "dogs")); // "I like dogs"
String[] parts = "Ravi,25,Chennai".split(",");
for (String part : parts) {
System.out.println(part);
}
// concat() joins two Strings together
System.out.println("Hello".concat(" World"));
// String.join() stitches multiple pieces back together
System.out.println(String.join("-", "2026", "07", "30"));

// toCharArray() breaks a String into individual characters
char[] chars = "Java".toCharArray();
for (char c : chars) {
System.out.print(c + " ");
}
}
}