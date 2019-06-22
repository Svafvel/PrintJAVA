import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

public class one {

	public static void main(String[] args){

		JFrame window = new JFrame();

		// LEFT

		JLabel NIM = new JLabel("NIM");
		JTextField TFNIM = new JTextField();
		
		JLabel NamaMahasiswa = new JLabel("Nama Mahasiswa");
		JTextField TFNamaMahasiswa = new JTextField();
		
		JLabel JenisKelamin = new JLabel("Jenis Kelamin");
		JRadioButton LakiLaki = new JRadioButton();
		JRadioButton Perempuan = new JRadioButton();

		LakiLaki.setActionCommand("Laki-Laki");
		Perempuan.setActionCommand("Perempuan");

		ButtonGroup BG = new ButtonGroup();
		BG.add(LakiLaki);
		BG.add(Perempuan);



		String[] DataHari = new String[31];
		String[] DataBulan = {"Pilih Bulan","January", "February", "Maret", "April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
		String[] DataTahun = new String[31];
		String[] DataJurusan = {"Pilih Jurusan","Akutansi Perkantoran","Bisnis Manajement","Informatika Komputer", "Teknik Infomatika","Sekertaris"};
		String[] DataTingkat = {"Pilih Tingkatan","Satu/I","Dua/II","Tiga/III","Empat/IV"};

		for (int x = 0; x < DataHari.length; x++){
			
			int z = x + 1;
			int i = 1990 + x;
			DataHari[x] = String.valueOf(z);
			DataTahun[x] = String.valueOf(i);

		}

		JLabel TanggalLahir = new JLabel("Tanggal Lahir");
		JComboBox Hari = new JComboBox(DataHari);
		JComboBox Bulan = new JComboBox(DataBulan);
		JComboBox Tahun = new JComboBox(DataTahun);

		JLabel Jurusan = new JLabel("Jurusan");
		JComboBox jurusan = new JComboBox(DataJurusan);

		JLabel Tingkat = new JLabel("Tingkat");
		JComboBox tingkat = new JComboBox(DataTingkat);

		JLabel Keterangan = new JLabel("Keterangan");
		JTextArea TAKeterangan = new JTextArea();

		JButton Tambah = new JButton("Tambah");

		// AKHIR LEFT

		// RIGHT

		JTextArea Hasil = new JTextArea();

		JButton Cetak = new JButton("Cetak");

		// AKHIR RIGHT

		// FUCNTION

		Tambah.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

				JenisKelamin.setText(BG.getSelection().getActionCommand());
				String GetNIM = TFNIM.getText();
				String GetNamaMahasiswa = TFNamaMahasiswa.getText();
				String GetKeterangan = TAKeterangan.getText();
				String GetTanggalLahir = Hari.getSelectedItem() + "-" + Bulan.getSelectedItem() + "-" + Tahun.getSelectedItem();
				String J = jurusan.getSelectedItem().toString();
				String T = tingkat.getSelectedItem().toString();

				Hasil.setText(
				"	Surat Keterangan Tidak Mengikuti Pelajaran" +
				"\n\n" + "  Dengan Bertanda Di Bawah Ini :" +
				"\n\n" + "  NIM		:  " + GetNIM + 
				"\n\n" + "  Nama Mahasiswa	:  " + GetNamaMahasiswa +
				"\n\n" + "  Jenis Kelamin		:  " + BG.getSelection().getActionCommand() +
				"\n\n" + "  Tanggal Lahir		:  " + GetTanggalLahir +
				"\n\n" + "  Jurusan		:  " + J +
				"\n\n" + "  Tingkat		:  " + T +
				"\n\n" + "  Dengan Keterangan sebagai Berikut	: " +
				"\n\n" + "  " + GetKeterangan);

            }

		});

		Cetak.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

				try {

					Hasil.print();

				}catch (PrinterException ex){

					JOptionPane.showMessageDialog(null,ex);

				}

            }

		});

	

		// AKHIR FUCNTION

		window.setTitle("Surat Keterangan IJIN");

		window.setSize(1000,500); // width, height

		// Membuat Frame Berada ditengah ketika dijalankan

		window.setLocationRelativeTo(null);

		// Mengaktifkan event ketika tombol close diklik program akan terhenti

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menentukan Layout Frame

		window.setLayout(null);

		// Memasukan Label Ke Dalam Frame

		window.add(NIM);
		window.add(TFNIM);

		window.add(NamaMahasiswa);
		window.add(TFNamaMahasiswa);
		
		window.add(JenisKelamin);
		window.add(LakiLaki);
		window.add(Perempuan);

		window.add(TanggalLahir);
		window.add(Hari);
		window.add(Bulan);
		window.add(Tahun);

		window.add(Jurusan);
		window.add(jurusan);

		window.add(Tingkat);
		window.add(tingkat);


		window.add(Keterangan);
		window.add(TAKeterangan);

		window.add(Tambah);

		window.add(Hasil);

		window.add(Cetak);

		// Menentukan Posisi Label Di Dalam Frame , Menentukan Width dan Heightnya Juga

		NIM.setBounds(80,20,150,30); // Posisi X (kiri/kanan), Y (atas/bawah) , Width, Height
		TFNIM.setBounds(220, 20, 200, 30);

		NamaMahasiswa.setBounds(80,60,150,30); // Posisi X (kiri/kanan), Y (atas/bawah), Width, Height
		TFNamaMahasiswa.setBounds(220, 60, 200, 30);
		
		JenisKelamin.setBounds(80,100,120,30);

		LakiLaki.setBounds(215,100,100,30);
		LakiLaki.setText("Laki-Laki");

		Perempuan.setBounds(315, 100, 150,30);
		Perempuan.setText("Perempuan");


		TanggalLahir.setBounds(80,140,150,30);
		Hari.setBounds(220,140,50,30);
		Bulan.setBounds(275,140,80,30);
		Tahun.setBounds(360,140,60,30);

		Jurusan.setBounds(80,180,150,30);
		jurusan.setBounds(220, 180, 200, 30);

		Tingkat.setBounds(80,220,150,30);
		tingkat.setBounds(220, 220, 200, 30);

		Keterangan.setBounds(80,260,150,30);
		TAKeterangan.setBounds(80, 300, 350, 100);

		Tambah.setBounds(210,420, 100, 30);

		Hasil.setBounds(500,20,430,380);

		Cetak.setBounds(700,420, 80, 30);

		window.setVisible(true); // Menampilkan GUI

	}

}