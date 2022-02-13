package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<SanPham> danhSachSP = new ArrayList<>();
        int n; // số lượng sản phẩm
        int luaChon;
        int[] Arrs; // lưu trữ số lượng sản phẩm
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Nhập vào danh sách sản phẩm .");
        System.out.println("2. Sắp xếp sản phẩm giảm dần theo giá sản .");
        System.out.println("3. Tìm và xóa sản phẩm theo tên. ");
        System.out.println("4. Xuất giá trị trung bình các sản phẩm .");
        System.out.println("5. Tìm và hiển thị sản phẩm theo tên .");
        System.out.println("6. Sửa thông tin sản phẩm theo tên .");
        System.out.println("7. Thoát chương trình .");

        do {
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1: {
                    System.out.print("Nhập vào số lượng sản phẩm: ");
                    n = Integer.parseInt(scanner.nextLine());
                    Arrs = new int[n];
                    for (int i = 0; i < Arrs.length; i++) {
                        SanPham sp = new SanPham();
                        System.out.println("Sản phẩm: " + (i + 1));
                        sp.NhapTT();
                        danhSachSP.add(sp);
                    }
                    break;
                }
                case 2: {
                    Collections.sort(danhSachSP, (SanPham sp1, SanPham sp2) -> {
                        if(sp1.getGia() < sp2.getGia()){
                            return 1;
                        }
                        else {
                            if (sp1.getGia() == sp2.getGia()){
                                return 0;
                            }
                            else {
                                return -1;
                            }
                        }
                    });
                    System.out.println("\t\t--- DANH SÁCH SAU KHI SẮP XẾP GIẢM DẦN THEO GIÁ ---");
                    System.out.printf("\n\t\t%-20s %-10s","Tên sản phẩm","Giá");
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        danhSachSP.get(i).HienThiTT();
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    String tenSP;
                    int dem = 0;
                    System.out.print("Tên sản phẩm cần xóa: ");
                    tenSP = scanner.nextLine();
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        if (tenSP.equalsIgnoreCase(danhSachSP.get(i).getTenSP())){
                            danhSachSP.remove(danhSachSP.get(i));
                            dem++;
                            break;
                        }
                    }
                    if (dem == 0){
                        System.out.println("Không có sản phẩm bạn cần xóa.");
                    }
                    System.out.println("\t\t--- DANH SÁCH SẢN PHẨM SAU KHI XÓA ---");
                    System.out.printf("\n\t\t%-20s %-10s","Tên sản phẩm","Giá");
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        danhSachSP.get(i).HienThiTT();
                    }
                    System.out.println();
                    break;
                }
                case 4: {
                    double GTTB = 0;
                    int dem = 0;
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        GTTB = GTTB + danhSachSP.get(i).getGia();
                        dem++;
                    }
                    GTTB = GTTB/dem;
                    System.out.println("Giá trị trung bình của sản phẩm là : " + GTTB);
                    System.out.println();
                    break;
                }
                case 5: {
                    String tenSP;
                    int dem = 0;
                    System.out.print("Nhập vào tên cần tìm kiếm : ");
                    tenSP = scanner.nextLine();
                    System.out.println("\t\t--- DANH SÁCH SẢN PHẨM THEO TÌM KIẾM ---");
                    System.out.printf("\n\t\t%-20s %-10s","Tên sản phẩm","Giá");
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        if (tenSP.equalsIgnoreCase(danhSachSP.get(i).getTenSP())){
                            danhSachSP.get(i).HienThiTT();
                            dem ++;
                        }
                    }
                    if (dem == 0){
                        System.out.println("Không có sản phẩm theo tìm kiếm của bạn .");
                    }
                    System.out.println();
                    break;
                }
                case 6: {
                    String tenSP;
                    System.out.print("Nhập vào tên sản phẩm cần sửa: ");
                    tenSP = scanner.nextLine();
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        if (tenSP.equalsIgnoreCase(danhSachSP.get(i).getTenSP())){
                            danhSachSP.get(i).NhapTT();
                        }
                    }
                    System.out.println("\t\t--- DANH SÁCH SẢN PHẨM SAU KHI SỬA ---");
                    System.out.printf("\n\t\t%-20s %-10s","Tên sản phẩm","Giá");
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        danhSachSP.get(i).HienThiTT();
                    }
                    System.out.println();
                    break;
                }
                case 7: {
                    break;
                }
            }
        } while (luaChon != 7);
    }
}
