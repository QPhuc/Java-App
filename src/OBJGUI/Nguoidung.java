
package OBJGUI;

public class Nguoidung {
    private String Taikhoan,Matkhau;
    private int quyen;
     public Nguoidung() {
    }
     public Nguoidung(String Taikhoan,String Matkhau,Integer quyen){
         this.Taikhoan = Taikhoan;
         this.Matkhau = Matkhau;
         this.quyen = quyen;

     }
     
    public String getTaikhoan() {
        return Taikhoan;
    }
    public void setTaikhoan(String Taikhoan) {
        this.Taikhoan = Taikhoan;
    }
    
        public String getMatkhau() {
        return Matkhau;
    }
    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }
    

        public Integer getquyen() {
        return quyen;
    }
    public void setquyen(Integer quyen) {
        this.quyen = quyen;
    }
}
