package com.minh.model;

public class SanPham {
	private int maSP;
	private String loaiSP;
	private String tenSP;
	private String motaSP;
	private long giaTienSP;
	private int soLuongSP;
	private String sizeSP;
	
	public SanPham(int maSP, String loaiSP, String tenSP, String motaSP, long giaTienSP, int soLuongSP, String sizeSP) {
		this.maSP = maSP;
		this.loaiSP = loaiSP;
		this.tenSP = tenSP;
		this.motaSP = motaSP;
		this.giaTienSP = giaTienSP;
		this.soLuongSP = soLuongSP;
		this.sizeSP = sizeSP;
	}

	public SanPham() {
		// TODO Auto-generated constructor stub
	}
	

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public String getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getMotaSP() {
		return motaSP;
	}

	public void setMotaSP(String motaSP) {
		this.motaSP = motaSP;
	}

	public long getGiaTienSP() {
		return giaTienSP;
	}

	public void setGiaTienSP(long giaTienSP) {
		this.giaTienSP = giaTienSP;
	}

	public String getSizeSP() {
		return sizeSP;
	}

	public void setSizeSP(String sizeSP) {
		this.sizeSP = sizeSP;
	}
	
	public int getSoLuongSP() {
		return soLuongSP;
	}

	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}

	public String inThongTinSP() {
		return this.getMaSP()+" "+this.getLoaiSP()+" "+this.getTenSP()+" "+this.getMotaSP()+" "
				+this.getGiaTienSP()+" "+this.getSoLuongSP()+" "+this.getSizeSP()+" ";
	}
	
	public void update() {}
	
	public int getRongTui() { return 0;}
	public int getDaiQuan() { return 0;}
	public int getDaiTay() { return 0;}
	public int getVongNguc() { return 0;}
	public int getVongEo() { return 0;}
	public int getVongMong() { return 0;}
}
