package com.minh.thread;

import java.io.IOException;
import java.util.Scanner;

import com.minh.model.DanhSachKhachHang;
import com.minh.model.DanhSachSanPham;
import com.minh.model.Khach;

public class MainThread {
	private int vaiTro;
	private DanhSachSanPham danhSachSanPham;
	private DanhSachKhachHang danhSachKhachHang;
	Scanner sc = new Scanner(System.in);
	
	public MainThread() {
		vaiTro = 1;
		danhSachKhachHang = new DanhSachKhachHang();
		danhSachSanPham = new DanhSachSanPham();
	}
	
	public void run() throws IOException{
		do {
			System.out.println("Chuong trinh quan ly/mua sam");
			System.out.println("[0]. Bat dau chuong trinh voi tu cach Nguoi Quan Ly.");
			System.out.println("[1]. Bat dau chuong trinh voi tu cach Khach Hang.");
			System.out.println("[2]. Ket thuc chuong trinh");
			System.out.println("----------------------------------------------------");
			vaiTro = sc.nextInt();
			sc.nextLine();
			
			if(vaiTro == 0) {
				threadQuanLy();
			}else if(vaiTro == 1) {
				threadKhachHang();
			}
		}while(vaiTro!=2);
		
		danhSachSanPham.saveData();
		danhSachKhachHang.saveData();
		
		System.out.println("-----------------------");
		System.out.println("|KET THUC CHUONG TRINH|");
		System.out.println("-----------------------");
	}

	private void threadKhachHang() {
		System.out.print("Nhap ten Ho ten:");
		String hotenKH = sc.nextLine();
		System.out.print("Nhap so dien thoai:");
		String sdtKH = sc.nextLine();
		int index = danhSachKhachHang.timKiemKHDangNhap(hotenKH, sdtKH);
		if( index == -1) {
			System.out.println("Ban chua co trong he thong, vui long hoan thien thong tin de dang nhap:");
			danhSachKhachHang.themKhachHang();
			index = danhSachKhachHang.getListKH().size() - 1;
		}
		Khach khach = danhSachKhachHang.getListKH().get(index);
		String name = danhSachKhachHang.getListKH().get(index).getHoTenKH();
		int keyOption;
		do {
			int keyCont = 1;
			System.out.println("Khach Hang: "+ name);
			System.out.println("[0]. Xem danh sach san pham");
			System.out.println("[1]. Tim kiem san pham theo ten san pham");
			System.out.println("[2]. Tim kiem san pham theo loai san pham");
			System.out.println("[3]. Them san pham vao gio hang");
			System.out.println("[4]. Thanh toan gio hang");
			System.out.println("[5]. Quay lai");
			System.out.println("------------------------------------------");
			System.out.print("Chon chuc nang: ");
			keyOption = sc.nextInt();
			sc.nextLine();
			switch(keyOption) {
			case 0:{
				danhSachSanPham.xemDanhSach();
				break;
			}
			case 1:{
				System.out.print("Nhap ten san pham: ");
				String tenSP = sc.nextLine();
				if(danhSachSanPham.timKiemSP(tenSP).size()>0)
					danhSachSanPham.hienThiListTimKiem(danhSachSanPham.timKiemSP(tenSP));
				else
					System.out.println("San pham khong ton tai");
				break;
			}
			case 2:{
				System.out.print("Nhap loai san pham: ");
				String loaiSP = sc.nextLine();
				if(danhSachSanPham.timKiemSP(loaiSP).size()>0)
					danhSachSanPham.hienThiListTimKiem(danhSachSanPham.timKiemSP(loaiSP));
				else
					System.out.println("San pham khong ton tai");
				break;
			}
			case 3:{
				System.out.print("Nhap ma san pham them vao gio: ");
				int maSP = sc.nextInt();
				sc.nextLine();
				khach.getGioHang().themSP(maSP, danhSachSanPham,danhSachKhachHang);
				break;
			}
			case 4:{
				khach.getGioHang().thanhToanGioHang(danhSachSanPham);
				break;
			}
			}
			System.out.print("Bam 0 de tiep tuc: ");
			while(keyCont!=0) {
				keyCont = sc.nextInt();
				sc.nextLine();
			}
		}while(keyOption != 5);
		danhSachKhachHang.getListKH().set(index, khach);
	}

	private void threadQuanLy() {
		int keyCheckQL;
		do {
			int keyCont = 1;
			System.out.println("[0]. Xem danh sach san pham");
			System.out.println("[1]. Them moi thong tin san pham");
			System.out.println("[2]. Xoa thong tin san pham");
			System.out.println("[3]. Chinh sua thong tin san pham");
			System.out.println("[4]. Tim kiem thong tin san pham");
			System.out.println("[5]. Tim kiem thong tin khach hang");
			System.out.println("[6]. Quay lai");
			System.out.println("---------------------------------------");
			System.out.print("Chon chuc nang: ");
			keyCheckQL = sc.nextInt();
			sc.nextLine();
			switch(keyCheckQL) {
			case 0:{
				danhSachSanPham.xemDanhSach();
				break;
			}
			case 1:{
				danhSachSanPham.themSanPham();
				break;
			}
			case 2:{
				System.out.print("Nhap ma san pham can xoa: ");
				int maSP = sc.nextInt();
				sc.nextLine();
				danhSachSanPham.xoaSanPham(maSP);
				break;
			}
			case 3:{
				System.out.print("Nhap ma san pham can chinh sua: ");
				int maSP = sc.nextInt();
				sc.nextLine();
				danhSachSanPham.chinhSuaSP(maSP);
				break;
			}
			case 4:{
				int keyTK;
				do {
					int keyCont1 = 1;
					System.out.println("Tim kiem theo:");
					System.out.println("[0]. ma san pham");
					System.out.println("[1]. ten san pham");
					System.out.println("[2]. gia tien san pham");
					System.out.println("[3]. quay lai");
					keyTK = sc.nextInt();
					sc.nextLine();
					switch(keyTK) {
					case 0:{
						System.out.print("Nhap ma san pham: ");
						int maSP = sc.nextInt();
						sc.nextLine();
						if(danhSachSanPham.timKiemSP(maSP).size()>0)
							danhSachSanPham.hienThiListTimKiem(danhSachSanPham.timKiemSP(maSP));
						else
							System.out.println("San pham khong ton tai");
						break;
					}
					case 1:{
						System.out.print("Nhap ten san pham: ");
						String tenSP = sc.nextLine();
						if(danhSachSanPham.timKiemSP(tenSP).size()>0)
							danhSachSanPham.hienThiListTimKiem(danhSachSanPham.timKiemSP(tenSP));
						else
							System.out.println("San pham khong ton tai");
						break;
					}
					case 2:{
						System.out.print("Nhap gia tien san pham: ");
						long giaSP = sc.nextLong();
						sc.nextLine();
						if(danhSachSanPham.timKiemSP(giaSP).size()>0)
							danhSachSanPham.hienThiListTimKiem(danhSachSanPham.timKiemSP(giaSP));
						else
							System.out.println("San pham khong ton tai");
						break;
					}
					}
					System.out.print("Bam 0 de tiep tuc: ");
					while(keyCont1!=0) {keyCont1 = sc.nextInt(); sc.nextLine();}
				}while(keyTK != 3);
				break;
			}
			case 5:{
				int keyTKKH;
				do {
					int keyCont1 = 1;
					System.out.println("Tim kiem theo:");
					System.out.println("[0]. ten khach hang");
					System.out.println("[1]. so dien thoat khach hang");
					System.out.println("[2]. quay lai");
					keyTKKH= sc.nextInt();
					sc.nextLine();
					switch(keyTKKH) {
					case 0:{
						System.out.print("Nhap ten khach hang: ");
						String tenKH = sc.nextLine();
						danhSachKhachHang.hienThiListTimKiem(danhSachKhachHang.timKiemKH(tenKH));
						break;
					}
					case 1:{
						System.out.print("Nhap so dien thoai khach hang: ");
						String sdtKH = sc.nextLine();
						danhSachKhachHang.hienThiListTimKiem(danhSachKhachHang.timKiemKH(sdtKH));
						break;
					}
					}
					System.out.print("Bam 0 de tiep tuc: ");
					while(keyCont1!=0) {keyCont1 = sc.nextInt(); sc.nextLine();}
				}while(keyTKKH != 2);
				break;
			}
			}
			System.out.print("Bam 0 de tiep tuc: ");
			while(keyCont!=0) {
				keyCont = sc.nextInt();
				sc.nextLine();
			}
		}while(keyCheckQL!=6);
	}
	
}
