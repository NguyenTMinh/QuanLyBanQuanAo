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

public class DanhSachKhachHang {
	private static final String path = System.getProperty("user.dir")+"\\listKhachHang.txt";
	private List<Khach> listKH;
	
	public DanhSachKhachHang() {
		listKH = new ArrayList<>();
		try {
			scanData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void scanData() throws IOException{
		// TODO Auto-generated method stub
		File file = new File(path);
		file.createNewFile();
		
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String line = "";
		while((line = bufferedReader.readLine()) != null) {
			String[] infos = line.split(" ");
			GioHang gioHang = new GioHang();
			gioHang.getGioHangFromFile(infos[4]);
			Khach khach = new Khach(infos[0], infos[1], infos[2], infos[3], gioHang);
			if(khach.getGioHang().isTrangThai()) {
				int index = khach.getGioHang().getIndex();
				khach.setGioHang(new GioHang());
				khach.getGioHang().setIndex(index+1);
			}
			listKH.add(khach);
		}
		bufferedReader.close();
	}
	
	public void saveData() throws IOException{
		File file = new File(path);
		file.createNewFile();
		OutputStream fileOutputStream = new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		
		for(Khach kh: listKH) {
			outputStreamWriter.write(kh.inThongTin()+" "+kh.getGioHang().saveData(kh.getHoTenKH())+"\n");
		}
		outputStreamWriter.flush();
		outputStreamWriter.close();
	}

	public List<Khach> getListKH() {
		return listKH;
	}	
	
	public List<Khach> timKiemKH(String chuoi){
		List<Khach> list = new ArrayList<>();
		for(int i = 0; i < listKH.size(); i++) {
			if(listKH.get(i).getHoTenKH().equals(chuoi)) {
				list.add(listKH.get(i));
			}else if(listKH.get(i).getSdtKH().equals(chuoi)) {
				list.add(listKH.get(i));
			}
		}
		return list;
	}
	
	public int timKiemKHDangNhap(String hotenKH, String sdtKH){
		for(int i = 0; i < listKH.size(); i++) {
			if(listKH.get(i).getHoTenKH().equals(hotenKH) && listKH.get(i).getSdtKH().equals(sdtKH)) {
				return i;
			}
		}
		return -1;
	}
	
	public void hienThiListTimKiem(List<Khach> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).inThongTin());
		}
	}
	
	public void themKhachHang() {
		Scanner sc = new Scanner(System.in);
		Khach khach = new Khach();
		System.out.print("Nhap ho ten: ");
		khach.setHoTenKH(sc.nextLine());
		System.out.print("Nhap so dien thoai: ");
		khach.setSdtKH(sc.nextLine());
		System.out.print("Nhap dia chi: ");
		khach.setDiaChiKH(sc.nextLine());
		System.out.print("Nhap email: ");
		khach.setEmailKH(sc.nextLine());
		khach.setGioHang(new GioHang());
		listKH.add(khach);
	}
}
