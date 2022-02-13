package com.company;

import java.util.Scanner;

public class SanPham {
    private String tenSP;
    private double gia;

    SanPham() {

    }

    public SanPham(String tenSP, double gia) {
        this.tenSP = tenSP;
        this.gia = gia;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void NhapTT() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên sản phẩm: ");
        tenSP = scanner.nextLine();
        System.out.print("Giá: ");
        gia = Double.parseDouble(scanner.nextLine());
    }

    public void HienThiTT() {
        System.out.printf("\n\t\t%-20s %-10.3f", tenSP, gia);
    }
}
