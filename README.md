# Tic-Tac-Toe OOP (Java Console)

Proyek ini merupakan implementasi permainan **Tic-Tac-Toe** menggunakan bahasa pemrograman **Java** dengan konsep **Object-Oriented Programming (OOP)**. Permainan berjalan melalui console dan mendukung beberapa mode permainan serta ukuran papan yang dapat dipilih.

## Cara Menjalankan Program

1. Pastikan Java (JDK) sudah terinstal.
2. Buka terminal pada folder project.
3. Compile semua file `.java`:

   ```bash
   javac *.java
   ```
4. Jalankan program:

   ```bash
   java Main
   ```

File **score.txt** akan dibuat otomatis untuk menyimpan skor setelah permainan selesai.

## Gameplay

1. Pilih mode permainan:

   * Player vs Player
   * Player vs CPU

2. Pilih ukuran papan:

   * 3x3
   * 4x4
   * 5x5

3. Jika bermain melawan CPU:

   * Pilih tingkat kesulitan CPU (Level 1–3)

4. Pemain memasukkan baris dan kolom untuk menempatkan simbol, misalnya:

   ```
   Player1 (r c): 1 2
   ```

5. Permainan berakhir jika:

   * Salah satu pemain mendapatkan 3 simbol berurutan
   * Papan penuh (seri)

6. Skor kedua pemain disimpan otomatis ke dalam file.

## Fitur

* Dukungan papan dinamis: 3x3, 4x4, dan 5x5
* Mode Player vs Player dan Player vs CPU
* CPU dengan 3 level kecerdasan:

  * Level 1: acak
  * Level 2: blok dan strategi dasar
  * Level 3: strategi optimal
* Animasi saat mencetak papan (delay singkat)
* Penyimpanan skor otomatis ke file `score.txt`
* Implementasi konsep OOP:

  * Encapsulation
  * Inheritance
  * Polymorphism
  * Class terpisah dan modular

## Struktur Project

```
Main.java
Game.java
Board.java
Player.java
HumanPlayer.java
ComputerPlayer.java
ScoreManager.java
score.txt (dibuat otomatis)
```

## Konsep OOP yang Diterapkan

* **Inheritance**: `HumanPlayer` dan `ComputerPlayer` mewarisi class `Player`.
* **Polymorphism**: Method `move()` diimplementasikan berbeda pada pemain manusia dan CPU.
* **Encapsulation**: Atribut dibuat private/protected sesuai kebutuhan.
* **Association**: Class `Game` menggunakan `Player` dan `Board`.
