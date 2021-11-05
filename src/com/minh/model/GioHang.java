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
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class GioHang {
	private Date dateGH;
	private Time timeGH;
	private List<SanPham> gioHangSP;
	private boolean trangThai;
	private int index;
	
	public GioHang() {
		index = 0;
		long millis = System.currentTimeMillis();
		dateGH = new Date(millis);
		timeGH = new Time(millis);
		gioHangSP = new ArrayList<>();
		trangThai = false;
	}
	
	public void themSP(SanPham sanPham) {
		gioHangSP.add(sanPham);
	}
	
	public void themSP(int maSP,DanhSachSanPham ds,DanhSachKhachHang kh) {
		if(isTrangThai()) {
			try {
				kh.saveData();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gioHangSP.clear();
			setIndex(index+1);
			setTrangThai(false);
		}
		for(int i = 0; i < ds.getListSP().size(); i++) {
			if(ds.getListSP().get(i).getMaSP() == maSP) {
				if(ds.getListSP().get(i).getSoLuongSP() > 0) {
					SanPham temp = ds.getListSP().get(i);
					if(ds.getListSP().get(i).getLoaiSP().equals("Quan")) {
						SanPham sp = new Quan(temp.getMaSP(), temp.getLoaiSP(), temp.getTenSP(), temp.getMotaSP(),
								temp.getGiaTienSP(), 1, temp.getSizeSP(), temp.getRongTui(), 
								temp.getDaiQuan());
						gioHangSP.add(sp);
					}else {
						SanPham sp = new Ao(temp.getMaSP(), temp.getLoaiSP(), temp.getTenSP(), temp.getMotaSP(),
								temp.getGiaTienSP(), 1, temp.getSizeSP(), temp.getDaiTay(), 
								temp.getVongNguc(),temp.getVongEo(),temp.getVongMong());
						gioHangSP.add(sp);
					}
					return;
				}else {
					System.out.println("San Pham Het Hang");
					return;
				}
			}
		}
		System.out.println("San Pham Khong Ton Tai");
	}
	
	public void xoaSP(int maSP) {
		for(int i = 0; i < gioHangSP.size(); i++) {
			if(gioHangSP.get(i).getMaSP() == maSP) {
				gioHangSP.remove(i);
				return;
			}
		}
		System.out.println("San Pham Khong Ton Tai");
	}
	
	public void inThongTinGioHang() {
		for(SanPham sp: gioHangSP) {
			System.out.println(sp.inThongTinSP());
		}
	}
	
	public long tongTienGioHang() {
		long tong = 0;
		for(SanPham sp: gioHangSP) {
			tong += sp.getGiaTienSP();
		}
		return tong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	public void thanhToanGioHang(DanhSachSanPham ds) {
		for(int i = 0; i < gioHangSP.size(); i++) {
			System.out.println(gioHangSP.get(i).inThongTinSP());
			for(int j = 0; j < ds.getListSP().size(); j++) {
				if(gioHangSP.get(i).getMaSP() == ds.getListSP().get(j).getMaSP()) {
					ds.getListSP().get(j).setSoLuongSP(ds.getListSP().get(j).getSoLuongSP()-1);
					break;
				}
			}
		}
		long mills = System.currentTimeMillis();
		setDateGH(new Date(mills));
		setTimeGH(new Time(mills));
		System.out.println("Thanh toan thanh cong");
		setTrangThai(true);
	}
	
	public Date getDateGH() {
		return dateGH;
	}

	public void setDateGH(Date dateGH) {
		this.dateGH = dateGH;
	}

	public Time getTimeGH() {
		return timeGH;
	}

	public void setTimeGH(Time timeGH) {
		this.timeGH = timeGH;
	}

	public void getGioHangFromFile(String url) throws IOException{
		File file = new File(url);
		file.createNewFile();
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		int indexTemp = -1;
		String line = "";
		while((line = reader.readLine()) != null) {
			String[] itemInLine = line.split(" ");
			if(itemInLine[0].charAt(0) == '$') {
				gioHangSP.clear();
				String index0 = "";
				for(int i=1; i < itemInLine[0].length(); i++) {
					index0 += Character.toString(itemInLine[0].charAt(i));
				}
				indexTemp = Integer.parseInt(index0);
				setDateGH(Date.valueOf(itemInLine[1]));
				setTimeGH(Time.valueOf(itemInLine[2]));
				setIndex(indexTemp);
				if(itemInLine[3].equals("da_thanh_toan")) {
					setTrangThai(true);
				}else {
					setTrangThai(false);
				}
			}else {
				if(itemInLine[1].equals("Quan")) {
					SanPham sp = new Quan(Integer.parseInt(itemInLine[0]), itemInLine[1], itemInLine[2], itemInLine[3], 
							Long.parseLong(itemInLine[4]), Integer.parseInt(itemInLine[5]), itemInLine[6], 
							Integer.parseInt(itemInLine[7]), Integer.parseInt(itemInLine[8]));
					gioHangSP.add(sp);
				}else {
					SanPham sp = new Ao(Integer.parseInt(itemInLine[0]), itemInLine[1], itemInLine[2], itemInLine[3], 
							Long.parseLong(itemInLine[4]), Integer.parseInt(itemInLine[5]), itemInLine[6], Integer.parseInt(itemInLine[7]),
							Integer.parseInt(itemInLine[8]),Integer.parseInt(itemInLine[9]),Integer.parseInt(itemInLine[10]));
					gioHangSP.add(sp);
				}
			}
		}
		reader.close();
	}
	
	public String infoGioHangToFile() {
		String trangThai = "";
		if(isTrangThai()) {
			trangThai = "da_thanh_toan";
		}else {
			trangThai = "chua_thanh_toan";
		}
		trangThai = "$"+String.valueOf(index)+" "+getDateGH().toString()+" "+getTimeGH().toString()+" "+trangThai+"\n";
		for(int i = 0; i < gioHangSP.size(); i++) {
			trangThai += gioHangSP.get(i).inThongTinSP()+"\n";
		}
		return trangThai;
	}
	
	public String saveData(String owner) throws IOException {
		String path = System.getProperty("user.dir")+"\\"+owner+".txt";
		File file = new File(path);
		file.createNewFile();
		
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		String data = "";
		String temp = "";
		while((temp = reader.readLine()) != null) {
			String[] s = temp.split(" ");
			if(s[0].charAt(0) == '$') {
				String index0 = "";
				for(int i=1; i < s[0].length(); i++) {
					index0 += Character.toString(s[0].charAt(i));
				}
				if(getIndex() > Integer.parseInt(index0)) {
					data += temp+"\r";
				}else {
					break;
				}
			}else {
				data += temp+"\r";
			}
		}
		reader.close();
		
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream);
		
		writer.write(data);
		writer.write(infoGioHangToFile());
		writer.close();
		return path;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
