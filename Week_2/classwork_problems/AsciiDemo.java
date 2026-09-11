public class AsciiDemo {
public static void main(String[] args) {
// Character to ASCII
char letter = 'A';
System.out.println((int) letter); // 65
// ASCII to character
char back = (char) 97;
System.out.println(back); // a
// Uppercase -> lowercase using the 32-gap trick
char upper = 'M';
char lower = (char) (upper + 32);
System.out.println(lower); // m
// Printing the whole alphabet using ASCII values
for (int i = 65; i <= 90; i++) {

System.out.print((char) i);
}
System.out.println();
// The safer, built-in alternative for real projects
System.out.println(Character.isDigit('7')); // true
System.out.println(Character.isLetter('Z')); // true
System.out.println(Character.toUpperCase('m')); // M
}
}