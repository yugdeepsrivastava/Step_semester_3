public class StringMethodsDemo {
public static void main(String[] args) {

String city = "Chennai";
System.out.println(city.length()); // 7
System.out.println(city.charAt(0)); // C
System.out.println(city.substring(3)); // nnai
System.out.println(city.substring(1, 5)); // henn
System.out.println(city.indexOf('n')); // 2
System.out.println(city.indexOf("xyz")); // -1 (not found)
System.out.println(city.contains("hen")); // true
System.out.println(city.toUpperCase()); // CHENNAI
System.out.println(city.equalsIgnoreCase("CHENNAI")); // true
System.out.println("".isEmpty()); // true
System.out.println(city.startsWith("Che")); // true
}
}