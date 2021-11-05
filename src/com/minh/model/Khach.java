package com.minh.model;

public class Khach {
	private String hoTenKH;
	private String sdtKH;
	private String diaChiKH;
	private String emailKH;
	private GioHang gioHang;
	
	
	public Khach(String hoTenKH, String sdtKH, String diaChiKH, String emailKH, GioHang gioHang) {
		this.hoTenKH = hoTenKH;
		this.sdtKH = sdtKH;
		this.diaChiKH = diaChiKH;
		this.emailKH = emailKH;
		this.gioHang = gioHang;
	}
	
	public Khach() {
		// TODO Auto-generated constructor stub
	}

	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getSdtKH() {
		return sdtKH;
	}
	public void setSdtKH(String sdtKH) {
		this.sdtKH = sdtKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public String getEmailKH() {
		return emailKH;
	}
	public void setEmailKH(String emailKH) {
		this.emailKH = emailKH;
	}
	public GioHang getGioHang() {
		return gioHang;
	}
	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}
	
	public String inThongTin() {
		return getHoTenKH()+" "+getSdtKH()+" "+getDiaChiKH()+" "+getEmailKH();
	}
}
