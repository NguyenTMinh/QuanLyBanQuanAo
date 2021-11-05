package com.minh.model;

import java.util.Scanner;

public class Quan extends SanPham{
	private int rongTui;
	private int daiQuan;
	
	public Quan() {}

	public Quan(int maSP, String loaiSP, String tenSP, String motaSP, long giaTienSP, int soLuongSP, String sizeSP,
			int rongTui, int daiQuan) {
		super(maSP, loaiSP, tenSP, motaSP, giaTienSP, soLuongSP, sizeSP);
		this.rongTui = rongTui;
		this.daiQuan = daiQuan;
	}

	@Override
	public int getRongTui() {
		return rongTui;
	}

	public void setRongTui(int rongTui) {
		this.rongTui = rongTui;
	}

	@Override
	public int getDaiQuan() {
		return daiQuan;
	}

	public void setDaiQuan(int daiQuan) {
		this.daiQuan = daiQuan;
	}
	
	@Override
	public String inThongTinSP(){
		return super.inThongTinSP() + this.getRongTui()+" "+this.getDaiQuan();
	}
	
	@Override
	public void update() {
		Scanner sc = new Scanner(System.in);
		String keyCheck = "y";
		String keyOption;
		do {
			System.out.println("Chon thong tin muon chinh sua: ");
			System.out.println("1. Ten San Pham");
			System.out.println("2. Mo Ta San Pham");
			System.out.println("3. Gia Tien");
			System.out.println("4. So Luong");
			System.out.println("5. Size San Pham");
			System.out.println("6. Rong Tui");
			System.out.println("7. Dai Quan");
			System.out.println("8. Quay Lai");
			keyOption = sc.nextLine();
			if(keyOption.equals("8")){
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
					setRongTui(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				case "7":{
					System.out.print("nhap thong tin can sua: ");
					setDaiQuan(sc.nextInt());
					sc.nextLine();
					System.out.println("Chinh sua thanh cong");
					break;
				}
				}
			}
		}while(keyCheck.equals("y"));
	}
}
