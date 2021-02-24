
package OBJFrame;

public class Nv_trahang {

    private String Ngay_tra,Ma_NV,Ma_hang,Ma_NCC;
    private int Ma_HDT,Da_tra,SoluongT,Thanhtientra;
    public Nv_trahang() {
        
    }
    public Nv_trahang(String Ngay_tra,Integer Ma_HDT,Integer Da_tra,String Ma_NV,String Ma_hang,String Ma_NCC,Integer SoluongT,Integer Thanhtientra){

        this.Ngay_tra=Ngay_tra;
        this.Ma_HDT=Ma_HDT;
        this.Da_tra=Da_tra;
        this.Ma_NV=Ma_NV;
        this.Ma_hang=Ma_hang;
        this.Ma_NCC=Ma_NCC;
        this.SoluongT=SoluongT;
        this.Thanhtientra=Thanhtientra;
     }
    
    public String getMa_NV() {
            return Ma_NV;
    }
    public void setMa_NV(String Ma_NV) {
        this.Ma_NV = Ma_NV;
    }

    public String getNgay_tra() {
            return Ngay_tra;
    }
    public void setNgay_tra(String Ngay_tra) {
        this.Ngay_tra = Ngay_tra;
    }
    
    public Integer getMa_HDT() {
            return Ma_HDT;
    }
    public void setMa_HDT(Integer Ma_HDT) {
        this.Ma_HDT = Ma_HDT;
    }
    
    public Integer getDa_tra() {
            return Da_tra;
    }
    public void setDa_tra(Integer Da_tra) {
        this.Da_tra = Da_tra;
    }
    
        public String getMa_hang() {
            return Ma_hang;
    }
    public void setMa_hang(String Ma_hang) {
        this.Ma_hang = Ma_hang;
    }
    
        public String getMa_NCC() {
            return Ma_NCC;
    }
    public void setMa_NCC(String Ma_NCC) {
        this.Ma_NCC = Ma_NCC;
    }
    
        public Integer getSoluongT() {
            return SoluongT;
    }
    public void setSoluongT(Integer SoluongT) {
        this.SoluongT = SoluongT;
    }

        public Integer getThanhtientra() {
            return Thanhtientra;
    }
    public void setThanhtientra(Integer Thanhtientra) {
        this.Thanhtientra = Thanhtientra;
    }            
}
