import java.util.*;

public class projekakhir {
    static String data[] = {"1. iPhone 8", "2. iPhone X", "3. iPhone Xs", "4. iPhone 11", "5. iPhone 11Pro"};
    static int stok[] = {10, 10, 10, 10, 10};
    static int harga[] = {85000, 140000, 160000, 250000, 300000};
    static String nama[] = new String[50];
    static String nama1;
    static int ts[] = new int[50]; 
    static int hari[] = new int[50];
	static int NoPel[] = new int [50];
    static int tk[] = new int[50];
    static int tks[] = new int[50];
    static int biaya[] = new int[50];
    static int pinjam[] = new int[50];
    static String iphone[] = new String[50];
    static int telat[] = new int[50]; 
    static int denda[] = new int[50];
    static int sewa; 
    static int a, x, y, i; 
    static int index;
    static int noPelanggan = 0;

    static void listMenu(){
        System.out.println("=========================SELAMAT DATANG DI SEWA IPHONE==========================");
        System.out.println("List Menu: ");
        System.out.println("1. Data Master");
        System.out.println("2. Persewaan");
        System.out.println("3. Pengembalian");
        System.out.println("4. Pencarian");
        System.out.println("5. Keluar");
    }

    static void dataMaster(){
        for(int i = 0; i < data.length; i++){
            System.out.printf("%s", data[i]);
            for(int j = 0; j < 1; j++){
                System.out.print("\t Rp. ");
                System.out.printf(" %d \t",harga[i]);
                System.out.print(" /24 jam");
                System.out.print("\tStock: " + stok[i]);
            }
            System.out.println();
        }
    }

    static int persewaan(){
        Scanner sc = new Scanner(System.in);
        for(x = 0; x < nama.length; x++){
			System.out.print("Masukan Nama Anda : ");
			nama[index] = sc.next();
			NoPel[index] = index; 
			System.out.print("Masukkan angka sesuai data master untuk menyewa IPhone yang anda inginkan: ");
			pinjam[index] = sc.nextInt();
			if(pinjam[index] == 1){
				iphone[index] = data[0];
			} else if(pinjam[index] == 2){
				iphone[index] = data[1];
			} else if(pinjam[index] == 3){
				iphone[index] = data[2];
			} else if(pinjam[index] == 4){
				iphone[index] = data[3];
			} else if(pinjam[index] == 5){
				iphone[index] = data[4];
			} else{
				System.out.println("Masukkan angka sesuai data master!");
			}
			sewa = pinjam[index];
			sewa -= 1;
			stok[sewa] -= 1;
			System.out.print("Masukkan tanggal sekarang (1-31): ");
			ts[index] = sc.nextInt();
			if(ts[index] < 1 || ts[index] > 31){
				System.out.println("Tanggal salah, mohon masukkan tanggal sesuai ketentuan!");
			}
			System.out.print("Anda ingin menyewa selama (hari) : ");
			hari[index] = sc.nextInt();
			tk[index] = ts[index] + hari[index];
			if(tk[index] > 31){
				tk[index] = ts[index] + hari[index] - 31;
			}
			for(i = 1; i <= pinjam[index]; i++){
								y = i - 1;
								biaya[index] = hari[index] * harga[y];
								}
				System.out.print("Anda akan meminjam " + "(" + data[i - 2] + ")" + " selama: " + hari[index] + " hari");
				System.out.println("\nTotal biaya sewa: Rp. " + biaya[index]);
				System.out.println("Jika terlambat mengembalikan, akan dikenai denda Rp. 300.000/hari");
				index++;
        break;
        }
            return biaya[index];
        }

    static void pengembalian(){
        int kembali;
        Scanner sc = new Scanner(System.in);
        if(index == 0){
            System.out.print("Belum ada IPhone yang disewa!");
        } else{
			System.out.println("=========================SELAMAT DATANG DI MENU PENGEMBALIAN==========================\n");
			System.out.print("Nama\t\t\t");
			System.out.print("Tgl Sewa\t\t");
			System.out.print("Tgl Kembali\t\t");
			System.out.println("Jenis Iphone");
			for(a = 0; a < index; a++){
				System.out.print(nama[a] + "\t\t\t");
				System.out.print(ts[a] + "\t\t\t");
				System.out.print(tk[a] + "\t\t\t");
				System.out.print(iphone[a] + "\n");
			}
			System.out.print("Masukkan nama anda: ");
			nama1 = sc.next();
			for(a = 0; a < index; a++){
				if (nama1.equalsIgnoreCase(nama[a])){
					noPelanggan = NoPel[a];
				System.out.print("Masukkan tanggal sekarang (1-31): ");
				tks[noPelanggan] = sc.nextInt();
					if(tks[noPelanggan] <= (tk[a]) && tks[noPelanggan] >= ts[a]){
						System.out.print("Masukkan angka sesuai data master untuk mengembalikan IPhone yang anda sewa: ");
						kembali = sc.nextInt();
						kembali -= 1;
						stok[kembali] += 1;
						System.out.print("Anda mengembalikan dengan tepat waktu");
						index--;
						nama = hapusString(nama, a);
						iphone = hapusString(iphone, a);
						NoPel = hapusAngka(NoPel, a);
						hari = hapusAngka(hari, a);
						ts = hapusAngka(ts, a);
						tk = hapusAngka(tk, a);
						tks = hapusAngka(tks, a);
						break;

					} else if(tks[noPelanggan] > (tk[a])){
						System.out.print("Masukkan angka sesuai data master untuk mengembalikan IPhone yang anda sewa: ");
						kembali = sc.nextInt();
						kembali -= 1;
						stok[kembali] += 1;
						telat[a] = tks[noPelanggan] - (tk[a]);
						denda[a] = telat[a] * 300000;
						System.out.println("Anda telat mengembalikan selama " + telat[a] + " hari");
						System.out.print("Anda dikenai denda sebesar Rp. " + denda[a]);
						index--;
						nama = hapusString(nama, a);
						iphone = hapusString(iphone, a);
						NoPel = hapusAngka(NoPel, a);
						hari = hapusAngka(hari, a);
						ts = hapusAngka(ts, a);
						tk = hapusAngka(tk, a);
						tks = hapusAngka(tks, a);
						
					break;
					} else{
						System.out.print("Mohon masukkan tanggal sekarang dengan benar!");
					}			
				} else{
					System.out.print("Mohon masukkan nama anda dengan benar!");
				}
			}
		}
        
    }

    static String[] hapusString(String[] arr, int index)
    {
        if (arr == null || index < 0
            || index >= arr.length) {
 
            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
 
        return anotherArray;
    }

    static int[] hapusAngka(int[] arr, int index)
    {
        if (arr == null || index < 0
            || index >= arr.length) {
 
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
 
        return anotherArray;
    }

    static void pencarian(){
        int pilih, tahun, seri, budget = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI MENU PENCARIAN");
        System.out.println("Mencari berdasarkan: ");
        System.out.println("1. Tahun rilis");
        System.out.println("2. Seri Iphone");
        System.out.println("3. Range budget/hari");
        System.out.print("Masukkan nomor pada list: ");
        pilih = sc.nextInt();
        System.out.println();
        switch(pilih){
            case 1:
            System.out.print("Masukkan tahun rilis: ");
            tahun = sc.nextInt();
            if(tahun == 2017){
                for(int i = 0; i < 2; i++){
                System.out.printf("%s", data[i]);
                for(int j = 0; j < 1; j++){
                System.out.print("\t Rp. ");
                System.out.printf(" %d \t",harga[i]);
                System.out.print(" /24 jam");
                System.out.println("\tStock: " + stok[i]);
                }
            }
        } else if(tahun == 2018){
            System.out.printf("%s", data[2]);
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[2]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[2]);
        } else if(tahun == 2019){
            for(int i = 0; i < 2; i++){
            System.out.printf("%s", data[i + 3]);
            for(int j = 0; j < 1; j++){
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[i + 3]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[i + 3]);
            }
        }
        } else{
            System.out.print("Masukkan tahun rilis 2017-2019!");
        }break;
        case 2:
        System.out.print("Masukkan seri IPhone (8-11): ");
        seri = sc.nextInt();
        if(seri == 8){
            System.out.printf("%s", data[0]);
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[0]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[0]);
        } else if(seri == 10){
            for(int i = 0; i < 2; i++){
            System.out.printf("%s", data[i + 1]);
            for(int j = 0; j < 1; j++){
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[i + 1]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[i + 1]);
            }
            }
        } else if(seri == 11){
            for(int i = 0; i < 2; i++){
            System.out.printf("%s", data[i + 3]);
            for(int j = 0; j < 1; j++){
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[i + 3]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[i + 3]);
            }
        }
        } else{
            System.out.print("Mohon maaf, kami tidak menyediakan IPhone seri tersebut.");
        }break;
        case 3:
        System.out.print("Masukkan budget: ");
        budget = sc.nextInt();
        if(budget >= harga[0] && budget >= harga[4]){
            for(int i = 0; i < data.length; i++){
            System.out.printf("%s", data[i]);
            for(int j = 0; j < 1; j++){
                System.out.print("\t Rp. ");
                System.out.printf(" %d \t",harga[i]);
                System.out.print(" /24 jam");
                System.out.print("\tStock: " + stok[i]);
            }
            System.out.println();
        }
        } else if(budget >= harga[0] && budget < harga[1]){
            System.out.printf("%s", data[0]);
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[0]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[0]);
        } else if(budget >= harga[0] && budget < harga[2]){
            for(int i = 0; i < 2; i++){
            System.out.printf("%s", data[i]);
            for(int j = 0; j < 1; j++){
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[i]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[i]);
            }
            }
        } else if(budget >= harga[0] && budget < harga[3]){
            for(int i = 0; i < 3; i++){
            System.out.printf("%s", data[i]);
            for(int j = 0; j < 1; j++){
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[i]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[i]);
            }
            }
        } else if(budget >= harga[0] && budget < harga[4]){
            for(int i = 0; i < 4; i++){
            System.out.printf("%s", data[i]);
            for(int j = 0; j < 1; j++){
            System.out.print("\t Rp. ");
            System.out.printf(" %d \t",harga[i]);
            System.out.print(" /24 jam");
            System.out.println("\tStock: " + stok[i]);
            }
            }
        } else{
            System.out.print("Maaf budget anda belum cukup untuk menyewa IPhone.");
        }break;
    default: System.out.print("Pilih nomor sesuai list!");};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char kembali = 'y';
        int menu;
        do{
            listMenu();
            System.out.print("Masukkan angka menu: ");
            menu = sc.nextInt();
            System.out.println();
            switch(menu){
                case 1:
                System.out.println("===========SELAMAT DATANG DI MENU DATA MASTER============\n");
                dataMaster();
                break;
                case 2:
                System.out.println("============SELAMAT DATANG DI MENU PERSEWAAN=============\n");
                dataMaster();
                persewaan();
                break;
                case 3:
                pengembalian();
                break;
                case 4:
                pencarian();
                break;
                }
                if(menu == 5){
                    nama = null;
                    System.out.println("Anda telah keluar, Terima kasih telah berkunjung");
                    kembali ='T';
                    }
                    else{
                        System.out.print("\n\nKembali ke Menu Utama ? [Y/T] : ");
                        kembali = sc.next().charAt(0);  
                        System.out.println("-----------------------------------------------------------------");
                        }   
                    }

                    while(kembali != 'T');
                }
}