package com.minh.model;

import java.util.Scanner;

public class Ao extends SanPham{
	private int daiTay;
	private int vongNguc;
	private int vongEo;
	private int vongMong;
	

	public Ao(int maSP, String loaiSP, String tenSP, String motaSP, long giaTienSP, int soLuongSP, String sizeSP,
			int daiTay, int vongNguc, int vongEo, int vongMong) {
		super(maSP, loaiSP, tenSP, motaSP, giaTienSP, soLuongSP, sizeSP);
		this.daiTay = daiTay;
		this.vongNguc = vongNguc;
		this.vongEo = vongEo;
		this.vongMong = vongMong;
	}

	public Ao() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int getDaiTay() {
		return daiTay;
	}

	
	public void setDaiTay(int daiTay) {
		this.daiTay = daiTay;
	}

	@Override
	public int getVongNguc() {
		return vongNguc;
	}

	public void setVongNguc(int vongNguc) {
		this.vongNguc = vongNguc;
	}

	@Override
	public int getVongEo() {
		return vongEo;
	}

	public void setVongEo(int vongEo) {
		this.vongEo = vongEo;
	}

	@Override
	public int getVongMong() {
		return vongMong;
	}

	public void setVongMong(int vongMong) {
		this.vongMong = vongMong;
	}
	
	@Override
	public String inThongTinSP() {
		return super.inThongTinSP()+this.getDaiTay()+" "+this.getVongNguc()+" "+this.getVongEo()+" "+this.getVongMong();
	}
	
	@Override
	public void update() {
		Scanner sc = new Scanner(System.in);
		String keyCheck = "y";
		String keyOption;
		do {
			System.out.println("Chon thong tin muon chinh sua: ");
			System.out.println("[1]. Ten San Pham");
			System.out.println("[2]. Mo Ta San Pham");
			System.out.println("[3]. Gia Tien");
			System.out.println("[4]. So Luong");
			System.out.println("[5]. Size San Pham");
			System.out.println("[6]. Dai Tay");
			System.out.println("[7]. Vong Nguc");
			System.out.println("[8]. Vong Eo");
			System.out.println("[9]. Vong Mong");
			System.out.println("[10]. Quay Lai");
			keyOption = sc.nextLine();
			if(keyOption.equals("10")){
				keyCheck = "n";
			}else {
				switch(keyOption) {
				case "1":{
					System.out.print("nhap thong tin can sua: ");
					setTenSP(sc.nextLine());
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "2":{
					System.out.print("nhap thong tin can sua: ");
					setMotaSP(sc.nextLine());
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "3":{
					System.out.print("nhap thong tin can sua: ");
					setGiaTienSP(sc.nextLong());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "4":{
					System.out.print("nhap thong tin can sua: ");
					setSoLuongSP(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "5":{
					System.out.print("nhap thong tin can sua: ");
					setSizeSP(sc.nextLine());
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "6":{
					System.out.print("nhap thong tin can sua: ");
					setDaiTay(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "7":{
					System.out.print("nhap thong tin can sua: ");
					setVongNguc(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "8":{
					System.out.print("nhap thong tin can sua: ");
					setVongEo(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "9":{
					System.out.print("nhap thong tin can sua: ");
					setVongMong(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				}
			}
		}while(keyCheck.equals("y"));
	}
}
