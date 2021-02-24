
package OBJFrame;

public class Dm_khachhang {
    private String Ten_KH,Diachi;
    private int SDT,No_dau,Ma_KH;
    public Dm_khachhang() {
    }
     public Dm_khachhang(Integer Ma_KH,String Ten_KH,String Diachi,Integer SDT,Integer No_dau){
         this.Ma_KH = Ma_KH;
         this.Ten_KH = Ten_KH;
         this.Diachi = Diachi;
         this.SDT = SDT;
         this.No_dau = No_dau;

     }
     
    public Integer getMa_KH() {
        return Ma_KH;
    }
    public void setMa_KH(Integer Ma_KH) {
        this.Ma_KH = Ma_KH;
    }
    
        public String getTen_KH() {
        return Ten_KH;
    }
    public void setTen_KH(String Ten_KH) {
        this.Ten_KH = Ten_KH;
    }
    
            public String getDiachi() {
        return Diachi;
    }
    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }
    
            public Integer getSDT() {
        return SDT;
    }
    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }
    
            public Integer getNo_dau() {
        return No_dau;
    }
    public void setNo_dau(Integer No_dau) {
        this.No_dau = No_dau;
    }
}
