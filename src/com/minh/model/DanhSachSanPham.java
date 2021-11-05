package com.minh.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachSanPham {
	private static final String path = System.getProperty("user.dir")+"\\listSanPham.txt";
	private List<SanPham> listSP;
	
	public DanhSachSanPham() {
		listSP = new ArrayList<>();
		try {
			scanData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void scanData() throws IOException{
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String line = "";
		while((line = bufferedReader.readLine()) != null) {
			String[] infos = line.split(" ");
			if(infos[1].equals("Quan")) {
				SanPham sanPham = new Quan(Integer.parseInt(infos[0]), infos[1], infos[2], infos[3], Long.parseLong(infos[4]), 
						Integer.parseInt(infos[5]), infos[6], Integer.parseInt(infos[7]), Integer.parseInt(infos[8]));
				listSP.add(sanPham);
			}else {
				SanPham sanPham = new Ao(Integer.parseInt(infos[0]), infos[1], infos[2], infos[3], Long.parseLong(infos[4]), 
						Integer.parseInt(infos[5]), infos[6], Integer.parseInt(infos[7]), Integer.parseInt(infos[8]),
						Integer.parseInt(infos[9]), Integer.parseInt(infos[10]));
				listSP.add(sanPham);
			}
		}
		bufferedReader.close();
	}
	
	public void saveData() throws IOException{
		File file = new File(path);
		file.createNewFile();
		OutputStream fileOutputStream = new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		
		for(SanPham sp: listSP) {
			outputStreamWriter.write(sp.inThongTinSP()+"\n");
		}
		outputStreamWriter.flush();
		outputStreamWriter.close();
	}

	public List<SanPham> getListSP() {
		return listSP;
	}

	public void themSanPham() {
		Scanner read = new Scanner(System.in);
		SanPham sanPham = new SanPham();
		System.out.print("Nhap ma san pham: ");
		int maSP = read.nextInt();
		read.nextLine();
		System.out.print("Nhap loai san pham: ");
		String loaiSP = read.nextLine();
		if(loaiSP.equals("Quan")) {
			Quan quan = new Quan();
			quan.setMaSP(maSP);
			quan.setLoaiSP(loaiSP);
			System.out.print("Nhap ten san pham: ");
			quan.setTenSP(read.nextLine());
			System.out.print("Nhap mo ta san pham: ");
			quan.setMotaSP(read.nextLine());
			System.out.print("Nhap gia tien san pham: ");
			quan.setGiaTienSP(read.nextLong());
			read.nextLine();
			System.out.print("Nhap so luong san pham: ");
			quan.setSoLuongSP(read.nextInt());
			read.nextLine();
			System.out.print("Nhap size san pham: ");
			quan.setSizeSP(read.next());
			System.out.print("Nhap do rong tui: ");
			quan.setRongTui(read.nextInt());
			read.nextLine();
			System.out.print("Nhap do dai quan: ");
			quan.setDaiQuan(read.nextInt());
			read.nextLine();
			sanPham = quan;
		}else {
			Ao ao = new Ao();
			ao.setMaSP(maSP);
			ao.setLoaiSP(loaiSP);
			System.out.print("Nhap ten san pham: ");
			ao.setTenSP(read.nextLine());
			System.out.print("Nhap mo ta san pham: ");
			ao.setMotaSP(read.nextLine());
			System.out.print("Nhap gia tien san pham: ");
			ao.setGiaTienSP(read.nextLong());
			read.nextLine();
			System.out.print("Nhap so luong san pham: ");
			ao.setSoLuongSP(read.nextInt());
			read.nextLine();
			System.out.print("Nhap size san pham: ");
			ao.setSizeSP(read.next());
			System.out.print("Nhap do dai tay: ");
			ao.setDaiTay(read.nextInt());
			read.nextLine();
			System.out.print("Nhap vong nguc: ");
			ao.setVongNguc(read.nextInt());
			read.nextLine();
			System.out.print("Nhap vong eo: ");
			ao.setVongEo(read.nextInt());
			read.nextLine();
			System.out.print("Nhap vong mong: ");
			ao.setVongMong(read.nextInt());
			read.nextLine();
			sanPham = ao;
		}
		listSP.add(sanPham);
	}
	
	public void xoaSanPham(int maSP) {
		for(int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getMaSP() == maSP) {
				listSP.remove(i);
				return;
			}
		}
		System.out.println("San Pham Khong Ton Tai");
	}
	
	public void chinhSuaSP(int maSP) {
		for(int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getMaSP() == maSP) {
				listSP.get(i).update();
				return;
			}
		}
		System.out.println("San Pham Khong Ton Tai");
	}
	
	public void xemDanhSach() {
		hienThiListTimKiem(listSP);
	}
	
	public List<SanPham> timKiemSP(int maSP) {
		List<SanPham> list = new ArrayList<>();
		for(int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getMaSP() == maSP) {
				list.add(listSP.get(i));
			}
		}
		return list;
	}
	
	public List<SanPham> timKiemSP(String  tenSP) {
		List<SanPham> list = new ArrayList<>();
		for(int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getTenSP().equals(tenSP)) {
				list.add(listSP.get(i));
			}else if(listSP.get(i).getLoaiSP().equals(tenSP)) {
				list.add(listSP.get(i));
			}
		}
		return list;
	}
	
	public List<SanPham> timKiemSP(long giaSP) {
		List<SanPham> list = new ArrayList<>();
		for(int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getGiaTienSP() == giaSP) {
				list.add(listSP.get(i));
			}
		}
		return list;
	}
	
	
	public void hienThiListTimKiem(List<SanPham> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getLoaiSP().equals("Quan")) {
				System.out.println("MaSP\tLoaiSP\tTenSP\tMotaSP\tGiaTien\tSoLuong\tSize\tRongTui\tDaiQuan");
				System.out.println(list.get(i).inThongTinSP());
			}else {
				System.out.println("MaSP\tLoaiSP\tTenSP\tMotaSP\tGiaTien\tSoLuong\tSize\tDaitay\tVongnguc\tVongEo\tVongMong");
				System.out.println(list.get(i).inThongTinSP());
			}
		}
	}
}
