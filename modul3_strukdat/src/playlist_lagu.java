import java.util.Scanner;
public class playlist_lagu {
    private Node head;
    private Node tail;
    private int size;

    public playlist_lagu() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        private String song;
        private Node next;

        public Node(String song) {
            this.song = song;
            this.next = null;
        }
    }

    public void enqueue(String song) {
        Node newNode = new Node(song);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Menambahkan lagu \"" + song + "\" ke playlist");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Playlist kosong");
            return null;
        } else {
            String song = head.song;
            head = head.next;
            size--;
            System.out.println("Hapus lagu \"" + song + "\" dari playlist.");
            return song;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Playlist kosong");
            return null;
        } else {
            System.out.println("Now playing: \"" + head.song + "\"");
            return head.song;
        }
    }

    public boolean isEmpty() {

        return (size == 0);
    }

    public int size() {


        return size;
    }


    public static void main(String[] args) {
        playlist_lagu playlist = new playlist_lagu();
        Scanner input = new Scanner(System.in);
        int pilih;
        boolean isBalik = true;
        while(isBalik){
            System.out.println("Pilih :\n 1. Menambah lagu\n 2. Menghapus lagu\n 3. Lagu yang diputar\n 4. Quit");
            System.out.print("\nMasukkan pilihan: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Enter song title: ");
                    String songTitle = input.next();
                    playlist.enqueue(songTitle);
                    break;
                case 2:
                    playlist.dequeue();
                    break;
                case 3:
                    playlist.peek();
                    break;
                case 4:
                    System.out.println("Playlist size: " + playlist.size());
                    break;
                case 0:
                    System.out.println("Exiting playlist.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
       }
}