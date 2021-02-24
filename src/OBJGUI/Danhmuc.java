
package OBJGUI;


public class Danhmuc {
    private String Ma_NV,Hoten,Diachi,Ngaysinh;
    private int Gioitinh,SDT;

    public Danhmuc() {
    }
     public Danhmuc(String Ma_NV,String Hoten,String Diachi,String Ngaysinh,Integer Gioitinh,Integer SDT){
         this.Ma_NV = Ma_NV;
         this.Hoten = Hoten;
         this.Diachi = Diachi;
         this.Ngaysinh = Ngaysinh;
         this.Gioitinh = Gioitinh;
         this.SDT = SDT;
     }
     
    public String getMa_NV() {
        return Ma_NV;
    }
    public void setMa_NV(String Ma_NV) {
        this.Ma_NV = Ma_NV;
    }
    
    public String getHoten() {
        return Hoten;
    }
    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }
    
        public String getDiachi() {
        return Diachi;
    }
    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }
    
        public String getNgaysinh() {
        return Ngaysinh;
    }
    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    
        public Integer getGioitinh() {
        return Gioitinh;
    }
    public void setGioitinh(Integer Gioitinh) {
        this.Gioitinh = Gioitinh;
    }
    
        public Integer getSDT() {
        return SDT;
    }
    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }
    
}
