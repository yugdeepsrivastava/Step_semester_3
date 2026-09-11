public class PerformanceDemo {
public static void main(String[] args) {
int n = 50_000; // number of concatenations to perform
// SLOW: creates a brand-new String on every single loop iteration
String result = "";
long t1 = System.nanoTime();
for (int i = 0; i < n; i++) { result += "x"; }
long time1 = (System.nanoTime() - t1) / 1_000_000;
// FAST: reuses one growable buffer instead of copying every time
StringBuilder sb = new StringBuilder();
long t2 = System.nanoTime();
for (int i = 0; i < n; i++) { sb.append("x"); }
long time2 = (System.nanoTime() - t2) / 1_000_000;
System.out.println("String += : " + time1 + " ms");
System.out.println("StringBuilder : " + time2 + " ms");
}
}