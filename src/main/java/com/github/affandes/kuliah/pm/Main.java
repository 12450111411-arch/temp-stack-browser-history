import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    private Stack<String> history = new Stack<>();

    public void browse(String url) {
        history.push(url);
        System.out.println("Browsing: " + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("History kosong, tidak bisa kembali.");
        } else {
            String removed = history.pop();
            System.out.println("Kembali dari: " + removed);

            if (!history.isEmpty()) {
                System.out.println("Sekarang berada di: " + history.peek());
            } else {
                System.out.println("Tidak ada history yang tersisa.");
            }
        }
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("\n=== Browser History (Newest → Oldest) ===");
            Stack<String> temp = new Stack<>();
            temp.addAll(history);

            while (!temp.isEmpty()) {
                System.out.println("- " + temp.pop());
            }
        }
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();
        Scanner sc = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\n=== MENU BROWSER HISTORY ===");
            System.out.println("1. Browse (Tambah website)");
            System.out.println("2. Back (Kembali)");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan URL: ");
                    String url = sc.nextLine();
                    bh.browse(url);
                    break;

                case 2:
                    bh.back();
                    break;

                case 3:
                    bh.view();
                    break;

                case 4:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 4);

        sc.close();
    }
}
