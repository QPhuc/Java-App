
package OBJGUI;

public class Nghiepvu {
 
    //bán hàng
    private String Ngay_xuat,Ma_KH,Ma_hang,Ma_NV;
    private int Ma_HDX,Thanhtienxuat,SoluongX,Ma_CTX,Da_tra,Giam_gia;
    public Nghiepvu() {
        
    }
    public Nghiepvu(
            String Ngay_xuat,Integer Ma_HDX,Integer Thanhtienxuat,Integer SoluongX,Integer Ma_CTX,String Ma_KH,String Ma_hang
            ,String Ma_NV,Integer Da_tra,Integer Giam_gia){

        this.Ngay_xuat=Ngay_xuat;
        this.Ma_HDX=Ma_HDX;
        this.Thanhtienxuat=Thanhtienxuat;
        this.SoluongX=SoluongX;
        this.Ma_CTX=Ma_CTX;
        this.Ma_KH= Ma_KH;
        this.Ma_hang = Ma_hang;
        this.Ma_NV = Ma_NV;
        this.Da_tra = Da_tra;
        this.Giam_gia = Giam_gia;
     }
 
    //bán hàng
    public String getMa_NV() {
            return Ma_NV;
    }
    public void setMa_NV(String Ma_NV) {
        this.Ma_NV = Ma_NV;
    }
    public String getMa_hang() {
        return Ma_hang;
    }
    public void setMa_hang(String Ma_hang) {
        this.Ma_hang = Ma_hang;
    }
    public String getNgay_xuat() {
            return Ngay_xuat;
    }
    public void setNgay_xuat(String Ngay_xuat) {
        this.Ngay_xuat = Ngay_xuat;
    }
    
        public Integer getMa_HDX() {
            return Ma_HDX;
    }
    public void setMa_HDX(Integer Ma_HDX) {
        this.Ma_HDX = Ma_HDX;
    }
    
        public Integer getThanhtienxuat() {
            return Thanhtienxuat;
    }
    public void setThanhtienxuat(Integer Thanhtienxuat) {
        this.Thanhtienxuat = Thanhtienxuat;
    }
    
        public Integer getSoluongX() {
            return SoluongX;
    }
    public void setSoluongX(Integer SoluongX) {
        this.SoluongX = SoluongX;
    }
    
        public Integer getMa_CTX() {
            return Ma_CTX;
    }
    public void setMa_CTX(Integer Ma_CTX) {
        this.Ma_CTX = Ma_CTX;
    }
    
    public String getMa_KH() {
            return Ma_KH;
    }
    public void setMa_KH(String Ma_KH) {
        this.Ma_KH = Ma_KH;
    }
    
        public Integer getDa_tra() {
            return Da_tra;
    }
    public void setDa_tra(Integer Da_tra) {
        this.Da_tra = Da_tra;
    }
    
        public Integer getGiam_gia() {
            return Giam_gia;
    }
    public void setGiam_gia(Integer Giam_gia) {
        this.Giam_gia = Giam_gia;
    }
}
