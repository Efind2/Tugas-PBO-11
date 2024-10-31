# JasperReport
Hallo Semua 😄👋 Pada Tugas Pemograman Berorientasi Objek ini, saya menerapkan program CRUD (Create, Read, Update, Delete) pada java GUI(Graphical User Interfaces) dan juga penggunaan jasper report dengan IDE netbeans. Untuk mengimplementasikan program tersebut saya menggunakan bahasa pemrograman java dan menggunakan aplikasi pengelola database yaitu postgreSQL dan juga plugin iReport.
dan saya menggunakan tabel  entitas Matakuliah dengan atribut Kode MK, SKS, NamaMk, Semester Ajar.
## Aplikasi
- IDE NetBeans 16
- PostgreSql
- Java Development Kit 11
## Plugin
- [IReport 5.6.0](https://drive.google.com/drive/folders/1gbbMttGeyns5mqb-_hfIAuMjkTzb-XPZ?usp=sharing)
## Library
- PostgreSQL JDBC Driver
- [JasperReport](https://drive.google.com/drive/folders/1_i8xBCdLXeMcGdmnTWa2SEnL4oc2sW78?usp=sharing)

## Cara Instalasi 
Install Plugin Ireport di IDE Netbeans dengan mencari menu tools > plugins > donload > add plugins . Tambahkan plugins ireport yang ada di dalam folder yang memiliki tipe file nbm jika tterjadi error install dulu `org-jdeskop-layout-realese.nbm` kemudian baru instal file nbm yang ada didalam folder ireport
## Membuat File jasper
Klik kiri pada package project anda kemudian new > cari report wizard jika belum ada klik other pilih report wizard ![Cuplikan layar 2024-10-26 220058](https://github.com/user-attachments/assets/e4b2bb54-2e9c-4253-8e91-ebbe55364533) 
Kemudain next pilih layout kemudain sesuaikan nama file jasper dengan apa yang anda inginkan kemudian sambungkan query database disini saya menggunkan database Mahasiswa dengan SQL Query `SELECT * FROM mahasiswa` ![image](https://github.com/user-attachments/assets/eae7b901-3c6a-41ce-a468-80a2c77e999c)
kemudian next pindah seluruh kolom ke kiri dan next lagi --finish.
Setelah File jadi anda bisa membuat tampilan layout anda sesuka hati, namun layout anda harus berisi tabel yang ingin anda tampilkan atau cetak
![image](https://github.com/user-attachments/assets/7fd7d5f1-db54-43d7-bdac-57ac60bf4a10)

## Cara Penggunaan
Buat java frame yang berisi program untuk CRUD (create, read, update, delete)  dan juga Cetak untuk menjalankan jasperReport kemudian hubungkan Netbeans dengan database di PostgreSql dan juga tambahkan liblary di projeck yang digunakan. tambahkan kode dibawah ini pada button cetak
     
      try {
            // TODO add your handling code here:
            conn = DriverManager.getConnection(koneksi, user, password);
            String sql = "select * from matakuliah";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            File alamat = new File(".");
            System.out.println(alamat.getCanonicalPath());
            
            File jasperFile = new File(alamat.getCanonicalPath() + "/src/yourfolder/" + "yourfile.jrxml");
            JasperDesign jd = JRXmlLoader.load(jasperFile);
            JRResultSetDataSource jds = new JRResultSetDataSource(rs);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, new HashMap<String, Object>(), jds);
            JasperViewer.viewReport(jp);
        } catch (SQLException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        }
  
Saat button cetak di klik maka tampilan jasper report akan muncul seperti ini
![image](https://github.com/user-attachments/assets/296fe027-e2af-4527-bba7-4511b176a7b2)

mungkin itu saya yang dapat saya jelaskan mengenai jasper report pesan saya pakai aplikasi yang kompetible dengan ireport 5.6.0



