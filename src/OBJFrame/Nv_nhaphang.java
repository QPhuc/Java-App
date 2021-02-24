package OBJFrame;

public class Nv_nhaphang {
    private String Ma_hang,Ten_hang,Ma_loaihang,Ten_loaihang,Ten_dvt,Ngay_nhap,Ma_NV,Ten_NCC,Ma_NCC;
    private int Giaban,Ma_dvt,DongiaN,SoluongN,Ma_HDN,Ma_CTN,Chietkhau,Da_tra,Thanhtiennhap;
     public Nv_nhaphang() {
        
    }
    public Nv_nhaphang(String Ma_hang,String Ten_hang,String Ma_loaihang,String Ten_loaihang,String Ten_dvt,Integer Giaban,
            Integer Ma_dvt,String Ngay_nhap,String Ma_NV,String Ten_NCC,String Ma_NCC,Integer DongiaN,Integer SoluongN,
            Integer Ma_HDN,Integer Ma_CTN,Integer Chietkhau,Integer Da_tra,Integer Thanhtiennhap,
            String Ngay_xuat,Integer Ma_HDX,Integer thanhtienxuat,Integer SoluongX,Integer Ma_CTX,String Ma_KH){
        this.Ma_hang = Ma_hang;
        this.Ten_hang = Ten_hang;
        this.Ma_loaihang = Ma_loaihang;
        this.Ten_loaihang = Ten_loaihang;
        this.Ten_dvt = Ten_dvt;
        this.Giaban = Giaban;
        this.Ma_dvt = Ma_dvt;
        this.Ngay_nhap = Ngay_nhap;
        this.Ma_NV = Ma_NV;
        this.Ten_NCC = Ten_NCC;
        this.Ma_NCC = Ma_NCC;
        this.DongiaN = DongiaN;
        this.SoluongN = SoluongN;
        this.Ma_HDN = Ma_HDN;
        this.Ma_CTN = Ma_CTN;
        this.Chietkhau = Chietkhau;
        this.Da_tra=Da_tra;
        this.Thanhtiennhap=Thanhtiennhap;
    }

    
    public String getMa_hang() {
        return Ma_hang;
    }
    public void setMa_hang(String Ma_hang) {
        this.Ma_hang = Ma_hang;
    }
    
        public String getTen_hang() {
            return Ten_hang;
    }
    public void setTen_hang(String Ten_hang) {
        this.Ten_hang = Ten_hang;
    }
    
        public String getMa_loaihang() {
            return Ma_loaihang;
    }
    public void setMa_loaihang(String Ma_loaihang) {
        this.Ma_loaihang = Ma_loaihang;
    }
    
        public String getTen_loaihang() {
            return Ten_loaihang;
    }
    public void setTen_loaihang(String Ten_loaihang) {
        this.Ten_loaihang = Ten_loaihang;
    }
    
        public String getTen_dvt() {
            return Ten_dvt;
    }
    public void setTen_dvt(String Ten_dvt) {
        this.Ten_dvt = Ten_dvt;
    }
    
        public Integer getGiaban() {
            return Giaban;
    }
    public void setGiaban(Integer Giaban) {
        this.Giaban = Giaban;
    }
        
        public Integer getMa_dvt() {
            return Ma_dvt;
    }
    public void setMa_dvt(Integer Ma_dvt) {
        this.Ma_dvt = Ma_dvt;
    }
    
    public String getNgay_nhap() {
            return Ngay_nhap;
    }
    public void setNgay_nhap(String Ngay_nhap) {
        this.Ngay_nhap = Ngay_nhap;
    }
    
    public String getMa_NV() {
            return Ma_NV;
    }
    public void setMa_NV(String Ma_NV) {
        this.Ma_NV = Ma_NV;
    }
    
    public String getTen_NCC() {
            return Ten_NCC;
    }
    public void setTen_NCC(String Ten_NCC) {
        this.Ten_NCC = Ten_NCC;
    }
    
    public String getMa_NCC() {
            return Ma_NCC;
    }
    public void setMa_NCC(String Ma_NCC) {
        this.Ma_NCC = Ma_NCC;
    }
    
        public Integer getDongiaN() {
            return DongiaN;
    }
    public void setDongiaN(Integer DongiaN) {
        this.DongiaN = DongiaN;
    }
    
        public Integer getSoluongN() {
            return SoluongN;
    }
    public void setSoluongN(Integer SoluongN) {
        this.SoluongN = SoluongN;
    }
    
        public Integer getMa_HDN() {
            return Ma_HDN;
    }
    public void setMa_HDN(Integer Ma_HDN) {
        this.Ma_HDN = Ma_HDN;
    }
    
        public Integer getMa_CTN() {
            return Ma_CTN;
    }
    public void setMa_CTN(Integer Ma_CTN) {
        this.Ma_CTN = Ma_CTN;
    }
    public Integer getChietkhau() {
            return Chietkhau;
    }
    public void setChietkhau(Integer Chietkhau) {
        this.Chietkhau = Chietkhau;
    }
    public Integer getDa_tra() {
            return Da_tra;
    }
    public void setDa_tra(Integer Da_tra) {
        this.Da_tra = Da_tra;
    }
    
    public Integer getThanhtiennhap() {
            return Thanhtiennhap;
    }
    public void setThanhtiennhap(Integer Thanhtiennhap) {
        this.Thanhtiennhap = Thanhtiennhap;
    }
}
