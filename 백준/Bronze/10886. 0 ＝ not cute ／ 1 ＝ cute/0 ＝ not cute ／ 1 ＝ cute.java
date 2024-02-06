import java.io.*;
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int cute_count = 0;
    int not_count = 0;
    for(int i = 0; i < n ; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 1) {
        cute_count++;
      } else {
        not_count++;
      }
    }
    if (cute_count > not_count) {
      System.out.print("Junhee is cute!");
    } else {
      System.out.print("Junhee is not cute!");
    }
  }
}