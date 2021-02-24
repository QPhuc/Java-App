
package OBJFrame;

public class Dm_nhacc {
        private String Ma_NCC,Ten_NCC,Diachi_NCC;
        private int Nghi_CCap,SDT_NCC,No_NCC;
     public Dm_nhacc() {
    }
     public Dm_nhacc(String Ma_NCC,String Ten_NCC,String Diachi_NCC,Integer Nghi_CCap,Integer SDT_NCC,Integer No_NCC){
         this.Ma_NCC = Ma_NCC;
         this.Ten_NCC = Ten_NCC;
         this.Nghi_CCap = Nghi_CCap;
         this.Diachi_NCC = Diachi_NCC;
         this.SDT_NCC = SDT_NCC;
         this.No_NCC = No_NCC;
     }
     
    public String getMa_NCC() {
        return Ma_NCC;
    }
    public void setMa_NCC(String Ma_NCC) {
        this.Ma_NCC = Ma_NCC;
    }
    
        public String getTen_NCC() {
            return Ten_NCC;
    }
    public void setTen_NCC(String Ten_NCC) {
        this.Ten_NCC = Ten_NCC;
    }
    
        public String getDiachi_NCC() {
            return Diachi_NCC;
    }
    public void setDiachi_NCC(String Diachi_NCC) {
        this.Diachi_NCC = Diachi_NCC;
    }
    
        public Integer getNghi_CCap() {
            return Nghi_CCap;
    }
    public void setNghi_CCap(Integer Nghi_CCap) {
        this.Nghi_CCap = Nghi_CCap;
    }   
    
        public Integer getSDT_NCC() {
            return SDT_NCC;
    }
    public void setSDT_NCC(Integer SDT_NCC) {
        this.SDT_NCC = SDT_NCC;
    } 
    public Integer getNo_NCC() {
            return No_NCC;
    }
    public void setNo_NCC(Integer No_NCC) {
        this.No_NCC = No_NCC;
    }
}
